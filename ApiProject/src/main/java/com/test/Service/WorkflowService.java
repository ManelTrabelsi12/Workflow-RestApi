package com.test.Service;

import java.util.List;
import java.util.Optional;

import com.test.Model.Workflow;

/**
 * 
 * @author MANEL
 *
 */
public interface WorkflowService {
	void saveOrUpdate(Workflow workflow);

	void deleteById(Long id);

	Workflow save(Workflow variable);

	Optional<Workflow> findById(Long id);

	List<Workflow> findAll();

	List<Workflow> findByNameORStatus(String name, int status);
}
