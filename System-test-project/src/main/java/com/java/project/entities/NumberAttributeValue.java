package com.java.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
@Entity
public class NumberAttributeValue {
	private Long attributeValue;

	@Id
	private Long modelObjectValueId;

	// primary key and foreign key refers to same column
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "modelObjectValueId")
	private DataModelObjectValue dataObjectValue;

	public Long getModelObjectValueId() {
		return modelObjectValueId;
	}

	public void setModelObjectValueId(Long modelObjectValueId) {
		this.modelObjectValueId = modelObjectValueId;
	}

	public DataModelObjectValue getDataObjectValue() {
		return dataObjectValue;
	}

	public void setDataObjectValue(DataModelObjectValue dataObjectValue) {
		this.dataObjectValue = dataObjectValue;
	}

	public Long getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(Long attributeValue) {
		this.attributeValue = attributeValue;
	}
}
