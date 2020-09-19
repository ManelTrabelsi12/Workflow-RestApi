package com.test.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Model.WorkflowCategory;
import com.test.Repository.WorkflowCategoryRepository;
import com.test.Service.WorkflowCategoryService;
/**
 * 
 * @author MANEL
 *
 */
@Service
public class WorkflowCategoryServiceImpl implements WorkflowCategoryService {
	@Autowired
	private WorkflowCategoryRepository workflowCategoryRepository;

	@Override
	public void saveOrUpdate(WorkflowCategory workflowCategory) {
		workflowCategoryRepository.save(workflowCategory);

	}

	@Override
	public WorkflowCategory save(WorkflowCategory workflowCategory) {

		return workflowCategoryRepository.save(workflowCategory);
	}

	@Override
	public void deleteById(Long id) {
		workflowCategoryRepository.deleteById(id);
	}

	@Override
	public Optional<WorkflowCategory> findById(Long id) {
		return workflowCategoryRepository.findById(id);
	}

	@Override
	public List<WorkflowCategory> findAll() {
		return workflowCategoryRepository.findAll();
	}

	@Override
	public List<WorkflowCategory> findByNameORStatus(String name, int status) {
		return workflowCategoryRepository.findByNameORStatus(name, status);
	}
}
