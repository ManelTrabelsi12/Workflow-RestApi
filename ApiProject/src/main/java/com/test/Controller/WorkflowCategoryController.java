package com.test.Controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.Model.WorkflowCategory;
import com.test.Service.WorkflowCategoryService;

/**
 * 
 * @author MANEL
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping(value="/workflowCategories")
public class WorkflowCategoryController {
	@Autowired
	WorkflowCategoryService workflowCategoryService;

	@GetMapping
	public List<WorkflowCategory> findAll() throws URISyntaxException {

		return workflowCategoryService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<WorkflowCategory> findById(@PathVariable Long id) throws URISyntaxException {
		return workflowCategoryService.findById(id);
	}

	@GetMapping("/filter")
	public List<WorkflowCategory> findByNameORStatus(@RequestParam(value = "name") String name,
			@RequestParam(value = "status") int status) throws URISyntaxException {
		return workflowCategoryService.findByNameORStatus(name, status);
	}

	@PostMapping
	public void saveWorkflowCategory(@RequestBody WorkflowCategory workflowCategory) throws URISyntaxException {
		workflowCategoryService.save(workflowCategory);
	}

	@PutMapping
	public void updateWorkflowCategory(@RequestBody WorkflowCategory workflowCategory) throws URISyntaxException {
		workflowCategoryService.saveOrUpdate(workflowCategory);
	}

	@DeleteMapping("/{id}")
	public void deleteWorkflowCategory(@PathVariable Long id) throws URISyntaxException {

		workflowCategoryService.deleteById(id);
	}


}
