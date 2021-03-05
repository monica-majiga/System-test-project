package com.java.project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ModelName {
	@Id
	private Long id;
	private String entityName;
	private String displayName;
	private String parentModelId;

	@OneToMany(mappedBy = "modelName",cascade = CascadeType.ALL)
	private List<ModelAttribute> modelAttributes = new ArrayList<>();
	
	@OneToMany(mappedBy = "modelName",cascade = CascadeType.ALL)
	private List<DataModelObject> dataModelObjects = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getParentModelId() {
		return parentModelId;
	}

	public void setParentModelId(String parentModelId) {
		this.parentModelId = parentModelId;
	}

	public List<ModelAttribute> getModelAttributes() {
		return modelAttributes;
	}

	public void setModelAttributes(List<ModelAttribute> modelAttributes) {
		this.modelAttributes = modelAttributes;
	}

	public List<DataModelObject> getDataModelObjects() {
		return dataModelObjects;
	}

	public void setDataModelObjects(List<DataModelObject> dataModelObjects) {
		this.dataModelObjects = dataModelObjects;
	}

	
}
