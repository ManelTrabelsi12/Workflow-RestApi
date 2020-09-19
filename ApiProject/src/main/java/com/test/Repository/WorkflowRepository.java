package com.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.Model.Workflow;

/**
 * 
 * @author MANEL
 *
 */
@Repository
public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
	
	@Query(value ="select * from workflow as w where w.name = :name OR w.status = :status", nativeQuery = true)
     List<Workflow>	findByNameORStatus (@Param("name")String name,@Param("status") int status);

}
