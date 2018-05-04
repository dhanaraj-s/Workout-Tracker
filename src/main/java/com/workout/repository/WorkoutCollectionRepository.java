package com.workout.repository;

import org.springframework.data.repository.CrudRepository;

import com.workout.model.WorkoutCollection;

public interface WorkoutCollectionRepository extends CrudRepository<WorkoutCollection, Integer> {

}
