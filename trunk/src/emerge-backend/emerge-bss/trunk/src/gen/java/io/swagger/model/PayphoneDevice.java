package io.swagger.model;


import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.Objects;

/**
 * PayphoneDevice
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-22T10:40:41.318Z")
public class PayphoneDevice {

    private Long id = 0l;

    private Equipment equipment = null;

    private SIM sim1 = null;

    private SIM sim2 = null;

    private Application application = null;

    private Status status = null;

    private Date creationDate = null;

    private Date modificationDate = null;

    public PayphoneDevice id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * id is created by the OCS when creating a new Payphone. When specified in
     * PUT or POST operations, it is ignored by the server.
     *
     * @return id
  *
     */
    @ApiModelProperty(value = "id is created by the OCS when creating a new Payphone. When specified in PUT or POST operations, it is ignored by the server.")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PayphoneDevice equipment(Equipment equipment) {
        this.equipment = equipment;
        return this;
    }

    /**
     * Get equipment
     *
     * @return equipment
  *
     */
    @ApiModelProperty(required = true, value = "")
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public PayphoneDevice sim1(SIM sim1) {
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

    public PayphoneDevice sim2(SIM sim2) {
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

    public PayphoneDevice application(Application application) {
        this.application = application;
        return this;
    }

    /**
     * Get application
     *
     * @return application
  *
     */
    @ApiModelProperty(required = true, value = "")
    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public PayphoneDevice status(Status status) {
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

    public PayphoneDevice creationDate(Date creationDate) {
        if (creationDate != null) {
            this.creationDate = (Date) creationDate.clone();
        }

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

    public PayphoneDevice modificationDate(Date modificationDate) {
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

        return null;
    }

    public void setModificationDate(Date modificationDate) {
        if (modificationDate != null) {
            this.modificationDate = (Date) modificationDate.clone();
        }
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayphoneDevice payphoneDevice = (PayphoneDevice) o;
        return Objects.equals(this.id, payphoneDevice.id)
                && Objects.equals(this.equipment, payphoneDevice.equipment)
                && Objects.equals(this.sim1, payphoneDevice.sim1)
                && Objects.equals(this.sim2, payphoneDevice.sim2)
                && Objects.equals(this.application, payphoneDevice.application)
                && Objects.equals(this.status, payphoneDevice.status)
                && Objects.equals(this.creationDate, payphoneDevice.creationDate)
                && Objects.equals(this.modificationDate, payphoneDevice.modificationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, equipment, sim1, sim2, application, status, creationDate, modificationDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayphoneDevice {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    equipment: ").append(toIndentedString(equipment)).append("\n");
        sb.append("    sim1: ").append(toIndentedString(sim1)).append("\n");
        sb.append("    sim2: ").append(toIndentedString(sim2)).append("\n");
        sb.append("    application: ").append(toIndentedString(application)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
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
