package com.test.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Model.Workflow;
import com.test.Repository.WorkflowRepository;
import com.test.Service.WorkflowService;
/**
 * 
 * @author MANEL
 *
 */
@Service
public class WorkflowServiceImpl implements WorkflowService {
	@Autowired
	private WorkflowRepository workflowRepository;

	@Override
	public void saveOrUpdate(Workflow workflow) {
		workflowRepository.save(workflow);
	}

	@Override
	public Workflow save(Workflow workflow) {
		return workflowRepository.save(workflow);
	}

	@Override
	public void deleteById(Long id) {
		workflowRepository.deleteById(id);
	}

	@Override
	public Optional<Workflow> findById(Long id) {
		return workflowRepository.findById(id);
	}

	@Override
	public List<Workflow> findAll() {
		return workflowRepository.findAll();
	}

	@Override
	public List<Workflow> findByNameORStatus(String name, int status) {
		return workflowRepository.findByNameORStatus(name, status);
	}
}
