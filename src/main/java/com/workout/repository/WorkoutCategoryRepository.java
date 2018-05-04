package com.workout.repository;

import org.springframework.data.repository.CrudRepository;

import com.workout.model.WorkoutCategory;

public interface WorkoutCategoryRepository extends CrudRepository<WorkoutCategory, Integer> {
	
}
