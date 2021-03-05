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
public class DataModelObject {
	@Id
	private Long modelObjectId;
	private Date created_date;
	private String createdBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modelNameId")
	private ModelName modelName;
	
	@OneToMany(mappedBy = "dataModelObject",cascade = CascadeType.ALL)
	private List<DataModelObjectValue> dataModelObjectValues = new ArrayList<>();
	

	public Long getModelObjectId() {
		return modelObjectId;
	}

	public void setModelObjectId(Long modelObjectId) {
		this.modelObjectId = modelObjectId;
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
