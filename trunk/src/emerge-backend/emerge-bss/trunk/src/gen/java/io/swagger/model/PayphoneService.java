/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.Objects;

/**
 * PayphoneService
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-22T10:40:41.318Z")
public class PayphoneService {

    private Long id = 0l;

    private Long payphoneDeviceId = 0l;

    private SIM sim1 = null;

    private SIM sim2 = null;

    private Long customerId = 0l;

    private long contractId = 0l;

    private long profileId = 0l;

    private Double balance = 0.0;

    private Status status = null;

    private Date creationDate = null;

    private Date modificationDate = null;

    private PayphoneCredentials credentials = null;

    private ConfigData configData = null;

    private PayphoneDevice payphoneDevice = null;

//  private int code = 0 ;
//  
//  private String message = null ;
    public PayphoneService id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * id is created by the OCS when creating a new PayphoneService. When
     * specified in PUT or POST operations, it is ignored by the server.
     *
     * @return id
     *
     */
    @ApiModelProperty(value = "id is created by the OCS when creating a new PayphoneService. When specified in PUT or POST operations, it is ignored by the server.")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PayphoneService payphoneDeviceId(Long payphoneDeviceId) {
        this.payphoneDeviceId = payphoneDeviceId;
        return this;
    }

    /**
     * payphone_device_id is associated by the OCS backend when the device
     * Authenticates or StartsSession.
     *
     * @return payphoneDeviceId
     *
     */
    @ApiModelProperty(value = "payphone_device_id is associated by the OCS backend when the device Authenticates or StartsSession.")
    public Long getPayphoneDeviceId() {
        return payphoneDeviceId;
    }

    public void setPayphoneDeviceId(Long payphoneDeviceId) {
        this.payphoneDeviceId = payphoneDeviceId;
    }

    public PayphoneService sim1(SIM sim1) {
        this.sim1 = sim1;
        return this;
    }

    /**
     * Get sim1
     *
     * @return sim1
     *
     */
    @ApiModelProperty(required = true, value = "")
    public SIM getSim1() {
        return sim1;
    }

    public void setSim1(SIM sim1) {
        this.sim1 = sim1;
    }

    public PayphoneService sim2(SIM sim2) {
        this.sim2 = sim2;
        return this;
    }

    /**
     * Get sim2
     *
     * @return sim2
     *
     */
    @ApiModelProperty(value = "")
    public SIM getSim2() {
        return sim2;
    }

    public void setSim2(SIM sim2) {
        this.sim2 = sim2;
    }

    public PayphoneService customerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Get customerId
     *
     * @return customerId
     *
     */
    @ApiModelProperty(value = "")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public PayphoneService contractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    /**
     * Get contractId
     *
     * @return contractId
     *
     */
    @ApiModelProperty(value = "")
    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public PayphoneService profileId(Long profileId) {
        this.profileId = profileId;
        return this;
    }

    /**
     * Get profileId
     *
     * @return profileId
     *
     */
    @ApiModelProperty(value = "")
    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public PayphoneService balance(Double balance) {
        this.balance = balance;
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     *
     */
    @ApiModelProperty(value = "")
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public PayphoneService status(Status status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     *
     */
    @ApiModelProperty(value = "")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PayphoneService creationDate(Date creationDate) {
        this.creationDate = (Date) creationDate.clone();
        return this;
    }

    /**
     * Get creationDate
     *
     * @return creationDate
     *
     */
    @ApiModelProperty(value = "")
    public Date getCreationDate() {
        if (creationDate != null) {
            return (Date) creationDate.clone();
        }
        return null;
    }

    public void setCreationDate(Date creationDate) {
        if (creationDate != null) {
            this.creationDate = (Date) creationDate.clone();
        }
    }

    public PayphoneService modificationDate(Date modificationDate) {
        if (modificationDate != null) {
            this.modificationDate = (Date) modificationDate.clone();
        }
        return this;
    }

    /**
     * Get modificationDate
     *
     * @return modificationDate
     *
     */
    @ApiModelProperty(value = "")
    public Date getModificationDate() {
        if (modificationDate != null) {
            return (Date) modificationDate.clone();
        }
        return new Date();
    }

    public void setModificationDate(Date modificationDate) {
        if (modificationDate != null) {
            this.modificationDate = (Date) modificationDate.clone();
        }
    }

    public PayphoneService credentials(PayphoneCredentials credentials) {
        this.credentials = credentials;
        return this;
    }

    /**
     * Get credentials
     *
     * @return credentials
     *
     */
    @ApiModelProperty(value = "")
    public PayphoneCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(PayphoneCredentials credentials) {
        this.credentials = credentials;
    }

    public PayphoneService configData(ConfigData configData) {
        this.configData = configData;
        return this;
    }

    /**
     * Get configData
     *
     * @return configData
     *
     */
    @ApiModelProperty(value = "")
    public ConfigData getConfigData() {
        return configData;
    }

    public void setConfigData(ConfigData configData) {
        this.configData = configData;
    }

    public PayphoneService payphoneDevice(PayphoneDevice payphoneDevice) {
        this.payphoneDevice = payphoneDevice;
        return this;
    }

    /**
     * Get configData
     *
     * @return configData
     *
     */
    @ApiModelProperty(value = "")
    public PayphoneDevice getPayphoneDevice() {
        return payphoneDevice;
    }

    public void setPayphoneDevice(PayphoneDevice payphoneDevice) {
        this.payphoneDevice = payphoneDevice;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayphoneService payphoneService = (PayphoneService) o;
        return Objects.equals(this.id, payphoneService.id)
                && Objects.equals(this.payphoneDeviceId, payphoneService.payphoneDeviceId)
                && Objects.equals(this.sim1, payphoneService.sim1)
                && Objects.equals(this.sim2, payphoneService.sim2)
                && Objects.equals(this.customerId, payphoneService.customerId)
                && Objects.equals(this.contractId, payphoneService.contractId)
                && Objects.equals(this.profileId, payphoneService.profileId)
                && Objects.equals(this.balance, payphoneService.balance)
                && Objects.equals(this.status, payphoneService.status)
                && Objects.equals(this.creationDate, payphoneService.creationDate)
                && Objects.equals(this.modificationDate, payphoneService.modificationDate)
                && Objects.equals(this.credentials, payphoneService.credentials)
                && Objects.equals(this.configData, payphoneService.configData)
                && Objects.equals(this.payphoneDevice, payphoneService.payphoneDevice);
//        Objects.equals(this.code, payphoneService.code) &&
//        Objects.equals(this.message, payphoneService.message);

//payphoneDevice
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payphoneDeviceId, sim1, sim2, customerId, contractId, profileId, balance, status, creationDate, modificationDate, credentials, configData, payphoneDevice);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayphoneService {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    payphoneDeviceId: ").append(toIndentedString(payphoneDeviceId)).append("\n");
        sb.append("    sim1: ").append(toIndentedString(sim1)).append("\n");
        sb.append("    sim2: ").append(toIndentedString(sim2)).append("\n");
        sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
        sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
        sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
        sb.append("    credentials: ").append(toIndentedString(credentials)).append("\n");
        sb.append("    configData: ").append(toIndentedString(configData)).append("\n");
        sb.append("    payphoneDevice: ").append(toIndentedString(payphoneDevice)).append("\n");
//    sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
