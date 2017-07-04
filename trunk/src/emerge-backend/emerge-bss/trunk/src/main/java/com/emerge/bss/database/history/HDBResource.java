/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.database.history;

import com.edeh.chigozie.elasticsearch.client.helper.ElasticSearchCRUD;
import com.edeh.chigozie.elasticsearch.client.helper.ElasticSearchClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.api.impl.BssContractsApiServiceImpl;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

/**
 *
 * @author goodson
 */
public class HDBResource {

private static Client hdb = null;
    private final static int HDB_ERROR = 500;
    private final static int HDB_PORT = 9200;
    private final static String HBD_URL = "192.168.41.150";

    /**
     *
     * @return instance of an Elastic DB Connection Client
     * @throws UnknownHostException Host not known exception
     */
    public static Client getClient() throws UnknownHostException {
        if (hdb == null) {
//            initClient();
        }

        hdb = TransportClient
                .builder()
                .build()
                .addTransportAddress(new InetSocketTransportAddress(
                        InetAddress.getByName(HBD_URL), HDB_PORT));

        return hdb;
    }

    /**
     *
     * @param object Database object to store
     * @param dbName The name of the database / document
     * @param logType The log type. One of "create", "update", "delete"
     * @return response code
     */
    public static int put(final Object object, final String dbName,
            final String logType) {

        Map<String, Object> map = new HashMap<>();
        map.put("createdAt", new Date());
        map.put("data", object);
        map.put("logType", logType);

        try {
            RestClient restClient = ElasticSearchClient
                    .getHTTPClient(HBD_URL, HDB_PORT);

            return ElasticSearchCRUD.createRecordWithObject(map,
                    restClient, "bss", dbName)
                    .getStatusLine().getStatusCode();
        } catch (UnknownHostException | JsonProcessingException ex) {
             Logger.getLogger(HDBResource.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            
        }

        return HDB_ERROR;
    }
}
