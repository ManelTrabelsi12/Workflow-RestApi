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

import com.test.Model.Workflow;
import com.test.Service.WorkflowService;

/**
 * 
 * @author MANEL
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/workflows")
public class WorkflowController {
	@Autowired
	WorkflowService workflowService;

	@GetMapping
	public List<Workflow> findAllWorkflow() throws URISyntaxException {

		return workflowService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Workflow> findWorkflowById(@PathVariable Long id) throws URISyntaxException {
		return workflowService.findById(id);
	}

	@GetMapping("/filter")
	public List<Workflow> findByNameORStatus(@RequestParam(value = "name") String name,
			@RequestParam(value = "status") int status) throws URISyntaxException {
		return workflowService.findByNameORStatus(name, status);
	}

	@PostMapping
	public void saveWorkflow(@RequestBody Workflow workflow) throws URISyntaxException {
		workflowService.save(workflow);
	}

	@PutMapping
	public void updateWorkflow(@RequestBody Workflow workflow) throws URISyntaxException {
		workflowService.saveOrUpdate(workflow);
	}

	@DeleteMapping("/{id}")
	public void deleteWorkflow(@PathVariable Long id) throws URISyntaxException {

		workflowService.deleteById(id);
	}

}
