package com.java.project.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
@Entity
public class DataModelObjectValue {
	@Id
	private Long modelObjectValueId;
	private Date created_date;
	private String createdBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modelAttributeId")
	private ModelAttribute modelAttribute;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modelObjectId")
	private DataModelObject dataModelObject;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="modelObjectValueId")
	private StringDataValue stringDataValue;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="modelObjectValueId")
	private NumberAttributeValue numberDataValue;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="modelObjectValueId")
	private DateAttributeValue dateDataValue;

	public Long getModelObjectValueId() {
		return modelObjectValueId;
	}

	public void setModelObjectValueId(Long modelObjectValueId) {
		this.modelObjectValueId = modelObjectValueId;
	}

	public ModelAttribute getModelAttribute() {
		return modelAttribute;
	}

	public void setModelAttribute(ModelAttribute modelAttribute) {
		this.modelAttribute = modelAttribute;
	}

	public DataModelObject getDataModelObject() {
		return dataModelObject;
	}

	public void setDataModelObject(DataModelObject dataModelObject) {
		this.dataModelObject = dataModelObject;
	}

	public StringDataValue getStringDataValue() {
		return stringDataValue;
	}

	public void setStringDataValue(StringDataValue stringDataValue) {
		this.stringDataValue = stringDataValue;
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

	public NumberAttributeValue getNumberDataValue() {
		return numberDataValue;
	}

	public void setNumberDataValue(NumberAttributeValue numberDataValue) {
		this.numberDataValue = numberDataValue;
	}

	public DateAttributeValue getDateDataValue() {
		return dateDataValue;
	}

	public void setDateDataValue(DateAttributeValue dateDataValue) {
		this.dateDataValue = dateDataValue;
	}
	
}
