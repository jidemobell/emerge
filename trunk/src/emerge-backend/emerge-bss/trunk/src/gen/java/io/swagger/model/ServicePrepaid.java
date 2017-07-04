package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Product;




/**
 * ServicePrepaid
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T12:02:51.809Z")
public class ServicePrepaid   {
  private long productId;
  private long id;
  private boolean isLegacy = true;

  private String externalProvisionId = null;
  
  private PayphoneService payphoneService = null;

  /**
   * Gets or Sets externalProvisionSystem
   */
  public enum ExternalProvisionSystemEnum {
    TMS("TMS"),
    
    DRM("DRM");

    private String value;

    ExternalProvisionSystemEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private ExternalProvisionSystemEnum externalProvisionSystem = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    READY("READY"),
    
    ACTIVE("ACTIVE"),
    
    DELETED("DELETED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private StatusEnum status = null;

  private String name = null;

  private String deletedReason = null;

  /**
   * Gets or Sets serviceType
   */
  public enum ServiceTypeEnum {
    PSP("PSP"),
    
    TEC("TEC"),
    
    TELOAGENT("TELOAGENT"),
    
    TELOOPERATOR("TELOOPERATOR"),
    
    JEMBI("JEMBI"),
    
    PAYPHONE("PAYPHONE");

    private String value;

    ServiceTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private ServiceTypeEnum serviceType = null;

  private Product product = null;

  public ServicePrepaid productId(long productId) {
    this.productId = productId;
    return this;
  }

   /**
   * Get productId
   * @return productId
  **/
  @ApiModelProperty(required = true, value = "")
  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }
  
  
  public ServicePrepaid id(long id) {
    this.id = id;
    return this;
  }

   /**
   * Get Id
   * @return Id
  **/
  @ApiModelProperty(required = true, value = "")
  public long getServicePrepaidId() {
    return id;
  }

  public void setServicePrepaidId(long id) {
    this.id = id;
  }

    public ServicePrepaid isLegacy(boolean isLegacy) {
    this.isLegacy = isLegacy;
    return this;
  }

   /**
   * Get IsLegacy
   * @return IsLegacy
  **/
  @ApiModelProperty(required = true, value = "")
  public boolean getIsLegacy() {
    return isLegacy;
  }

  public void setIsLegacy(boolean isLegacy) {
    this.isLegacy = isLegacy;
  }
  
  public ServicePrepaid externalProvisionId(String externalProvisionId) {
    this.externalProvisionId = externalProvisionId;
    return this;
  }

   /**
   * Get externalProvisionId
   * @return externalProvisionId
  **/
  @ApiModelProperty(required = true, value = "")
  public String getExternalProvisionId() {
    return externalProvisionId;
  }

  public void setExternalProvisionId(String externalProvisionId) {
    this.externalProvisionId = externalProvisionId;
  }

  public ServicePrepaid externalProvisionSystem(ExternalProvisionSystemEnum externalProvisionSystem) {
    this.externalProvisionSystem = externalProvisionSystem;
    return this;
  }

   /**
   * Get externalProvisionSystem
   * @return externalProvisionSystem
  **/
  @ApiModelProperty(required = true, value = "")
  public ExternalProvisionSystemEnum getExternalProvisionSystem() {
    return externalProvisionSystem;
  }

  public void setExternalProvisionSystem(ExternalProvisionSystemEnum externalProvisionSystem) {
    this.externalProvisionSystem = externalProvisionSystem;
  }

  public ServicePrepaid status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ServicePrepaid name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServicePrepaid deletedReason(String deletedReason) {
    this.deletedReason = deletedReason;
    return this;
  }

   /**
   * Get deletedReason
   * @return deletedReason
  **/
  @ApiModelProperty(value = "")
  public String getDeletedReason() {
    return deletedReason;
  }

  public void setDeletedReason(String deletedReason) {
    this.deletedReason = deletedReason;
  }

  public ServicePrepaid serviceType(ServiceTypeEnum serviceType) {
    this.serviceType = serviceType;
    return this;
  }

   /**
   * Get serviceType
   * @return serviceType
  **/
  @ApiModelProperty(required = true, value = "")
  public ServiceTypeEnum getServiceType() {
    return serviceType;
  }

  public void setServiceType(ServiceTypeEnum serviceType) {
    this.serviceType = serviceType;
  }

  public ServicePrepaid product(Product product) {
    this.product = product;
    return this;
  }

   /**
   * Get product
   * @return product
  **/
  @ApiModelProperty(required = true, value = "")
  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
  
      public ServicePrepaid payphoneService(PayphoneService payphoneService) {
        this.payphoneService = payphoneService;
        return this;
    }

    /**
     * Get payphoneService
     *
     * @return payphoneService
  *if (creationDate != null) {
            return (Date) creationDate.clone();
        }
        return null;
    }
     */
    @ApiModelProperty(value = "")
    public PayphoneService getPayphoneService() {
        if (payphoneService != null){
        return payphoneService;
        }
        return null;
    }

    public void setPayphoneService(PayphoneService payphoneService) {
        this.payphoneService = payphoneService;
    }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServicePrepaid servicePrepaid = (ServicePrepaid) o;
    return Objects.equals(this.productId, servicePrepaid.productId) &&
            Objects.equals(this.id, servicePrepaid.id) &&
        Objects.equals(this.externalProvisionId, servicePrepaid.externalProvisionId) &&
        Objects.equals(this.externalProvisionSystem, servicePrepaid.externalProvisionSystem) &&
        Objects.equals(this.status, servicePrepaid.status) &&
        Objects.equals(this.name, servicePrepaid.name) &&
        Objects.equals(this.deletedReason, servicePrepaid.deletedReason) &&
        Objects.equals(this.serviceType, servicePrepaid.serviceType) &&
        Objects.equals(this.isLegacy, servicePrepaid.isLegacy) &&
        Objects.equals(this.product, servicePrepaid.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId,id, externalProvisionId, externalProvisionSystem, status, name, productId,deletedReason, serviceType, isLegacy, product);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServicePrepaid {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    externalProvisionId: ").append(toIndentedString(externalProvisionId)).append("\n");
    sb.append("    externalProvisionSystem: ").append(toIndentedString(externalProvisionSystem)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    deletedReason: ").append(toIndentedString(deletedReason)).append("\n");
    sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    isLegacy: ").append(toIndentedString(isLegacy)).append("\n");
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

