package com.java.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.project.entities.DataModelObjectValue;
import com.java.project.entities.ModelAttribute;
import com.java.project.model.Department;
import com.java.project.repository.DepartmentRepository;

@Service
public class DepartmentServices {
	
	@Autowired
	DepartmentRepository depRepo;

	public void saveDepartment(Department department) {
		ModelAttribute modelAttribute = new ModelAttribute();
		List<DataModelObjectValue> dataModelObjectValues = modelAttribute.getDataModelObjectValues();
		for (DataModelObjectValue dataModelObjectValue : dataModelObjectValues) {
			dataModelObjectValue.getDataModelObject().setModelObjectId(department.getDeptId());
			if (modelAttribute.getAttributeName() == "name")
				dataModelObjectValue.getStringDataValue().setDataValue(department.getName());
			if (modelAttribute.getAttributeName() == "deptCode")
				dataModelObjectValue.getNumberDataValue().setAttributeValue(department.getDeptCode());
			if (modelAttribute.getAttributeName() == "joiningDate")
				dataModelObjectValue.getDateDataValue().setAttributeValue(department.getJoiningDate());
			modelAttribute.setActive(department.getActive());
			modelAttribute.setCreated_date(department.getCreated_date());
			modelAttribute.setCreatedBy(department.getCreatedBy());
			modelAttribute.setDesc(department.getDesc());
			modelAttribute.setDisplayName(department.getDisplayName());
			modelAttribute.setHasChild(department.isHasChild());
			modelAttribute.setUnique(department.isUnique());
			modelAttribute.setActive(department.getActive());
			// data object value table
			dataModelObjectValue.setCreated_date(department.getCreated_date());
			dataModelObjectValue.setCreatedBy(department.getCreatedBy());
			// data object table
			dataModelObjectValue.getDataModelObject().setCreated_date(department.getCreated_date());
			dataModelObjectValue.getDataModelObject().setCreatedBy(department.getCreatedBy());

			dataModelObjectValues.add(dataModelObjectValue);
		}
		modelAttribute.setDataModelObjectValues(dataModelObjectValues);
		depRepo.save(modelAttribute);
	}

	public List<Department> findAllDepartments() {
		List<ModelAttribute> modelAttributes = depRepo.findAll();
		List<Department> departments = new ArrayList<>();
		for (ModelAttribute modelAttribute : modelAttributes) {
			Department department = new Department();
			for (DataModelObjectValue values : modelAttribute.getDataModelObjectValues()) {
				Long departmentObject = values.getDataModelObject().getModelObjectId();
				if (departmentObject == null || departmentObject.equals(department.getDeptId())) {
					department.setActive(modelAttribute.getActive());
					department.setCreated_date(modelAttribute.getCreated_date());
					department.setCreatedBy(modelAttribute.getCreatedBy());
					department.setDesc(modelAttribute.getDesc());
					department.setDisplayName(modelAttribute.getDisplayName());
					department.setHasChild(modelAttribute.isHasChild());
					department.setUnique(modelAttribute.isUnique());
					department.setDeptId(departmentObject);
					if (modelAttribute.getAttributeName() == "name")
						department.setName(values.getStringDataValue().getDataValue());
					if (modelAttribute.getAttributeName() == "depCode")
						department.setDeptCode(values.getNumberDataValue().getAttributeValue());
					if (modelAttribute.getAttributeName() == "joiningdate")
						department.setJoiningDate(values.getDateDataValue().getAttributeValue());

				}
				departments.add(department);
			}
		}
		return departments;
	}

	public Department findById(Long id) {
		List<ModelAttribute> modelAttributes = depRepo.findAllById(id);
		Department department = new Department();
		for (ModelAttribute modelAttribute : modelAttributes) {
			for (DataModelObjectValue values : modelAttribute.getDataModelObjectValues()) {
				if (modelAttribute.getAttributeName() == "name")
					department.setName(values.getStringDataValue().getDataValue());
				if (modelAttribute.getAttributeName() == "depCode")
					department.setDeptCode(values.getNumberDataValue().getAttributeValue());
				if (modelAttribute.getAttributeName() == "joiningdate")
					department.setJoiningDate(values.getDateDataValue().getAttributeValue());
				department.setActive(modelAttribute.getActive());
				department.setCreated_date(modelAttribute.getCreated_date());
				department.setCreatedBy(modelAttribute.getCreatedBy());
				department.setDesc(modelAttribute.getDesc());
				department.setDisplayName(modelAttribute.getDisplayName());
				department.setHasChild(modelAttribute.isHasChild());
				department.setUnique(modelAttribute.isUnique());
			}
		}

		return department;
	}

	public void deleteDepartment(Long id) {
		ModelAttribute modelAttribute = new ModelAttribute();
		List<DataModelObjectValue> dataModelObjectValues = modelAttribute.getDataModelObjectValues();
		for (DataModelObjectValue dataModelObjectValue : dataModelObjectValues) {
			dataModelObjectValue.setModelObjectValueId(id);
			dataModelObjectValues.add(dataModelObjectValue);
		}
		modelAttribute.setDataModelObjectValues(dataModelObjectValues);
		depRepo.delete(modelAttribute);
	}

}
