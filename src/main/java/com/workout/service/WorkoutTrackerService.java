package com.workout.service;

import java.util.List;

import com.workout.vo.CategoryVO;
import com.workout.vo.WorkoutVO;

public interface WorkoutTrackerService {

	String createWorkout(WorkoutVO workoutVO);

	List<WorkoutVO> getAllWorkouts();

	String setActiveWorkout(WorkoutVO workoutVO);

	List<WorkoutVO> deleteWorkout(String workoutId);

	List<CategoryVO> viewAllCategory();

	List<CategoryVO> addCategory(CategoryVO categoryVO);

	List<CategoryVO> editCategory(CategoryVO categoryVO);

	List<CategoryVO> deleteCategory(String categoryid);

	String updateWorkout(WorkoutVO workoutVO);

	List<WorkoutVO> getActiveWorkouts();

}
