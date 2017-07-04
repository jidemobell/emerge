/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.rest.model.Groups;
import com.emerge.ocs.rest.model.Modulation;
import com.emerge.ocs.rest.model.Prefix;
import com.emerge.ocs.rest.model.SpecialDay;
import com.emerge.ocs.rest.model.Tariff;
import com.emerge.ocs.rest.model.TariffVersions;
import com.emerge.ocs.rest.model.Zones;
import java.util.Date;

/**
 *
 * @author Yusuf
 */
public class PayphoneGroupDAOSub extends PayphoneGroupDAO {

    @Override
    protected final int search() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected int insertIntoGroups(int tariff_version_id, String name,
            String description) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected int insertIntoZones(int tariff_version_id, String name,
            long group_id, String description) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
    @Override
    protected int findZoneId(int version) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int updateGroupById(long id, String name, String description) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    Groups searchGroupById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int deleteGroupById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int updateZoneById(long id, String name, String description, long group_id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    Zones searchZoneById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int deleteZoneById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    Prefix searchPrefixById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int deletePrefixById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected int insertIntoSpecialDay(int day, int month, int year, String description) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int updateSpecialDayById(long id, int day, int month, int year, String description) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    SpecialDay searchSpecialDayById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int deleteSpecialDayById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   
    @Override
    Modulation searchModulationById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int deleteModulationById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    Tariff searchTariffById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int deleteTariffById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


    @Override
    protected int insertIntoTariffs(String name, long groupid, 
            long modulationTypeId, long initialDuration, long recurrentDuration,
            long tariffVersionId, long profileId, boolean status, 
            double initialCost, double setupCost, double recurrentCost) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int updateTariffById(long id, String name, long groupId, 
            long modulationTypeId, long initialDuration, long recurrentDuration,
            boolean status, long profileId, long tariffVersionId, 
            double setupCost, double recurrentCost, double initialCost) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected int insertIntoPrefixes(int tariffVersionId, int zoneId, 
            long value, String description, String country) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int updatePrefixById(long id, String description, String country, 
            long value) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected int insertIntoModulation(String day, String name, 
            long modulationTypeId, int endTime, long profileId, 
            long tariffVersionId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    int updateModulationById(long id, String day, String name, int endTime,
            long modulationTypeId, long profileId, long tariffVersionId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected int insertIntoPrefixesCloneNew(long tariffVersionId, 
            long oldtariffVersionId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected int insertIntoModulationsCloneNew(long tariffVersionId, 
            long oldtariffVersionId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected int insertIntoGroupsCloneNew(long tariffVersionId, 
            long oldtariffVersionId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected int insertIntoZonesCloneNew(long tariffVersionId, 
            long oldtariffVersionId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected long insertIntoTariffVersionsClone(String description, Date activationDate, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    TariffVersions searchTariffVersionsById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected int insertIntoTariffCloneNew(long tariffVersionId, long oldtariffVersionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




 



}
