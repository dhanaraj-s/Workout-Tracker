/**
 * 
 */
package com.workout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.service.WorkoutTrackerService;
import com.workout.vo.CategoryVO;
import com.workout.vo.WorkoutVO;

/**
 * @author Admin
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200") 
/**Use the below mapping when you are running this spring boot application using jar.*/
/**@RequestMapping(value="/workouttracker")*/ 
public class WorkoutTrackerController {
	
	@Autowired
	private WorkoutTrackerService workoutTrackerService;
	
	@RequestMapping(value="/viewallworkout", method = RequestMethod.GET)
	public List<WorkoutVO> viewAllWorkout() {
		return workoutTrackerService.getAllWorkouts();
	}
	
	@RequestMapping(value="/createworkout", method = RequestMethod.POST)
	public String createWorkout(@RequestBody WorkoutVO workoutVO) {
		return workoutTrackerService.createWorkout(workoutVO);
	}
	
	@RequestMapping(value="/deleteworkout/{workoutid}", method = RequestMethod.DELETE)
	public List<WorkoutVO> deleteWorkout(@PathVariable String workoutid) {
		return workoutTrackerService.deleteWorkout(workoutid);
	}
	
	@RequestMapping(value="/updateworkout", method = RequestMethod.POST)
	public String updateWorkout(@RequestBody WorkoutVO workoutVO) {
		return workoutTrackerService.updateWorkout(workoutVO);
	}
	
	@RequestMapping(value="/setactiveworkout", method = RequestMethod.POST)
	public String setActiveWorkout(@RequestBody WorkoutVO workoutVO) {
		return workoutTrackerService.setActiveWorkout(workoutVO);
	}
	
	@RequestMapping(value="/getactiveworkouts", method = RequestMethod.GET)
	public List<WorkoutVO> getActiveWorkouts() {
		return workoutTrackerService.getActiveWorkouts();
	}
	
	@RequestMapping(value="/viewallcategory", method = RequestMethod.GET)
	public List<CategoryVO> viewAllCategory() {
		return workoutTrackerService.viewAllCategory();
	}
	
	@RequestMapping(value="/addcategory", method = RequestMethod.POST)
	public List<CategoryVO> addCategory(@RequestBody CategoryVO categoryVO) {
		return workoutTrackerService.addCategory(categoryVO);
	}
	
	@RequestMapping(value="/editcategory", method = RequestMethod.POST)
	public List<CategoryVO> editCategory(@RequestBody CategoryVO categoryVO) {
		return workoutTrackerService.editCategory(categoryVO);
	}
	
	@RequestMapping(value="/deletecategory/{categoryid}", method = RequestMethod.DELETE)
	public List<CategoryVO> deleteCategory(@PathVariable String categoryid) {
		return workoutTrackerService.deleteCategory(categoryid);
	}
}
