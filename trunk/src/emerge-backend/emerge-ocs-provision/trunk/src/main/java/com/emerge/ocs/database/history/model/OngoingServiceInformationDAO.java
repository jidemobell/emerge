/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.history.model;

import com.emerge.ocs.database.history.HDBResource;
import com.emerge.ocs.rest.model.OngoingServiceInformation;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.IndexNotFoundException;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

/**
 *
 * @author goodson
 */
public class OngoingServiceInformationDAO {

    private static final String documentName = "ongoing_service_call_records";

    public OngoingServiceInformationDAO() {
        
    }

    public IndexResponse create(OngoingServiceInformation onGoingServiceInformation) throws UnknownHostException {
        IndexRequest indexRequest = new IndexRequest("ocs", OngoingServiceInformationDAO.documentName, UUID.randomUUID().toString());
        indexRequest.source(onGoingServiceInformation);
        return HDBResource.getClient().index(indexRequest).actionGet();        
    }

    public Map<String, Object> find(Long offset, Long limit, Long payphoneServiceId, Long customerId, String username, String IMEI, String destinationMsisdn, String originMsisdn, String iccid, Long minDuration) throws UnknownHostException, IndexNotFoundException {
        Map<String, Object> result = new HashMap<>();
        Client client = HDBResource.getClient();

        SearchRequestBuilder srb = client.prepareSearch("ocs").setTypes(OngoingServiceInformationDAO.documentName);

        QueryBuilder payphoneIdQuery = null;

        if (payphoneServiceId != null && payphoneServiceId  > 0) {
            payphoneIdQuery = QueryBuilders.matchQuery("payphoneServiceId", payphoneServiceId);
        }

        QueryBuilder customerIdQuery = null;
        if (customerId != null && customerId > 0) {
            customerIdQuery = QueryBuilders.matchQuery("customerId", customerId);
        }


        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (payphoneIdQuery != null) {
            srb.setQuery(payphoneIdQuery);
        } else if (customerIdQuery != null) {    // just trying the else-if on 2 variables
            srb.setQuery(customerIdQuery);
        } else if (payphoneIdQuery != null && customerIdQuery != null) {
            boolQuery
                    .must(payphoneIdQuery)
                    .must(customerIdQuery);
            srb.setQuery(boolQuery);
        } else {
            
            if (username != null && username.trim().length() > 0) {
                boolQuery.must(QueryBuilders.matchQuery("username", username));
            }
            
           
            if (minDuration != null) {
                boolQuery.must(QueryBuilders.matchQuery("duration", minDuration));
            }

            
            if (IMEI != null && IMEI.trim().length() > 0) {
                boolQuery.must(QueryBuilders.matchQuery("imei1", IMEI));
            }
            
            if (IMEI != null && IMEI.trim().length() > 0) {
                boolQuery.must(QueryBuilders.matchQuery("imei2", IMEI));
            }

            if (destinationMsisdn != null && destinationMsisdn.trim().length() > 0) {
                boolQuery.must(QueryBuilders.matchQuery("destinationMsisdn", destinationMsisdn));
            }

            if (originMsisdn != null && originMsisdn.trim().length() > 0) {
                boolQuery.must(QueryBuilders.matchQuery("originMsisdn", originMsisdn));
            }

            if (iccid != null && iccid.trim().length() > 0) {
                boolQuery.must(QueryBuilders.matchQuery("iccid", iccid));
            }

            srb.setQuery(boolQuery);
        }
        
        SearchResponse searchResponse = srb.execute().actionGet();
        SearchHit[] hits = searchResponse.getHits().getHits();
        result.put("ongoing_service_call_records", hits);
        return result;
    }
}
