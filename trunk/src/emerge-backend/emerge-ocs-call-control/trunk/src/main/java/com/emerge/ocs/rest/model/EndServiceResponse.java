/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.rest.model;

import java.util.Date;

/**
 *
 * @author Kingsley
 */
public class EndServiceResponse {

    private String origin;
    private String destination;

    public Integer getTariff_id() {
        return tariff_id;
    }

    public void setTariff_id(Integer tariff_id) {
        this.tariff_id = tariff_id;
    }
    private Integer tariff_id;
    private Date call_authorization_time;
    private Date start_time;
    private Date call_answer_time;

    public String getDestination_group() {
        return destination_group;
    }

    public void setDestination_group(String destination_group) {
        this.destination_group = destination_group;
    }

    private String destination_group;
    private Date call_end_time;
    private Integer call_duration;
    private Integer billed_duration;
    private Float billed_amount;
    private Float initial_balance;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getCall_authorization_time() {
        if (call_authorization_time != null) {
            return (Date) call_authorization_time.clone();
        }
        
        return new Date();
    }

    public void setCall_authorization_time(Date call_authorization_time) {
        if (call_authorization_time != null) {
            this.call_authorization_time = (Date) call_authorization_time.clone();
        }
    }

    public Date getStart_time() {
        if (start_time != null) {
            return (Date) start_time.clone();
        }
        
        return new Date();
    }

    public void setStart_time(Date start_time) {
        if (start_time != null) {
            this.start_time = (Date) start_time.clone();
        }
        
        
    }

    public Date getCall_answer_time() {
        if (call_answer_time != null) {
            return (Date) call_answer_time.clone();
        }
        
        return new Date();
    }

    public void setCall_answer_time(Date call_answer_time) {
        if (call_answer_time != null){
            this.call_answer_time = (Date) call_answer_time.clone();
        }
    }

    public Date getCall_end_time() {
        if (call_end_time != null) {
            return (Date) call_end_time.clone();
        }
        
        return new Date();
    }

    public void setCall_end_time(Date call_end_time) {
        if (call_end_time != null){
            this.call_end_time = (Date) call_end_time.clone();
        }
    }

    public Integer getCall_duration() {
        return call_duration;
    }

    public void setCall_duration(Integer call_duration) {
        this.call_duration = call_duration;
    }

    public Integer getBilled_duration() {
        return billed_duration;
    }

    public void setBilled_duration(Integer billed_duration) {
        this.billed_duration = billed_duration;
    }

    public Float getBilled_amount() {
        return billed_amount;
    }

    public void setBilled_amount(Float billed_amount) {
        this.billed_amount = billed_amount;
    }

    public Float getInitial_balance() {
        return initial_balance;
    }

    public void setInitial_balance(Float initial_balance) {
        this.initial_balance = initial_balance;
    }

}
