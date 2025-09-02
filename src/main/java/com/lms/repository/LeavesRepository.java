package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Leaves;

public interface LeavesRepository extends JpaRepository<Leaves, Long>  {
	List<Leaves> findByEmployee_Id(Long id);

	
}
