package com.workout.repository;

import org.springframework.data.repository.CrudRepository;

import com.workout.model.WorkoutActive;

public interface WorkoutActiveRepository extends CrudRepository<WorkoutActive, Integer> {

}
