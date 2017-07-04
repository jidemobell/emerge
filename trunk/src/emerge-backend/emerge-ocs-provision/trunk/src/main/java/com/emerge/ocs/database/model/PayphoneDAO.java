/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.database.PasswordAuthentication;
import com.emerge.ocs.rest.model.Application;
import com.emerge.ocs.rest.model.ConfigData;
import com.emerge.ocs.rest.model.Equipment;
import com.emerge.ocs.rest.model.PayphoneCredentials;
import com.emerge.ocs.rest.model.PayphoneDevice;
import com.emerge.ocs.rest.model.PayphoneService;
import com.emerge.ocs.rest.model.SIM;
import com.emerge.ocs.rest.model.Status;
import com.emerge.ocs.rest.model.Status.StatusEnum;
import com.emerge.ocs.rest.model.TariffVersions;
import com.emerge.ocs.rest.model.TopupRsp;
import com.emerge.ocs.rest.model.Version;
import com.emerge.ocs.rest.util.JdbiHelper;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;

/**
 *
 * @author goodson
 */
public class PayphoneDAO {

    DBI dbi;

    /**
     *
     */
    public PayphoneDAO() {
        dbi = JdbiHelper.getDBI();
    }

    public final PayphoneService createServices(PayphoneService payphoneService)
            throws Exception {

        PasswordAuthentication passwordAuthentication
                = new PasswordAuthentication();

        long contractId = payphoneService.getContractId();
        String sim1MSISDN = payphoneService.getSim1().getMSISDN();
        String sim1IMSI = payphoneService.getSim1().getIMSI();
        String sim1ICCID = payphoneService.getSim1().getICCID();
        String sim2MSISDN = payphoneService.getSim2().getMSISDN();
        String sim2IMSI = payphoneService.getSim2().getIMSI();
        String sim2ICCID = payphoneService.getSim2().getICCID();
        double balance = payphoneService.getBalance();
        String username = payphoneService.getCredentials().getUsername();
        String password = passwordAuthentication.hash(payphoneService
                .getCredentials().getPassword().toCharArray());

        long profileId = payphoneService.getProfileId();
        String status = payphoneService.getStatus().getStatus().toString();

        PayphoneDAOInterface payphoneDAOInterface
                = dbi.onDemand(PayphoneDAOInterface.class);
        
        long generatedId = payphoneDAOInterface.insertIntoServices(contractId,
                sim1MSISDN, sim1IMSI, sim1ICCID, sim2MSISDN, sim2IMSI,
                sim2ICCID, balance, username, password, status, profileId,
                payphoneService.getConfigData().getPreferredMSISDN(),
                payphoneService.getConfigData().getKeepAliveInterval()
        );
        if (generatedId != 0) {
            payphoneService.setId(generatedId);
            payphoneService.setPayphoneDeviceId(generatedId);
        }

        return payphoneService;
    }

