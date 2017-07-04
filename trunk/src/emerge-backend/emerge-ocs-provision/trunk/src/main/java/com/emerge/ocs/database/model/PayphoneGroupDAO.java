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
import com.emerge.ocs.rest.util.JdbiHelper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 *
 * @author Yusuf
 */
public abstract class PayphoneGroupDAO {

    DBI dbi;

    public PayphoneGroupDAO() {
        dbi = JdbiHelper.getDBI();
    }

    @SqlQuery("SELECT id  FROM tariff_versions where status = 'ACTIVE' ")
    protected abstract int search();

    @SqlUpdate("INSERT into groups(name , description,tariff_version_id)"
            + " VALUES (:name ,:description,:tariff_version_id)")
    @GetGeneratedKeys
    protected abstract int insertIntoGroups(
            @Bind("tariff_version_id") int tariffVersionId,
            @Bind("name") String name,
            @Bind("description") String description);

    @Transaction
    public final long insertIntoGroupTransaction(final String name,
            final String description) {
        int tariffVersionId = search();
        long generatedId = insertIntoGroups(tariffVersionId, name,
                description);
        return generatedId;

    }

    public final Groups createGroups(Groups groups) throws Exception {
        try {
            String groupName = groups.getName();
            String groupDescription = groups.getDescription();
            PayphoneGroupDAO payphoneTariffDAO
                    = dbi.onDemand(PayphoneGroupDAO.class);
            long id = payphoneTariffDAO.insertIntoGroupTransaction(groupName,
                    groupDescription);
            if (id != 0) {
                groups.setId(id);
            }
        } catch (Exception e) {
            throw e;
        }
        return groups;
    }

    @SqlUpdate("INSERT into zones(name , group_id,description,"
            + "tariff_version_id)"
            + " VALUES (:name ,:group_id,:description,:tariff_version_id)")
    @GetGeneratedKeys
    protected abstract int insertIntoZones(
            @Bind("tariff_version_id") int tariffVersionId,
            @Bind("name") String name,
            @Bind("group_id") long groupId,
            @Bind("description") String description);

    @Transaction
    public final long insertIntoZonesTransaction(final String name,
            final long groupId,
            final String description) {
        int tariffVersionId = search();
        long generatedId = insertIntoZones(tariffVersionId, name,
                groupId, description);
        return generatedId;
    }

    /**
     *
     * @param zone zone object
     * @return new zone
     * @throws Exception DB exception
     */
    public final Zones createZone(final Zones zone) throws Exception {
        String zoneDescription = zone.getDescription();
        long groupId = zone.getGroupId();
        String zoneName = zone.getName();
        try {
            PayphoneGroupDAO payphoneGroupDAO
                    = dbi.onDemand(PayphoneGroupDAO.class);
            long id = payphoneGroupDAO.insertIntoZonesTransaction(zoneName,
                    groupId, zoneDescription);
            zone.setId(id);
        } catch (Exception ex) {
            throw ex;
        }
        return zone;
    }

    @SqlQuery("SELECT id  FROM zones WHERE"
            + " tariff_version_id = :tariff_version_id ")
    protected abstract int findZoneId(@Bind("tariff_version_id") int tariff_version_id);

    @SqlUpdate("INSERT into prefixes(value ,country ,description,"
            + " tariff_version_id,zone_id)"
            + " VALUES (:value ,:country,:description,"
            + ":tariff_version_id,:zone_id)")

    @GetGeneratedKeys
    protected abstract int insertIntoPrefixes(
            @Bind("tariff_version_id") int tariffVersionId,
            @Bind("zone_id") int zoneId,
            @Bind("value") long value,
            @Bind("description") String description,
            @Bind("country") String country);

    @Transaction
    public long insertIntoPrefixesTransaction(final long value,
            final String description, final String country) {
        int tariffVersionId = search();
        int zoneId = findZoneId(tariffVersionId);
        long generatedId = insertIntoPrefixes(tariffVersionId, zoneId, value,
                description, country);
        return generatedId;
    }

    public final Prefix createPrefixes(Prefix prefixes) throws Exception {
        try {
            String groupCountry = prefixes.getCountry();
            long value = prefixes.getValue();
            String groupDescription = prefixes.getDescription();
            PayphoneGroupDAO payphoneGroupDAO
                    = dbi.onDemand(PayphoneGroupDAO.class);
            long id = payphoneGroupDAO.insertIntoPrefixesTransaction(value,
                    groupDescription, groupCountry);
            if (id != 0) {
                prefixes.setId(id);
            }
        } catch (Exception e) {
            throw e;
        }
        return prefixes;
    }

    @SqlUpdate("UPDATE groups SET name = :name , description = :description"
            + " WHERE id = :id ")
    abstract int updateGroupById(
            @Bind("id") long id,
            @Bind("name") String name,
            @Bind("description") String description
    );

    @Transaction
    public void updateGroupByIdTransaction(final String name,
            final String description) {
        int tariffVersionId = search();
        updateGroupById(tariffVersionId, name, description);
    }

