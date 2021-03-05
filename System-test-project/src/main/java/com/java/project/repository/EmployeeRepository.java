package com.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.project.entities.ModelAttribute;

@Repository
public interface EmployeeRepository extends CrudRepository<ModelAttribute, Long> {

	@Query(value = "select * FROM Model_attribute ma \r\n" + "join data_model_object_value dv \r\n"
			+ "on ma.model_attribute_id = dv.model_attribute_id \r\n" + "join string_data_value s \r\n"
			+ "on dv.model_object_value_id = s.model_object_value_id \r\n"
			+ "and ma.model_name_id=1", nativeQuery = true)
	public List<ModelAttribute> findAll();

	@Query(value = "select ma FROM model_attribute ma \r\n" + "join data_model_object_value dv \r\n"
			+ "on ma.model_attribute_id = dv.model_attribute_id \r\n" + "join string_data_value s \r\n"
			+ "on dv.model_object_value_id = s.model_object_value_id \r\n"
			+ "and ma.model_name_id=1 and dv.model_object_id=:id", nativeQuery = true)
	public List<ModelAttribute> findAllById(@Param("id") Long id);

}