    public final int deletePayphoneById(String access, Long payphoneId,
            String umUserHash, String umSessionID, String umDomain) {

        int result = 0;
        Handle handle = null;
        try {
            handle = dbi.open();
            PayphoneDAOInterface ocsInterface
                    = handle.attach(PayphoneDAOInterface.class);
            result = ocsInterface.deletePayphoneById(payphoneId);
        } catch (Exception ex) {
            return 0;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        return result;
    }

    public final int updatePayphoneById(String access, Long id,
            String umUserHash, String umSessionID, String umDomain,
            PayphoneService payphone) throws Exception {
        int result = 0;
        Handle handle = null;
        try {
            String status = payphone.getStatus().getStatus().toString();
            Date statusDate = payphone.getStatus().getStatusDate();
            double balance = payphone.getBalance();
            String username = payphone.getCredentials().getUsername();
            String password = null;
            handle = dbi.open();
            PayphoneDAOInterface ocsInterface
                    = handle.attach(PayphoneDAOInterface.class);
            try {
                password = payphone.getCredentials().getPassword();
                if (password == null) {
                    Query<Map<String, Object>> queryResult = handle
                            .createQuery("SELECT password "
                                    + " FROM payphone_services WHERE id = "
                                    + id);
                    List<Map<String, Object>> listRecord = queryResult.list();
                    for (Map<String, Object> map : listRecord) {
                        password = (String) map.get("password");
                    }
                } else {
                    PasswordAuthentication passwordAuth
                            = new PasswordAuthentication();
                    password = passwordAuth.hash(password.toCharArray());
                }
            } catch (NullPointerException ex) {
            }
            long contractId = payphone.getContractId();
            String sim1ICCID = payphone.getSim1().getICCID();
            String sim1IMSI = payphone.getSim1().getIMSI();
            String sim1MSISDN = payphone.getSim1().getMSISDN();
            String sim2ICCID = payphone.getSim2().getICCID();
            String sim2IMSI = payphone.getSim2().getIMSI();
            String sim2MSISDN = payphone.getSim2().getMSISDN();
            long keepAliveInterval = payphone.getConfigData()
                    .getKeepAliveInterval();
            result = ocsInterface.updatePayphoneById(id, username,
                    password, sim1MSISDN, sim1IMSI, sim2MSISDN, sim2IMSI,
                    balance, sim1ICCID, contractId, status, statusDate,
                    sim2ICCID, payphone.getConfigData().getPreferredMSISDN(),
                    keepAliveInterval);
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }

        return result;
    }

    /**
     *
     * @param umUserHash umUserHash
     * @param umSessionID umSessionID
     * @param umDomain umDomain
     * @param access access
     * @param id id
     * @return Payphone Service
     * @throws Exception
     */
    public final PayphoneService searchPayphoneById(final String umUserHash,
            final String umSessionID, final String umDomain,
            final String access, final Long id) throws Exception {
        PayphoneService payphoneService = null;
        StringBuilder searchByIdQuery = new StringBuilder();
        searchByIdQuery.append(querySelectors());
        searchByIdQuery.append(" WHERE s.id = ").append(id);
        searchByIdQuery.append(" AND s.enum_status_id <> 2 ;");
        Handle handle = null;
        try {
            payphoneService = new PayphoneService();
            handle = dbi.open();
            handle.attach(PayphoneDAOInterface.class);
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(searchByIdQuery.toString());
            if (queryResult.list().size() == 1) {
                payphoneService = getPayphoneData(queryResult.list().get(0));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        return payphoneService;
    }

    /**
     * @return String of Payphone SQL select query
     */
    private String querySelectors() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT s.id, s.contract_id, s.sim1_msisdn,");
        sb.append(" s.sim1_imsi, s.sim1_iccid, s.sim2_msisdn,");
        sb.append(" s.sim2_imsi, s.sim2_iccid, s.username,");
        sb.append(" s.balance, s.status, s.keep_alive_interval,");
        sb.append(" s.profile_id, s.status_date,");
        sb.append(" s.app_cdate, s.app_mdate,");
        sb.append(" p.imei1, p.imei2, p.serial_no, p.mac,");
        sb.append(" p.payphone_version_id,");
        sb.append(" s.preferred_msisdn, p.silence_mode,");
        sb.append(" p.send_errors_to_ocs, p.default_language ,");
        sb.append(" v.major , v.minor , v.patch  , ");
        sb.append(" v.expiry ");
        sb.append(" FROM");
        sb.append(" PAYPHONE_SERVICES s");
        sb.append(" LEFT JOIN ");
        sb.append(" PAYPHONE_DEVICES p ON s.id = p.id");
        sb.append(" LEFT JOIN ");
        sb.append(" PAYPHONE_VERSIONS v ON v.id = p.id");
        return sb.toString();
    }

    /**
     *
     * @param umUserHash
     * @param umSessionID
     * @param umDomain
     * @param offset
     * @param limit
     * @param id
     * @param customerId
     * @param username
     * @param serialNo
     * @param mac
     * @param imei
     * @param msisdn
     * @param iccid
     * @param imsi
     * @param status
     * @return
     * @throws Exception
     */
    public final JSONObject searchPayphoneService(final String umUserHash,
            final String umSessionID, final String umDomain,
            final long offset, final long limit,
            final long id, final long customerId,
            final String username, final String serialNo,
            final String mac, final String imei, final String msisdn,
            final String iccid, final String imsi,
            final String status) throws Exception {
        Handle handle = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" WHERE s.enum_status_id <> 2");
        if (username != null && !username.isEmpty()) {
            sb.append(" AND s.username ilike '%").append(username).append("%'");
        }
        if (serialNo != null && !serialNo.isEmpty()) {
            sb.append(" AND p.serial_no='").append(serialNo).append("'");
        }
        if (mac != null && !mac.isEmpty()) {
            sb.append(" AND p.mac='").append(mac).append("'");
        }
        if (imsi != null && !imsi.isEmpty()) {
            sb.append(" AND (s.sim1_imsi='").append(imsi).append("' ");
            sb.append(" OR s.sim2_imsi='").append(imsi).append("')");
        }
        if (imei != null && !imei.isEmpty()) {
            sb.append(" AND (p.imei2='").append(imei).append("' ");
            sb.append(" OR p.imei1='").append(imei).append("')");
        }
        if (msisdn != null && !msisdn.isEmpty()) {
            sb.append(" AND (s.sim1_msisdn='").append(msisdn).append("' ");
            sb.append(" OR s.sim2_msisdn='").append(msisdn).append("')");
        }
        if (iccid != null && !iccid.isEmpty()) {
            sb.append(" AND (s.sim1_iccid='").append(iccid).append("' ");
            sb.append(" OR s.sim2_iccid='").append(iccid).append("')");
        }
        if (status != null && !status.isEmpty()) {
            sb.append(" AND s.status='").append(status).append("'");
        }
        if (id != 0) {
            sb.append(" AND p.id='").append(id).append("'");
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
        countQuery.append("SELECT COUNT(s.id) AS count FROM payphone_services");
        countQuery.append(" AS s ");
        countQuery.append("left join payphone_devices p on s.id = p.id ");
        countQuery.append("left join payphone_versions v on v.id = p.id ");
        countQuery.append(sb.toString());
        List<PayphoneService> returnPayphonesList = new ArrayList<>();
        try {
            handle = dbi.open();
            handle.attach(PayphoneDAOInterface.class);
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(resultQuery.toString());
            List<Map<String, Object>> list = queryResult.list();
            for (Map<String, Object> map : list) {
                returnPayphonesList.add(getPayphoneData(map));
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

    // How do we determine which sim balance to top up?
    public final TopupRsp topUpPayPhonebyId(String access, long payphoneId,
            final String umUserHash, final String umSessionID,
            final String umDomain,
            final float amountToCredit) throws Exception {

        DecimalFormat decimalFormat = new DecimalFormat(".###");
        TopupRsp topupResponse = new TopupRsp();
        Handle handle = null;
        try {
            handle = dbi.open();
            PayphoneDAOInterface payphoneInterface
                    = handle.attach(PayphoneDAOInterface.class);
            String beforeQuery = "SELECT id, balance FROM  "
                    + "payphone_services WHERE  id  = " + payphoneId;
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(beforeQuery);
            Map<String, Object> record = queryResult.list().get(0);

            double initialBalanceBefore = (double) record.get("balance");
            String initialBalance = decimalFormat.
                    format(initialBalanceBefore);
            double balanceBefore = Double.parseDouble(initialBalance);

            String initailAmountToCredit = decimalFormat.format(amountToCredit);

            float finalAmountToCredit = Float.parseFloat(initailAmountToCredit);

            int response = payphoneInterface.topUpPayphoneById(payphoneId,
                    finalAmountToCredit);
            if (response == 1) {
                String afterQuery = "SELECT id , balance FROM"
                        + "  payphone_services WHERE  id  = " + payphoneId;

                Query<Map<String, Object>> queryResult2
                        = handle.createQuery(afterQuery);
                Map<String, Object> record2 = queryResult2.list().get(0);
                payphoneId = (long) record2.get("id");
                double balanceAfter = (double) record2.get("balance");
                balanceAfter = Double.parseDouble(
                        decimalFormat.format(balanceAfter));

                topupResponse.setId(payphoneId);
                topupResponse.setCreditAfterTopup(balanceAfter);
                topupResponse.setCreditBeforeTopup(balanceBefore);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }
        return topupResponse;
    }

    public final Date getTodaysdate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        return date;
    }

    private PayphoneService getPayphoneData(Map<String, Object> map)
            throws Exception {
        PayphoneService payphoneService = new PayphoneService();
        PayphoneDevice payphoneDevice = new PayphoneDevice();
        long id = 0L;
        SIM sim1 = new SIM();
        SIM sim2 = new SIM();
        ConfigData configData = new ConfigData();
        PayphoneCredentials payphoneCredentials = new PayphoneCredentials();
        try {
            configData.setPreferredMSISDN(
                    map.get("preferred_msisdn").toString());
            configData.setKeepAliveInterval(Long.parseLong(
                    map.get("keep_alive_interval").toString()));
            try {
                configData.setSendErrorsToOCS(Long.parseLong(
                        map.get("send_errors_to_ocs").toString()));
            } catch (NullPointerException ex) {
                configData.setSendErrorsToOCS(0L);
            }
            try {
                configData.setSilenceMode(Boolean.valueOf(
                        map.get("silence_mode").toString()));
            } catch (NullPointerException ex) {
                configData.setSilenceMode(false);
            }
            payphoneCredentials.setUsername(map.get("username").toString());
            Status status = new Status();
            status.setStatus(Status.StatusEnum.valueOf(map.get("status")
                    .toString().toUpperCase()));
            try {
                status.setStatusDate((Date) map.get("status_date"));
            } catch (NullPointerException ex) {

            }
            long profileID = (long) map.get("profile_id");
            long contractID = (long) map.get("contract_id");
            Application application = new Application();
            Version version = new Version();
            Equipment equipment = new Equipment();
            if (map.get("major") != null) {
                long major = (long) map.get("major");
                long minor = (long) map.get("minor");
                long patch = (long) map.get("patch");
                version.setMajor(major);
                version.setMinor(minor);
                version.setPatch(patch);
                application.setVersion(version);
            }

            application.setName("Payphone");
            application.setVersion(version);
            payphoneDevice.setApplication(application);
            payphoneDevice.setEquipment(equipment);
            payphoneDevice.setStatus(status);
            payphoneDevice.setCreationDate((Date) map.get("app_cdate"));
            payphoneDevice.setModificationDate((Date) map.get("app_mdate"));
            payphoneService.setProfileId(profileID);
            payphoneService.setContractId(contractID);
            sim1.setMSISDN(map.get("sim1_msisdn").toString());
            sim1.setIMSI(map.get("sim1_imsi").toString());
            sim1.setICCID(map.get("sim1_iccid").toString());
            if (map.get("sim2_msisdn") != null
                    && map.get("sim2_imsi") != null
                    && map.get("sim2_iccid") != null) {
                sim2.setMSISDN(map.get("sim2_msisdn").toString());
                sim2.setIMSI(map.get("sim2_imsi").toString());
                sim2.setICCID(map.get("sim2_iccid").toString());
            }
            payphoneService.setId(id);
            payphoneService.setPayphoneDeviceId(id);

            if (map.get("id") != null) {
                payphoneDevice.setId(Long.parseLong(map.get("id").toString()));
                payphoneService.setPayphoneDeviceId(
                        Long.parseLong(map.get("id").toString()));
                payphoneService.setId(Long.parseLong(map.get("id").toString()));
                payphoneService.setCreationDate((Date) map.get("app_cdate"));
                payphoneService.setModificationDate(
                        (Date) map.get("app_mdate"));

                payphoneService.setCredentials(payphoneCredentials);
                payphoneService.setBalance(Double.parseDouble(
                        (map.get("balance").toString())));
                payphoneService.setConfigData(configData);
                payphoneService.setSim1(sim1);
                payphoneService.setSim2(sim2);
                payphoneService.setStatus(status);
            }
            payphoneService.setCredentials(payphoneCredentials);
            payphoneService.setBalance(Double.parseDouble((map.get("balance")
                    .toString())));

            payphoneService.setConfigData(configData);
            payphoneService.setSim1(sim1);
            payphoneService.setSim2(sim2);
            payphoneService.setStatus(status);
            payphoneDevice.setSim1(sim1);
            payphoneDevice.setSim2(sim2);
            payphoneService.setPayphoneDevice(payphoneDevice);
            // TODO Cast long and double objects
            if (map.get("mac") != null) {
                equipment.setIMEI1(map.get("imei1").toString());
                equipment.setIMEI2(map.get("imei2").toString());
                equipment.setMAC(map.get("mac").toString());
                equipment.setSerialNr(map.get("serial_no").toString());
                payphoneDevice.setCreationDate((Date) map.get("app_cdate"));
                payphoneDevice.setModificationDate((Date) map.get("app_mdate"));
                payphoneDevice.setApplication(application);
                payphoneDevice.setEquipment(equipment);
                payphoneDevice.setStatus(status);
                payphoneDevice.setSim1(sim1);
                payphoneDevice.setSim2(sim2);
                payphoneService.setPayphoneDevice(payphoneDevice);
            }

        } catch (Exception e) {
            throw e;
        }

        return payphoneService;
    }


    /**
     *
     * @param tariffVersions Original Tariff Version
     * @return Tariff Version
     * @throws Exception DB exception
     */
    public final TariffVersions createTariffVersions(
            final TariffVersions tariffVersions) throws Exception {
        String description = tariffVersions.getDescription();
        Date activationDate = tariffVersions.getActivationDate();
        try {
            PayphoneDAOInterface ocsInterface
                    = dbi.onDemand(PayphoneDAOInterface.class);
            long generatedId = ocsInterface.insertIntoTariffVersions(
                    description, activationDate);
            if (generatedId != 0) {
                tariffVersions.setId(generatedId);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return tariffVersions;
    }

    /**
     *
     * @param access access
     * @param payphoneId payphoneId
     * @param umUserHash umUserHash
     * @param umSessionID umSessionID
     * @param umDomain umDomain
     * @param amountToCredit amountToCredit
     * @return Top up response
     * @throws Exception DB Exception
     */
    public final TopupRsp setBalancePayPhonebyId(final String access,
            final long payphoneId, final String umUserHash,
            final String umSessionID, final String umDomain,
            final float amountToCredit) throws Exception {

        DecimalFormat decimalFormat = new DecimalFormat(".###");
        TopupRsp topupResponse = new TopupRsp();
        Handle handle = null;
        try {
            handle = dbi.open();
            PayphoneDAOInterface payphoneInterface
                    = handle.attach(PayphoneDAOInterface.class);
            String beforeQuery = "SELECT balance FROM  "
                    + "payphone_services WHERE id  = " + payphoneId;
            Query<Map<String, Object>> queryResult
                    = handle.createQuery(beforeQuery);
            Map<String, Object> record = queryResult.list().get(0);
            double initialBalanceBefore = (double) record.get("balance");
            String initialBalance = decimalFormat
                    .format(initialBalanceBefore);
            double balanceBefore = Double.parseDouble(initialBalance);
            String initailAmountToCredit = decimalFormat.format(amountToCredit);

            float finalAmountToCredit = Float.parseFloat(initailAmountToCredit);

            int response = payphoneInterface.setBalancePayphoneById(payphoneId,
                    finalAmountToCredit);
            if (response == 1) {
                String afterQuery = " SELECT balance FROM "
                        + "  payphone_services WHERE  id  = " + payphoneId;
                Query<Map<String, Object>> queryResult2
                        = handle.createQuery(afterQuery);
                Map<String, Object> record2 = queryResult2.list().get(0);
                double balanceAfter = (double) record2.get("balance");
                balanceAfter = Double.parseDouble(
                        decimalFormat.format(balanceAfter));

                topupResponse.setId(payphoneId);
                topupResponse.setCreditAfterTopup(balanceAfter);
                topupResponse.setCreditBeforeTopup(balanceBefore);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (handle != null) {
                handle.close();
            }
        }

        return topupResponse;
    }

    public int disablePayphoneServiceById(Long id, String umUserHash, 
            String umSessionID, String umDomain,Status payphoneStatus) {
         int result = 0;
        try {
            String status = payphoneStatus.getStatus().toString(); 
            String newStatus = status.toUpperCase();
            PayphoneDAOInterface ocsInterface
                    = dbi.onDemand(PayphoneDAOInterface.class);
            result = ocsInterface.disablePayphoneById(id, newStatus);
            if (result == 1) {
                payphoneStatus.setStatus(StatusEnum.valueOf(newStatus));
            }
        } catch (Exception ex) {
            return 0;
        } 
         return result;
    }
}