    public final int updateGroupById(final long id, final String umUserHash,
            final String umSessionID, final String umDomain,
            final Groups group) {
        Handle handle = null;
        int result = 0;
        try {
            String description = group.getDescription();
            String name = group.getName();

            handle = dbi.open();
            PayphoneGroupDAO payphoneGroupDAO
                    = handle.attach(PayphoneGroupDAO.class);

            result = payphoneGroupDAO.updateGroupById(id, name, description);

        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        return result;
    }

    @SqlQuery("SELECT id,name,description "
            + "FROM groups WHERE id = :id AND enum_status_id <> 2")
    @Mapper(GroupMapper.class)
    abstract Groups searchGroupById(@Bind("id") long id);

    public final Groups searchGroupById(final String umUserHash,
            final String umSessionID, final String umDomain, final long id) {

        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        Groups groups = payphoneDAOInterface.searchGroupById(id);

        return groups;

    }

    @SqlUpdate("UPDATE groups SET enum_status_id = 2 WHERE id = :id")
    @Mapper(GroupMapper.class)
    abstract int deleteGroupById(@Bind("id") Long id);

    public final int deleteGroupById(final Long id, final String umUserHash,
            final String umSessionID, final String umDomain) {

        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        int result = payphoneDAOInterface.deleteGroupById(id);

        return result;
    }

    @SqlUpdate("UPDATE zones SET name = :name , description = :description"
            + " , group_id = :group_id  WHERE id = :id ")
    abstract int updateZoneById(
            @Bind("id") long id,
            @Bind("name") String name,
            @Bind("description") String description,
            @Bind("group_id") long group_id
    );

    @Transaction
    public int updateZoneByIdTransaction(long id, final String description,
            final String name, final long groupId) {
        int result = updateZoneById(id, name, description, groupId);
        return result;
    }

    public final int updateZoneById(final Long id, final String umUserHash,
            final String umSessionID, final String umDomain, final Zones zone) {

        int response = 0;
        Handle handle = null;
        try {
            String description = zone.getDescription();
            String name = zone.getName();
            long groupId = zone.getGroupId();

            handle = dbi.open();
            PayphoneGroupDAO payphoneGroupDAO
                    = handle.attach(PayphoneGroupDAO.class);
            response = payphoneGroupDAO.updateZoneByIdTransaction(id,
                    description, name, groupId);

        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        return response;
    }

    @SqlQuery("SELECT id,name,description , group_id "
            + "FROM zones WHERE id = :id and enum_status_id <> 2")
    @Mapper(ZoneMapper.class)
    abstract Zones searchZoneById(@Bind("id") long id);

    public final Zones searchZoneById(final String umUserHash,
            final String umSessionID, final String umDomain, final Long id) {
        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        Zones zones = payphoneDAOInterface.searchZoneById(id);
        return zones;
    }

    @SqlUpdate("UPDATE zones SET enum_status_id = 2 WHERE id = :id")
    @Mapper(GroupMapper.class)
    abstract int deleteZoneById(@Bind("id") Long id);

    public final int deleteZoneById(final Long id, final String umUserHash,
            final String umSessionID, final String umDomain) {

        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        int result = payphoneDAOInterface.deleteZoneById(id);

        return result;
    }

    @SqlUpdate("UPDATE prefixes SET  description = :description "
            + " ,value =:value  , country = :country "
            + " WHERE id = :id ")
    abstract int updatePrefixById(
            @Bind("id") long id,
            @Bind("description") String description,
            @Bind("country") String country,
            @Bind("value") long value
    );

    @Transaction
    public int updatePrefixByIdTransaction(long id, final String description,
            final String country, final long value, final long zoneId) {
        int result = updatePrefixById(id, description, country, value);
        return result;
    }

    public final int updatePrefixById(final Long id, final String umUserHash,
            final String umSessionID,
            final String umDomain, final Prefix prefix) {

        int response = 0;
        Handle handle = null;
        try {
            String description = prefix.getDescription();
            String country = prefix.getCountry();
            long value = prefix.getValue();
            long zoneId = prefix.getId();
            handle = dbi.open();
            PayphoneGroupDAO payphoneGroupDAO
                    = handle.attach(PayphoneGroupDAO.class);
            response = payphoneGroupDAO.updatePrefixByIdTransaction(id,
                    description, country, value, zoneId);
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        return response;
    }

    @SqlQuery("SELECT id,value,zone_id,country ,description "
            + "FROM prefixes WHERE id = :id and enum_status_id <> 2")
    @Mapper(PrefixMapper.class)
    abstract Prefix searchPrefixById(@Bind("id") long id);

    public final Prefix searchPrefixById(final String umUserHash,
            final String umSessionID, final String umDomain, final Long id) {
        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        Prefix prefix = payphoneDAOInterface.searchPrefixById(id);
        return prefix;
    }

    @SqlUpdate("UPDATE prefixes SET enum_status_id = 2 WHERE id = :id")
    @Mapper(PrefixMapper.class)
    abstract int deletePrefixById(@Bind("id") Long id);

    public final int deletePrefixById(final Long id, final String umUserHash,
            final String umSessionID, final String umDomain) {

        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        int result = payphoneDAOInterface.deletePrefixById(id);

        return result;
    }

    @SqlUpdate("INSERT into special_days  (day ,month,year,description)"
            + " VALUES (:day,:month,:year,:description)")
    @Transaction
    @GetGeneratedKeys
    protected abstract int insertIntoSpecialDay(
            @Bind("day") int day,
            @Bind("month") int month,
            @Bind("year") int year,
            @Bind("description") String description);

    public final SpecialDay createSpecialDay(SpecialDay specialDay)
            throws Exception {
        try {
            int day = specialDay.getDay();
            int month = specialDay.getMonth();
            int year = specialDay.getYear();
            String description = specialDay.getDescription();
            PayphoneGroupDAO payphoneGroupDAO
                    = dbi.onDemand(PayphoneGroupDAO.class);
            long id = payphoneGroupDAO.insertIntoSpecialDay(day, month,
                    year, description);
            if (id != 0) {
                specialDay.setId(id);
            }
        } catch (Exception e) {
            throw e;
        }
        return specialDay;
    }

    @SqlUpdate("UPDATE special_days SET day = :day , description = :description"
            + " , month = :month , year =:year  WHERE id = :id ")
    abstract int updateSpecialDayById(
            @Bind("id") long id,
            @Bind("day") int day,
            @Bind("month") int month,
            @Bind("year") int year,
            @Bind("description") String description
    );

    public final int updateSpecialDayById(final Long id,
            final String umUserHash,
            final String umSessionID, final String umDomain,
            final SpecialDay specialDay) {

        int response = 0;
        Handle handle = null;
        try {
            String description = specialDay.getDescription();
            int day = specialDay.getDay();
            int month = specialDay.getMonth();
            int year = specialDay.getYear();
            handle = dbi.open();
            PayphoneGroupDAO payphoneGroupDAO
                    = handle.attach(PayphoneGroupDAO.class);
            response = payphoneGroupDAO.updateSpecialDayById(id, day,
                    month, year, description);
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        return response;
    }

    @SqlQuery("SELECT id,day,month,year, description "
            + " FROM special_days WHERE id = :id and enum_status_id <> 2")
    @Mapper(SpecialDayMapper.class)
    abstract SpecialDay searchSpecialDayById(@Bind("id") long id);

    public final SpecialDay searchSpecialDayById(final String umUserHash,
            final String umSessionID, final String umDomain, final Long id) {
        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        SpecialDay specialDay = payphoneDAOInterface.searchSpecialDayById(id);
        return specialDay;
    }

    @SqlUpdate("UPDATE special_days SET enum_status_id = 2 WHERE id = :id")
    @Mapper(SpecialDayMapper.class)
    abstract int deleteSpecialDayById(@Bind("id") Long id);

    public final int deleteSpecialDayById(final Long id, final String umUserHash,
            final String umSessionID, final String umDomain) {

        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        int result = payphoneDAOInterface.deleteSpecialDayById(id);

        return result;
    }

    @SqlUpdate("INSERT into modulations (days ,name,modulation_type_id,end_time,"
            + "profile_id,tariff_version_id)"
            + " VALUES (:day,:name,"
            + ":modulation_type_id,:end_time,:profile_id,:tariff_version_id)")
    @GetGeneratedKeys
    protected abstract int insertIntoModulation(
            @Bind("day") String day,
            @Bind("name") String name,
            @Bind("modulation_type_id") long modulationTypeId,
            @Bind("end_time") int endTime,
            @Bind("profile_id") long profileId,
            @Bind("tariff_version_id") long tariffVersionId
    );

    public final Modulation createModulation(final Modulation modulation)
            throws Exception {
        try {
            String days = modulation.getDays();
            String name = modulation.getName();
            int endtime = modulation.getEndTime();
            long modulationTypeId = modulation.getModulationTypeId();
            long profileId = modulation.getProfileId();
            long tariffVersionId = modulation.getTariffVersionId();
            PayphoneGroupDAO payphoneGroupDAO
                    = dbi.onDemand(PayphoneGroupDAO.class);
            long id = payphoneGroupDAO.insertIntoModulation(days, name,
                    modulationTypeId, endtime, profileId,
                    tariffVersionId);
            if (id != 0) {
                modulation.setId(id);
            }
        } catch (Exception e) {
            throw e;
        }
        return modulation;
    }

    @SqlUpdate("UPDATE modulations SET days = :day , name = :name ,"
            + " end_time = :end_time"
            + " , modulation_type_id = :modulation_type_id , "
            + " profile_id =:profile_id ,tariff_version_id =:tariff_version_id "
            + " WHERE id = :id ")
    abstract int updateModulationById(
            @Bind("id") long id,
            @Bind("day") String day,
            @Bind("name") String name,
            @Bind("end_time") int endTime,
            @Bind("modulation_type_id") long modulationTypeId,
            @Bind("profile_id") long profileId,
            @Bind("tariff_version_id") long tariffVersionId
    );

    public final int updateModulationById(final Long id,
            final String umUserHash,
            final String umSessionID, final String umDomain,
            final Modulation modulation) {
        int response = 0;
        try {
            String day = modulation.getDays();
            int endTime = modulation.getEndTime();
            String name = modulation.getName();
            long modulationTypeId = modulation.getModulationTypeId();
            long profileId = modulation.getProfileId();
            long tariffVersionId = modulation.getTariffVersionId();
            PayphoneGroupDAO payphoneGroupDAO
                    = dbi.onDemand(PayphoneGroupDAO.class);
            response = payphoneGroupDAO.updateModulationById(id, day, name,
                    endTime, modulationTypeId, profileId, tariffVersionId);
        } catch (Exception e) {
            throw e;
        }
        return response;
    }

    @SqlQuery("SELECT id,modulation_type_id,end_time,profile_id, "
            + "tariff_version_id ,days , name "
            + " FROM modulations WHERE id = :id and enum_status_id <> 2")
    @Mapper(ModulationMapper.class)
    abstract Modulation searchModulationById(@Bind("id") long id);

    public final Modulation searchModulationById(final String umUserHash,
            final String umSessionID, final String umDomain, final Long id) {
        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        Modulation modulation = payphoneDAOInterface.searchModulationById(id);
        return modulation;
    }

    @SqlUpdate("UPDATE modulations SET enum_status_id = 2 WHERE id = :id")
    @Mapper(ModulationMapper.class)
    abstract int deleteModulationById(@Bind("id") Long id);

    public final int deleteModulationById(final Long id, final String umUserHash,
            final String umSessionID, final String umDomain) {

        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        int result = payphoneDAOInterface.deleteModulationById(id);

        return result;
    }

    @SqlUpdate("INSERT into tariffs (name ,group_id,modulation_type_id,"
            + "initial_duration,recurrent_duration,tariff_version_id,profile_id,"
            + "status,initial_cost,setup_cost,recurrent_cost)"
            + " VALUES (:name,:group_id,:modulation_type_id,:initial_duration,"
            + ":recurrent_duration,:tariff_version_id,:profile_id,:status,"
            + ":initial_cost,:setup_cost,:recurrent_cost)")
    @GetGeneratedKeys
    protected abstract int insertIntoTariffs(
            @Bind("name") String name,
            @Bind("group_id") long groupid,
            @Bind("modulation_type_id") long modulationTypeId,
            @Bind("initial_duration") long initialDuration,
            @Bind("recurrent_duration") long recurrentDuration,
            @Bind("tariff_version_id") long tariffVersionId,
            @Bind("profile_id") long profileId,
            @Bind("status") boolean status,
            @Bind("initial_cost") double initialCost,
            @Bind("setup_cost") double setupCost,
            @Bind("recurrent_cost") double recurrentCost
    );

    public final Tariff createTariff(Tariff tariff)
            throws Exception {
        try {
            String name = tariff.getName();
            long groupId = tariff.getGroupId();
            long modulationTypeId = tariff.getModulationTypeId();
            long initialDuration = tariff.getInitialDuration();
            long recurrentDuration = tariff.getRecurrentDuration();
            long tariffVersionId = tariff.getTariffVersionId();
            long profileId = tariff.getProfileId();
            boolean status = tariff.getStatus();
            double setupCost = tariff.getSetupCost();
            double initialCost = tariff.getInitialCost();
            double recurrentCost = tariff.getRecurrentCost();
            PayphoneGroupDAO payphoneGroupDAO
                    = dbi.onDemand(PayphoneGroupDAO.class);
            
            long id = payphoneGroupDAO.insertIntoTariffs(name, groupId,
                    modulationTypeId, initialDuration, recurrentDuration,
                    tariffVersionId, profileId, status, initialCost, setupCost,
                    recurrentCost);
            tariff.setId(id);
        } catch (Exception e) {
            throw e;
        }
        return tariff;
    }

    @SqlQuery("SELECT id,name,group_id,modulation_type_id, "
            + "initial_duration ,recurrent_duration,tariff_version_id,"
            + " profile_id,status ,initial_cost ,setup_cost,recurrent_cost "
            + " FROM tariffs WHERE id = :id and enum_status_id <> 2")
    @Mapper(TariffMapper.class)
    abstract Tariff searchTariffById(@Bind("id") long id);

    public final Tariff searchTariffById(final String umUserHash,
            final String umSessionID, final String umDomain, final Long id) {
        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        Tariff tariff = payphoneDAOInterface.searchTariffById(id);
        return tariff;
    }

    @SqlUpdate("UPDATE tariffs SET name = :name , group_id = :group_id"
            + " , modulation_type_id = :modulation_type_id ,"
            + "initial_duration = :initial_duration , "
            + "recurrent_duration = :recurrent_duration ,"
            + " status = :status , profile_id =:profile_id ,"
            + "tariff_version_id =:tariff_version_id , "
            + "initial_cost = :initial_cost , setup_cost = :setup_cost , "
            + "recurrent_cost = :recurrent_cost"
            + " WHERE id = :id ")
    abstract int updateTariffById(
            @Bind("id") long id,
            @Bind("name") String name,
            @Bind("group_id") long groupId,
            @Bind("modulation_type_id") long modulationTypeId,
            @Bind("initial_duration") long initialDuration,
            @Bind("recurrent_duration") long recurrentDuration,
            @Bind("status") boolean status,
            @Bind("profile_id") long profileId,
            @Bind("tariff_version_id") long tariffVersionId,
            @Bind("setup_cost") double setupCost,
            @Bind("recurrent_cost") double recurrentCost,
            @Bind("initial_cost") double initialCost
    );

    public final int updateTariffById(final Long id,
            final String umUserHash,
            final String umSessionID, final String umDomain,
            final Tariff tariff) {
        int response = 0;
        try {
            double initialCost = tariff.getInitialCost();
            long groupId = tariff.getGroupId();
            long initialDuration = tariff.getInitialDuration();
            long modulationType = tariff.getModulationTypeId();
            String name = tariff.getName();
            double recurrentCost = tariff.getRecurrentCost();
            long recurrentDuration = tariff.getRecurrentDuration();
            double setupCost = tariff.getSetupCost();
            boolean status = tariff.getStatus();
            long profileId = tariff.getProfileId();
            long tariffVersionId = tariff.getTariffVersionId();

            PayphoneGroupDAO payphoneGroupDAO
                    = dbi.onDemand(PayphoneGroupDAO.class);
            response = payphoneGroupDAO.updateTariffById(id, name,
                    groupId, modulationType, initialDuration, recurrentDuration,
                    status, profileId, tariffVersionId, setupCost,
                    recurrentCost, initialCost);
        } catch (Exception e) {
            throw e;
        }
        return response;
    }

    @SqlUpdate("UPDATE tariffs SET enum_status_id = 2 WHERE id = :id")
    @Mapper(TariffMapper.class)
    abstract int deleteTariffById(@Bind("id") Long id);

    public final int deleteTariffById(final Long id, final String umUserHash,
            final String umSessionID, final String umDomain) {
        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        int result = payphoneDAOInterface.deleteTariffById(id);
        return result;
    }

    public final JSONObject searchGroups(final String umUserHash,
            final String umSessionID, final String umDomain, final Long offset,
            final Long limit, final String name) throws Exception {
        Handle handle = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE enum_status_id <> 2");
        if (name != null) {
            sb.append(" AND name ilike '%").append(name).append("%'");
        }
        JSONObject o = new JSONObject();
        o.put("limit", limit);
        o.put("offset", offset);
        StringBuilder resultQuery = new StringBuilder(querySelectors());
        resultQuery.append(sb.toString());
        resultQuery.append(" LIMIT ");
        resultQuery.append(limit);
        resultQuery.append(" OFFSET ");
        resultQuery.append(offset);
        StringBuilder countQuery = new StringBuilder();
        countQuery.append("SELECT COUNT(id) AS count FROM GROUPS ");
        // countQuery.append(" AS s ");
        countQuery.append(sb.toString());
        List<Groups> returnPayphonesList = new ArrayList<>();
        try {
            handle = dbi.open();
            handle.attach(PayphoneGroupDAO.class);
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(resultQuery.toString());

            List<Map<String, Object>> list = queryResult.list();
            for (Map<String, Object> map : list) {
                returnPayphonesList.add(getGroupData(map));
            }
            Query<Map<String, Object>> countResult
                    = handle.createQuery(countQuery.toString());
            o.put("total", Integer.parseInt(
                    countResult.list().get(0).get("count").toString()));
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        o.put("data", returnPayphonesList);
        return o;
    }

    private String querySelectors() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, name, tariff_version_id,");
        sb.append(" description");
        sb.append(" FROM ");
        sb.append(" GROUPS ");
        return sb.toString();
    }

    private Groups getGroupData(Map<String, Object> map)
            throws Exception {
        Groups groups = new Groups();
        try {
            groups.setDescription((String) map.get("description"));
            long id = (long) map.get("id");
            groups.setId(id);
            groups.setName((String) map.get("name"));
        } catch (Exception e) {
            throw e;
        }
        return groups;
    }

    public JSONObject searchZones(final String umUserHash,
            final String umSessionID, final String umDomain, final Long offset,
            final Long limit, final String name) throws Exception {
        Handle handle = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE enum_status_id <> 2");
        if (name != null) {
            sb.append(" AND name ilike '%").append(name).append("%'");
        }
        JSONObject o = new JSONObject();
        o.put("limit", limit);
        o.put("offset", offset);
        StringBuilder resultQuery = new StringBuilder(querySelectorsZones());
        resultQuery.append(sb.toString());
        resultQuery.append(" LIMIT ");
        resultQuery.append(limit);
        resultQuery.append(" OFFSET ");
        resultQuery.append(offset);
        StringBuilder countQuery = new StringBuilder();
        countQuery.append("SELECT COUNT(id) AS count FROM ZONES ");
        countQuery.append(sb.toString());

        List<Zones> returnZonesList = new ArrayList<>();
        try {
            handle = dbi.open();
            handle.attach(PayphoneGroupDAO.class);
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(resultQuery.toString());

            List<Map<String, Object>> list = queryResult.list();
            for (Map<String, Object> map : list) {
                returnZonesList.add(getZoneData(map));
            }
            Query<Map<String, Object>> countResult
                    = handle.createQuery(countQuery.toString());
            o.put("total", Integer.parseInt(
                    countResult.list().get(0).get("count").toString()));
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        o.put("data", returnZonesList);
        return o;
    }

    private Zones getZoneData(Map<String, Object> map)
            throws Exception {
        Zones zones = new Zones();
        try {
            long id = (long) map.get("id");
            zones.setId(id);
            long groupId = (long) map.get("group_id");
            zones.setGroupId(groupId);
            zones.setName((String) map.get("name"));
            zones.setDescription((String) map.get("description"));
        } catch (Exception e) {
            throw e;
        }
        return zones;
    }

    private String querySelectorsZones() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, name,group_id ,tariff_version_id,");
        sb.append(" description");
        sb.append(" FROM ");
        sb.append(" ZONES ");
        return sb.toString();
    }

    public JSONObject searchPrefix(String umUserHash, String umSessionID,
            String umDomain, Long offset, Long limit, String name)
            throws Exception {
        Handle handle = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE enum_status_id <> 2");
      
        JSONObject o = new JSONObject();
        o.put("limit", limit);
        o.put("offset", offset);
        StringBuilder resultQuery = new StringBuilder(querySelectorsPrefix());
        resultQuery.append(sb.toString());
        resultQuery.append(" LIMIT ");
        resultQuery.append(limit);
        resultQuery.append(" OFFSET ");
        resultQuery.append(offset);
        StringBuilder countQuery = new StringBuilder();
        countQuery.append("SELECT COUNT(id) AS count FROM PREFIXES ");
        countQuery.append(sb.toString());

        List<Prefix> returnPrefixList = new ArrayList<>();
        try {
            handle = dbi.open();
            handle.attach(PayphoneGroupDAO.class);
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(resultQuery.toString());
            List<Map<String, Object>> list = queryResult.list();
            for (Map<String, Object> map : list) {
                returnPrefixList.add(getPrefixData(map));
            }
            Query<Map<String, Object>> countResult
                    = handle.createQuery(countQuery.toString());
            o.put("total", Integer.parseInt(
                    countResult.list().get(0).get("count").toString()));
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        o.put("data", returnPrefixList);
        return o;
    }

    private String querySelectorsPrefix() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, value ,zone_id ,country ,tariff_version_id,");
        sb.append(" description");
        sb.append(" FROM ");
        sb.append(" PREFIXES ");
        return sb.toString();
    }

    private Prefix getPrefixData(Map<String, Object> map)
            throws Exception {
        Prefix prefix = new Prefix();
        try {
            long id = (long) map.get("id");
            prefix.setId(id);
            prefix.setCountry((String) map.get("country"));
            long value = (long) map.get("value");
            prefix.setValue(value);
            prefix.setDescription((String) map.get("description"));
        } catch (Exception e) {
            throw e;
        }
        return prefix;
    }

    public JSONObject searchTariffVersions(final String umUserHash,
            final String umSessionID,
            final String umDomain,
            final Long offset, final Long limit, String name) throws Exception {
        Handle handle = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE enum_status_id <> 2");
       
        JSONObject o = new JSONObject();
        o.put("limit", limit);
        o.put("offset", offset);
        StringBuilder resultQuery = new StringBuilder(querySelectorsTariffVersions());
        resultQuery.append(sb.toString());
        resultQuery.append(" LIMIT ");
        resultQuery.append(limit);
        resultQuery.append(" OFFSET ");
        resultQuery.append(offset);
        StringBuilder countQuery = new StringBuilder();
        countQuery.append("SELECT COUNT(id) AS count FROM TARIFF_VERSIONS ");
        countQuery.append(sb.toString());

        List<TariffVersions> returnTariffVersionsList = new ArrayList<>();
        try {
            handle = dbi.open();
            handle.attach(PayphoneGroupDAO.class);
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(resultQuery.toString());
            List<Map<String, Object>> list = queryResult.list();
            for (Map<String, Object> map : list) {
                returnTariffVersionsList.add(getTariffVersionsData(map));
            }
            Query<Map<String, Object>> countResult
                    = handle.createQuery(countQuery.toString());
            o.put("total", Integer.parseInt(
                    countResult.list().get(0).get("count").toString()));
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        o.put("data", returnTariffVersionsList);
        return o;
    }

    private String querySelectorsTariffVersions() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, description ,status , activation_date ");
        sb.append(" FROM ");
        sb.append(" TARIFF_VERSIONS ");

        return sb.toString();
    }

    private TariffVersions getTariffVersionsData(Map<String, Object> map)
            throws Exception {
        TariffVersions tariffVersions = new TariffVersions();
        tariffVersions.setActivationDate((Date) map.get("activation_date"));
        tariffVersions.setDescription((String) map.get("description"));
        long id = (long) map.get("id");
        tariffVersions.setId(id);
        tariffVersions.setStatus((String) map.get("status"));
        return tariffVersions;
    }

    public JSONObject searchTariffs(final String umUserHash,
            final String umSessionID,
            final String umDomain, final Long offset, final Long limit,
            final String name) throws Exception {
        Handle handle = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE enum_status_id <> 2");
        if (name != null) {
            sb.append(" AND name ilike '%").append(name).append("%'");
        }
        JSONObject o = new JSONObject();
        o.put("limit", limit);
        o.put("offset", offset);
        StringBuilder resultQuery = new StringBuilder(querySelectorsTariffs());
        resultQuery.append(sb.toString());
        resultQuery.append(" LIMIT ");
        resultQuery.append(limit);
        resultQuery.append(" OFFSET ");
        resultQuery.append(offset);
        StringBuilder countQuery = new StringBuilder();
        countQuery.append("SELECT COUNT(id) AS count FROM TARIFFS ");
        countQuery.append(sb.toString());
        List<Tariff> returnTariffList = new ArrayList<>();
        try {
            handle = dbi.open();
            handle.attach(PayphoneGroupDAO.class);
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(resultQuery.toString());
            List<Map<String, Object>> list = queryResult.list();
            for (Map<String, Object> map : list) {
                returnTariffList.add(getTariffData(map));
            }
            Query<Map<String, Object>> countResult
                    = handle.createQuery(countQuery.toString());

            o.put("total", Integer.parseInt(
                    countResult.list().get(0).get("count").toString()));
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        o.put("data", returnTariffList);
        return o;
    }

    private String querySelectorsTariffs() {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT id,name,group_id,modulation_type_id,initial_duration,"
                + "recurrent_duration , "
                + " tariff_version_id , profile_id , status ,initial_cost ,"
                + " setup_cost,recurrent_cost");
        sb.append(" FROM ");
        sb.append(" TARIFFS ");
        return sb.toString();
    }

    private Tariff getTariffData(Map<String, Object> map)
            throws Exception {
        Tariff tariff = new Tariff();
        double initialCost = (double) map.get("initial_cost");
        tariff.setInitialCost(initialCost);
        long groupId = (long) map.get("group_id");
        tariff.setGroupId(groupId);
        long id = (long) map.get("id");
        tariff.setId(id);
        long initialDuration = (long) map.get("initial_duration");
        tariff.setInitialDuration(initialDuration);
        long modulationTypeId = (long) map.get("modulation_type_id");
        tariff.setModulationTypeId(modulationTypeId);
        tariff.setName((String) map.get("name"));
        long profileId = (long) map.get("profile_id");
        tariff.setProfileId(profileId);
        double recurrentCost = (double) map.get("recurrent_cost");
        tariff.setRecurrentCost(recurrentCost);
        long recurrentDuration = (long) map.get("recurrent_duration");
        tariff.setRecurrentDuration(recurrentDuration);
        double setupCost = (double) map.get("setup_cost");
        tariff.setSetupCost(setupCost);
        boolean status = (boolean) map.get("status");
        tariff.setStatus(status);
        long tariffVersionId = (long) map.get("tariff_version_id");
        tariff.setTariffVersionId(tariffVersionId);
        return tariff;
    }

    public JSONObject searchModulations(String umUserHash, String umSessionID,
            String umDomain, Long offset, Long limit) throws Exception {
        Handle handle = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE enum_status_id <> 2");
        JSONObject o = new JSONObject();
        o.put("limit", limit);
        o.put("offset", offset);
        StringBuilder resultQuery = new StringBuilder(
                querySelectorsModulations());
        resultQuery.append(sb.toString());
        resultQuery.append(" LIMIT ");
        resultQuery.append(limit);
        resultQuery.append(" OFFSET ");
        resultQuery.append(offset);
        StringBuilder countQuery = new StringBuilder();
        countQuery.append("SELECT COUNT(id) AS count FROM MODULATIONS ");
        countQuery.append(sb.toString());
        List<Modulation> returnModulationList = new ArrayList<>();
        try {
            handle = dbi.open();
            handle.attach(PayphoneGroupDAO.class);
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(resultQuery.toString());
            List<Map<String, Object>> list = queryResult.list();
            for (Map<String, Object> map : list) {
                returnModulationList.add(getModulationData(map));
            }
            Query<Map<String, Object>> countResult
                    = handle.createQuery(countQuery.toString());
            o.put("total", Integer.parseInt(
                    countResult.list().get(0).get("count").toString()));
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        o.put("data", returnModulationList);
        return o;
    }

    private String querySelectorsModulations() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, modulation_type_id ,end_time, profile_id ,"
                + " tariff_version_id ,days ,name");
        sb.append(" FROM ");
        sb.append(" MODULATIONS ");
        return sb.toString();
    }

    private Modulation getModulationData(Map<String, Object> map)
            throws Exception {
        Modulation modulation = new Modulation();
        try {
            String days = (String) map.get("days");
            modulation.setDays(days);
            modulation.setName((String) map.get("name"));
            modulation.setDescription((String) map.get("description"));
            int endTime = (int) map.get("end_time");
            modulation.setEndTime(endTime);
            long id = (long) map.get("id");
            modulation.setId(id);
            long mdulationTypeId = (long) map.get("modulation_type_id");
            modulation.setModulationTypeId(mdulationTypeId);
            long profileId = (long) map.get("profile_id");
            modulation.setProfileId(profileId);
            long tariffVersionId = (long) map.get("tariff_version_id");
            modulation.setTariffVersionId(tariffVersionId);
        } catch (Exception e) {
            throw e;
        }
        return modulation;
    }

    private String querySelectorsSpecialDay() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id, day, month ,year,description");
        sb.append(" FROM ");
        sb.append(" SPECIAL_DAYS ");
        return sb.toString();
    }

    private SpecialDay getSpecialDayData(Map<String, Object> map)
            throws Exception {
        SpecialDay specialDay = new SpecialDay();
        try {
            int day = (int) map.get("day");
            specialDay.setDay(day);
            specialDay.setDescription((String) map.get("description"));
            long id = (long) map.get("id");
            specialDay.setId(id);
            int month = (int) map.get("month");
            specialDay.setMonth(month);
            int year = (int) map.get("year");
            specialDay.setYear(year);
        } catch (Exception e) {
            throw e;
        }
        return specialDay;
    }

    public final JSONObject searchSpecialDays(String umUserHash,
            String umSessionID,
            String umDomain, Long offset, Long limit) throws Exception {
        StringBuilder sb = new StringBuilder();
        Handle handle = null;
        sb.append(" WHERE enum_status_id <> 2");
        JSONObject o = new JSONObject();
        o.put("limit", limit);
        o.put("offset", offset);
        StringBuilder resultQuery = new StringBuilder(
                querySelectorsSpecialDay());
        resultQuery.append(sb.toString());
        resultQuery.append(" LIMIT ");
        resultQuery.append(limit);
        resultQuery.append(" OFFSET ");
        resultQuery.append(offset);
        StringBuilder countQuery = new StringBuilder();
        countQuery.append("SELECT COUNT(id) AS count FROM SPECIAL_DAYS ");
        countQuery.append(sb.toString());
        List<SpecialDay> returnPayphonesList = new ArrayList<>();
        try {
            handle = dbi.open();
            handle.attach(PayphoneGroupDAO.class);
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(resultQuery.toString());
            List<Map<String, Object>> list = queryResult.list();
            for (Map<String, Object> map : list) {
                returnPayphonesList.add(getSpecialDayData(map));
            }
            Query<Map<String, Object>> countResult
                    = handle.createQuery(countQuery.toString());
            o.put("total", Integer.parseInt(
                    countResult.list().get(0).get("count").toString()));
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        o.put("data", returnPayphonesList);
        return o;
    }

    public TariffVersions cloneTariffVersion(TariffVersions 
            cloneTariffVersionService)
            throws Exception {
        try {
            String description = cloneTariffVersionService.getDescription();
            long tariffVersionId = cloneTariffVersionService.getId();
            PayphoneGroupDAO payphoneGroupDAO
                    = dbi.onDemand(PayphoneGroupDAO.class);
            long id = payphoneGroupDAO.insertCLoneTransaction(description,
                    tariffVersionId);
            if(id !=0){
                cloneTariffVersionService.setId(id);
            }
        } catch (Exception e) {
            throw e;
        }
        return cloneTariffVersionService;
    }

    @Transaction
    public long insertCLoneTransaction(String description, long tariffVersionId)
            throws Exception {
        Date activationDate = getTodaysdate();
        String status = "NEW";
        long newCloneTariffId = insertIntoTariffVersionsClone(description,
                activationDate, status);
        insertIntoTariffCloneNew(newCloneTariffId, tariffVersionId);
        insertIntoModulationsCloneNew(newCloneTariffId, tariffVersionId);
        insertIntoGroupsCloneNew(newCloneTariffId, tariffVersionId);
        insertIntoZonesCloneNew(newCloneTariffId, tariffVersionId);
        insertIntoPrefixesCloneNew(newCloneTariffId, tariffVersionId);
        return newCloneTariffId;
    }

    @SqlUpdate("INSERT INTO tariff_versions (description,activation_date,status)"
            + "VALUES (:description,:activation_date,:status)")
    @GetGeneratedKeys
    protected abstract long insertIntoTariffVersionsClone(
            @Bind("description") String description,
            @Bind("activation_date") Date activationDate,
            @Bind("status") String status
    );

    public List<Tariff> searchTariffsClone(long tariffVersionId) throws
            Exception {
        Handle handle = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE enum_status_id <> 2");
        sb.append(" AND tariff_version_id = ").
                append(tariffVersionId).append("");
        StringBuilder resultQuery = new StringBuilder(querySelectorsTariffs());
        resultQuery.append(sb.toString());
        List<Tariff> returnTariffList = new ArrayList<>();
        try {
            handle = dbi.open();
            handle.attach(PayphoneGroupDAO.class);
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(resultQuery.toString());

            List<Map<String, Object>> list = queryResult.list();
            for (Map<String, Object> map : list) {
                returnTariffList.add(getTariffData(map));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        return returnTariffList;
    }

    @SqlUpdate("INSERT into prefixes(value ,country ,description,"
            + "tariff_version_id, zone_id)"
            + " SELECT value,country,description,:tariff_version_id, zone_id "
            + " FROM prefixes "
            + " WHERE tariff_version_id = :tariff_id ")
    @GetGeneratedKeys
    protected abstract int insertIntoPrefixesCloneNew(
            @Bind("tariff_version_id") long tariffVersionId,
            @Bind("tariff_id") long oldtariffVersionId
    );

    
    @SqlUpdate("INSERT into modulations(name ,modulation_type_id ,end_time,"
            + "profile_id,tariff_version_id,"
            + " days)"
            + " SELECT name ,modulation_type_id ,end_time,profile_id,"
            + ":tariff_version_id,days "
            + " FROM modulations "
            + " WHERE tariff_version_id = :tariff_id ")
    @GetGeneratedKeys
    protected abstract int insertIntoModulationsCloneNew(
            @Bind("tariff_version_id") long tariffVersionId,
            @Bind("tariff_id") long oldtariffVersionId
    );

    @SqlUpdate("INSERT into groups(name ,tariff_version_id,description )"
            + " SELECT name ,:tariff_version_id,description "
            + " FROM groups "
            + " WHERE tariff_version_id = :tariff_id ")
    @GetGeneratedKeys
    protected abstract int insertIntoGroupsCloneNew(
            @Bind("tariff_version_id") long tariffVersionId,
            @Bind("tariff_id") long oldtariffVersionId
    );

    @SqlUpdate("INSERT into zones(name ,group_id,tariff_version_id,description)"
            + " SELECT name ,group_id,:tariff_version_id,description "
            + " FROM zones "
            + " WHERE tariff_version_id = :tariff_id ")
    @GetGeneratedKeys
    protected abstract int insertIntoZonesCloneNew(
            @Bind("tariff_version_id") long tariffVersionId,
            @Bind("tariff_id") long oldtariffVersionId
    );
    
    @SqlUpdate("INSERT into tariffs(name ,group_id,modulation_type_id,"
            + " initial_duration,recurrent_duration,tariff_version_id,profile_id ,"
            + " status,initial_cost,setup_cost,recurrent_cost )"
            + " SELECT name ,group_id,modulation_type_id,initial_duration,"
            + " recurrent_duration, :tariff_version_id, profile_id,status,"
            + " initial_cost,setup_cost,recurrent_cost "
            + " FROM tariffs "
            + " WHERE tariff_version_id = :tariff_id ")
    @GetGeneratedKeys
    protected abstract int insertIntoTariffCloneNew(
            @Bind("tariff_version_id") long tariffVersionId,
            @Bind("tariff_id") long oldtariffVersionId
    );

    public final Date getTodaysdate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        return date;
    }

     @SqlQuery("SELECT id,description , status , activation_date "
            + "FROM tariff_versions WHERE id = :id AND enum_status_id <> 2")
    @Mapper(TariffVersionsMapper.class)
    abstract TariffVersions searchTariffVersionsById(@Bind("id") long id);

    public final TariffVersions searchTariffVersionsById(final String umUserHash,
            final String umSessionID, final String umDomain, final long id) {

        PayphoneGroupDAO payphoneDAOInterface
                = dbi.onDemand(PayphoneGroupDAO.class);
        TariffVersions tariffVersions = payphoneDAOInterface.searchTariffVersionsById(id);

        return tariffVersions;

    }
}
