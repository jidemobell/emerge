/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud;
import io.swagger.model.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;


/**
 *
 * @author FOLARIN
 */
public class ContactMapper implements ResultSetMapper<Contact> {
    @Override
    public Contact map(int i, ResultSet rs, StatementContext sc) throws SQLException {
        Contact contacts = new Contact();
        contacts.setContactType(rs.getString("contact_type"));
        contacts.setContactName(rs.getString("contact_name"));
        contacts.setContactEmail(rs.getString("contact_email"));
        contacts.setContactPhone(rs.getString("contact_phone"));
        contacts.setContactFax(rs.getString("contact_fax"));
        contacts.setId(rs.getLong("id"));
        contacts.setBillingAddressId(rs.getLong("customer_address_id"));
        contacts.setNotifyByEmail(rs.getBoolean("notify_by_email"));
        contacts.notifyBySms(rs.getBoolean("notify_by_sms"));
        contacts.sendInvoiceByEmail(rs.getBoolean("send_invoice_by_email"));
        //contacts.setMainContact(rs.getBoolean("main_contact"));


        
        return contacts;
    }
    
}
