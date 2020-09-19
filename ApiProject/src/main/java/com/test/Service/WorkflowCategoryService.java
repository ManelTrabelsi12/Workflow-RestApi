package com.test.Service;

import java.util.List;
import java.util.Optional;

import com.test.Model.WorkflowCategory;
/**
 * 
 * @author MANEL
 *
 */
public interface WorkflowCategoryService {
	
	void saveOrUpdate(WorkflowCategory workflowCategory);

	void deleteById(Long id);

	WorkflowCategory save(WorkflowCategory variable);

	Optional<WorkflowCategory> findById(Long id);

	List<WorkflowCategory> findAll();

	List<WorkflowCategory> findByNameORStatus(String name, int status);

}
