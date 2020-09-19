package com.test.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 
 * @author MANEL
 *
 */
@Entity
@Table(name="workflow")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idWorkflow")
public class Workflow  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idWorkflow;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	
	 /** 
     * Status is an integer attribute 
     * between 1 and 5. 
     */
	@Column(name = "status")
	@Min(value = 1)
	@Max(value = 5)
	private int status;
/**
 * category is an intermediate Table between workflowCategory and workflow
 * workflow contains workflowCategory list
 * 
 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "category", joinColumns = { @JoinColumn(name = "workflow_id") }, inverseJoinColumns = {
			@JoinColumn(name = "WorkflowCategory_id") })
	private List<WorkflowCategory> workflowCategory = new ArrayList<WorkflowCategory>();
	
/**
 * this is a self-recursive relationship entity
 * workflow has a variants list
 * 
 */
	@ManyToMany
	private List<Workflow> variants = new ArrayList<Workflow>();

	@ManyToMany(mappedBy = "variants", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Workflow> otherWorkflows = new ArrayList<Workflow>();

	public Long getIdWorkflow() {
		return idWorkflow;
	}

	public void setIdWorkflow(Long idWorkflow) {
		this.idWorkflow = idWorkflow;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<WorkflowCategory> getWorkflowCategory() {
		return workflowCategory;
	}

	public void setWorkflowCategory(List<WorkflowCategory> workflowCategory) {
		this.workflowCategory = workflowCategory;
	}

	public List<Workflow> getVariants() {
		return variants;
	}

	public void setVariants(List<Workflow> variants) {
		this.variants = variants;
	}

	public List<Workflow> getOtherWorkflows() {
		return otherWorkflows;
	}

	public void setOtherWorkflows(List<Workflow> otherWorkflows) {
		this.otherWorkflows = otherWorkflows;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Workflow(Long idWorkflow, String name, String description, @Min(1) @Max(5) int status,
			List<WorkflowCategory> workflowCategory, List<Workflow> variants, List<Workflow> otherWorkflows) {
		super();
		this.idWorkflow = idWorkflow;
		this.name = name;
		this.description = description;
		this.status = status;
		this.workflowCategory = workflowCategory;
		this.variants = variants;
		this.otherWorkflows = otherWorkflows;
	}

	public Workflow() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Workflow [idWorkflow=" + idWorkflow + ", name=" + name + ", description=" + description + ", status="
				+ status + ", workflowCategory=" + workflowCategory + ", variants=" + variants + ", otherWorkflows="
				+ otherWorkflows + "]";
	}
	
	
}
