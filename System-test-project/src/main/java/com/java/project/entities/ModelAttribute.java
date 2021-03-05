package com.java.project.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ModelAttribute {
	@Id
	private Long modelAttributeId;
	private String attributeName;
	private String displayName;
	private String dataType;
	private Boolean active;
	private boolean mandatory;
	private boolean isUnique;
	private boolean hasChild;
	private boolean isVisible;
	private String desc;
	private Date created_date;
	private String createdBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modelNameId")
	private ModelName modelName;
	
	@OneToMany(mappedBy = "modelAttribute",cascade = CascadeType.ALL)
	private List<DataModelObjectValue> dataModelObjectValues = new ArrayList<>();

	public Long getModelAttributeId() {
		return modelAttributeId;
	}

	public void setModelAttributeId(Long modelAttributeId) {
		this.modelAttributeId = modelAttributeId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public ModelName getModelName() {
		return modelName;
	}

	public void setModelName(ModelName modelName) {
		this.modelName = modelName;
	}

	public List<DataModelObjectValue> getDataModelObjectValues() {
		return dataModelObjectValues;
	}

	public void setDataModelObjectValues(List<DataModelObjectValue> dataModelObjectValues) {
		this.dataModelObjectValues = dataModelObjectValues;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public boolean isUnique() {
		return isUnique;
	}

	public void setUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
