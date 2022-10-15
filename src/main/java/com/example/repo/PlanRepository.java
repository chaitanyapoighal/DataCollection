package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

	@Query(value="select planId From Plan Where Name=:planname")
	public Integer getPlanId(String planname);
}
