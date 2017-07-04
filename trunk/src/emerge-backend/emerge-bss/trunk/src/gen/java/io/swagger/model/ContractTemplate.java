package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * ContractTemplate
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T13:42:52.506Z")
public class ContractTemplate {

    private String name = null;

    private String description = null;

    private long contractTemplateId;

    private Date creationDate = null;

    private Date modificationDate = null;

    private String content = null;

    private String createdBy = null;

    /**
     * Gets or Sets provisionedEquipment
     */
    public enum ContractTypeEnum {
        PREPAID("PREPAID"),
        POSTPAID("POSTPAID");

        private String value;

        ContractTypeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private ContractTypeEnum contractType = null;

    public ContractTemplate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * name of the contract template
     *
     * @return name
     *
     */
    @ApiModelProperty(required = true, value = "name of the contract template")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContractTemplate description(String description) {
        this.description = description;
        return this;
    }

    /**
     * description of the contract template
     *
     * @return description
     *
     */
    @ApiModelProperty(required = true, value = "description of the contract template")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ContractTemplate id(long id) {
        this.contractTemplateId = id;
        return this;
    }

    /**
     * contract template ID, managed by the server. Ignored on DELETE, PUT and
     * POST messages.
     *
     * @return id
     *
     */
    @ApiModelProperty(required = true, value = "contract template ID, managed by the server. Ignored on DELETE, PUT and POST messages.")
    public long getContractTemplateId() {
        return contractTemplateId;
    }

    public void setContractTemplateId(long id) {
        this.contractTemplateId = id;
    }

    public ContractTemplate creationDate(Date creationDate) {
        this.creationDate = (Date) creationDate.clone();
        return this;
    }

    /**
     * Date when the contract was created
     *
     * @return creationDate
     *
     */
    @ApiModelProperty(required = true, value = "Date when the contract was created")
    public Date getCreationDate() {
        return (Date) creationDate.clone();
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = (Date) creationDate.clone();
    }

    public ContractTemplate modificationDate(Date modificationDate) {
        this.modificationDate = (Date) modificationDate.clone();
        return this;
    }

    /**
     * Date when the contract was modified
     *
     * @return modificationDate.clone();
     *
     */
    @ApiModelProperty(value = "Date when the contract was modified")
    public Date getModificationDate() {

        return modificationDate == null ? modificationDate : (Date) modificationDate.clone();

    }

    public void setModificationDate(Date modificationDate) {

        this.modificationDate = modificationDate == null ? modificationDate : (Date) modificationDate.clone();
    }

    public ContractTemplate content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Contract template contents
     *
     * @return content
     *
     */
    @ApiModelProperty(required = true, value = "Contract template contents")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ContractTemplate createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Name of the Back office operator who created the contract template
     *
     * @return createdBy
     *
     */
    @ApiModelProperty(required = true, value = "Name of the Back office operator who created the contract template")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ContractTemplate contractType(ContractTypeEnum contractType) {
        this.contractType = contractType;
        return this;
    }

    /**
     * Get contractType
     *
     * @return contractType
     *
     */
    @ApiModelProperty(value = "")
    public ContractTypeEnum getContractType() {
        return contractType;
    }

    public void setContractType(ContractTypeEnum contractType) {
        this.contractType = contractType;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContractTemplate contractTemplate = (ContractTemplate) o;
        return Objects.equals(this.name, contractTemplate.name)
                && Objects.equals(this.description, contractTemplate.description)
                && Objects.equals(this.contractTemplateId, contractTemplate.contractTemplateId)
                && Objects.equals(this.creationDate, contractTemplate.creationDate)
                && Objects.equals(this.modificationDate, contractTemplate.modificationDate)
                && Objects.equals(this.content, contractTemplate.content)
                && Objects.equals(this.createdBy, contractTemplate.createdBy)
                && Objects.equals(this.contractType, contractTemplate.contractType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, contractTemplateId, creationDate, modificationDate, content, createdBy, contractType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContractTemplate {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    id: ").append(toIndentedString(contractTemplateId)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    contractType: ").append(toIndentedString(contractType)).append("\n");
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
