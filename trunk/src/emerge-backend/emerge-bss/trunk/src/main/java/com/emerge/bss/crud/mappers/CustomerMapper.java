/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author akin
 */
public class CustomerMapper implements ResultSetMapper<CustomerExtended> {

    @Override
    public CustomerExtended map(int index, ResultSet r, StatementContext ctx) throws SQLException {

        CustomerExtended cu = new CustomerExtended();
        cu.setCountry(r.getString("country"));
        cu.setName(r.getString("name"));
        cu.setWebsite(r.getString("website"));
        cu.setPrivateNotes(r.getString("private_notes"));
        cu.setPublicNotes(r.getString("public_notes"));
        cu.setFiscalNumber(r.getString("fiscal_number"));
        cu.setStatus(r.getString("status"));
//        cu.setTaxExemptionCertificates(r.getString("taxExemptionCertificate"));
        String tags = r.getString("tags");
        cu.setEmail(r.getString("email"));
        cu.setPhoneNumber(r.getString("telephone_number"));
//        if (tags != null) {
//            cu.setTags(Arrays.asList(tags.split(",")));
//        }
        cu.setTags(tags);
        String exemptionCertificates = r.getString("tax_exemption_certificates");
//        if (exemptionCertificate != null) {
//            cu.setTaxExemptionCertificate(Arrays.asList(exemptionCertificate.split(",")));
//        }
        cu.setTaxExemptionCertificates(exemptionCertificates);
        cu.setId(r.getLong("id"));
        cu.setDbCdate(r.getDate("db_cdate"));

        return cu;
    }

}
