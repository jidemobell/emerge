/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.elastic.model;

/**
 *
 * @author jide
 */
public class ServiceAndTariff {
    
    private OngoingServiceInformation ongoingServiceInformation;
    private Tariffs tariff;

    public OngoingServiceInformation getOngoingServiceInformation() {
        return ongoingServiceInformation;
    }

    public void setOngoingServiceInformation(OngoingServiceInformation ongoingServiceInformation) {
        this.ongoingServiceInformation = ongoingServiceInformation;
    }

    public Tariffs getTariff() {
        return tariff;
    }

    public void setTariff(Tariffs tariff) {
        this.tariff = tariff;
    }
    
}
