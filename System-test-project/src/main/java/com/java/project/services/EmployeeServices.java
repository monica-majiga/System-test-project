package com.java.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.project.entities.DataModelObjectValue;
import com.java.project.entities.ModelAttribute;
import com.java.project.model.Employee;
import com.java.project.repository.EmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeRepository empRepo;

	public void saveEmployee(Employee employee) {
		ModelAttribute modelAttribute = new ModelAttribute();
		List<DataModelObjectValue> dataModelObjectValues = modelAttribute.getDataModelObjectValues();
		for (DataModelObjectValue dataModelObjectValue : dataModelObjectValues) {
			dataModelObjectValue.getDataModelObject().setModelObjectId(employee.getEmpId());
			if (modelAttribute.getAttributeName() == "firstName")
				dataModelObjectValue.getStringDataValue().setDataValue(employee.getFirstName());
			if (modelAttribute.getAttributeName() == "LastName")
				dataModelObjectValue.getStringDataValue().setDataValue(employee.getLastName());
			if (modelAttribute.getAttributeName() == "age")
				dataModelObjectValue.getNumberDataValue().setAttributeValue(employee.getAge());
			if (modelAttribute.getAttributeName() == "dob")
				dataModelObjectValue.getDateDataValue().setAttributeValue(employee.getDob());
			modelAttribute.setActive(employee.getActive());
			modelAttribute.setCreated_date(employee.getCreated_date());
			modelAttribute.setCreatedBy(employee.getCreatedBy());
			modelAttribute.setDesc(employee.getDesc());
			modelAttribute.setDisplayName(employee.getDisplayName());
			modelAttribute.setHasChild(employee.isHasChild());
			modelAttribute.setUnique(employee.isUnique());
			modelAttribute.setActive(employee.getActive());
			//data object value table
			dataModelObjectValue.setCreated_date(employee.getCreated_date());
			dataModelObjectValue.setCreatedBy(employee.getCreatedBy());
			//data object table
			dataModelObjectValue.getDataModelObject().setCreated_date(employee.getCreated_date());
			dataModelObjectValue.getDataModelObject().setCreatedBy(employee.getCreatedBy());
			
			dataModelObjectValues.add(dataModelObjectValue);
		}
		modelAttribute.setDataModelObjectValues(dataModelObjectValues);
		empRepo.save(modelAttribute);
	}

	public List<Employee> findAllEmployees() {
		List<ModelAttribute> modelAttributes = empRepo.findAll();
		List<Employee> employees = new ArrayList<>();
		for (ModelAttribute modelAttribute : modelAttributes) {
			Employee employee = new Employee();
			for (DataModelObjectValue values : modelAttribute.getDataModelObjectValues()) {
				Long employeeObject = values.getDataModelObject().getModelObjectId();
				if (employeeObject == null || employeeObject.equals(employee.getEmpId())) {
					employee.setActive(modelAttribute.getActive());
					employee.setCreated_date(modelAttribute.getCreated_date());
					employee.setCreatedBy(modelAttribute.getCreatedBy());
					employee.setDesc(modelAttribute.getDesc());
					employee.setDisplayName(modelAttribute.getDisplayName());
					employee.setHasChild(modelAttribute.isHasChild());
					employee.setUnique(modelAttribute.isUnique());
					employee.setActive(modelAttribute.getActive());
					employee.setEmpId(employeeObject);
					if (modelAttribute.getAttributeName() == "firstName")
						employee.setFirstName(values.getStringDataValue().getDataValue());
					if (modelAttribute.getAttributeName() == "lastName")
						employee.setFirstName(values.getStringDataValue().getDataValue());
					if (modelAttribute.getAttributeName() == "age")
						employee.setAge(values.getNumberDataValue().getAttributeValue());
					if (modelAttribute.getAttributeName() == "dob")
						employee.setDob(values.getDateDataValue().getAttributeValue());

				}
				employees.add(employee);

			}
		}
		return employees;
	}

	public Employee findById(Long id) {
		List<ModelAttribute> modelAttributes = empRepo.findAllById(id);
		Employee employee = new Employee();
		for (ModelAttribute modelAttribute : modelAttributes) {
			for (DataModelObjectValue values : modelAttribute.getDataModelObjectValues()) {
				if (modelAttribute.getAttributeName() == "firstName")
					employee.setFirstName(values.getStringDataValue().getDataValue());
				if (modelAttribute.getAttributeName() == "lastName")
					employee.setFirstName(values.getStringDataValue().getDataValue());
				if (modelAttribute.getAttributeName() == "age")
					employee.setAge(values.getNumberDataValue().getAttributeValue());
				if (modelAttribute.getAttributeName() == "dob")
					employee.setDob(values.getDateDataValue().getAttributeValue());
				employee.setActive(modelAttribute.getActive());
				employee.setCreated_date(modelAttribute.getCreated_date());
				employee.setCreatedBy(modelAttribute.getCreatedBy());
				employee.setDesc(modelAttribute.getDesc());
				employee.setDisplayName(modelAttribute.getDisplayName());
				employee.setHasChild(modelAttribute.isHasChild());
				employee.setUnique(modelAttribute.isUnique());
				employee.setActive(modelAttribute.getActive());
			}
		}

		return employee;
	}

	public void deleteEmployee(Long id) {
		ModelAttribute modelAttribute = new ModelAttribute();
		List<DataModelObjectValue> dataModelObjectValues = modelAttribute.getDataModelObjectValues();
		for (DataModelObjectValue dataModelObjectValue : dataModelObjectValues) {
			dataModelObjectValue.setModelObjectValueId(id);
		dataModelObjectValues.add(dataModelObjectValue);
		}
		modelAttribute.setDataModelObjectValues(dataModelObjectValues);
		empRepo.delete(modelAttribute);
	}

}
