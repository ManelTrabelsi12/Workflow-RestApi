package com.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.Model.WorkflowCategory;

/**
 * 
 * @author MANEL
 *
 */
@Repository
public interface WorkflowCategoryRepository extends JpaRepository<WorkflowCategory, Long> {
	
	@Query(value="select * from workflow_category as wf where wf.name = :name OR wf.status = :status", nativeQuery = true)
	List<WorkflowCategory>	findByNameORStatus (@Param("name")String name,@Param("status") int status);


}
