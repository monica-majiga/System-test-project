
package com.java.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class StringDataValue {

	private String dataValue;

	@Id
	private Long modelObjectValueId;

	// primary key and foreign key refers to same column
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "modelObjectValueId")
	private DataModelObjectValue dataObjectValue;

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

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

}
