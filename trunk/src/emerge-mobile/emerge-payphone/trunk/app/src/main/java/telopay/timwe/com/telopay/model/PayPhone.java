package telopay.timwe.com.telopay.model;

/**
 * Created by timwe.tunji on 10/11/2016.
 */

public class PayPhone {

    private String payphoneID;
    private Equipment equipment;
    private SIM sim1;
    private SIM sim2;
    private Application application;
    private String customerID;
    private String accountID;
    private double balance;
    private Status status;
    private String creationDate;
    private String modificationDate;
    private PayphoneCredential credentials;
    private ConfigData configData;


    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getPayphoneID() {
        return payphoneID;
    }

    public void setPayphoneID(String payphoneID) {
        this.payphoneID = payphoneID;
    }

    public SIM getSim1() {
        return sim1;
    }

    public void setSim1(SIM sim1) {
        this.sim1 = sim1;
    }

    public SIM getSim2() {
        return sim2;
    }

    public void setSim2(SIM sim2) {
        this.sim2 = sim2;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public PayphoneCredential getCredentials() {
        return credentials;
    }

    public void setCredentials(PayphoneCredential credentials) {
        this.credentials = credentials;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }



    public ConfigData getConfigData() {
        return configData;
    }

    public void setConfigData(ConfigData configData) {
        this.configData = configData;
    }
}
