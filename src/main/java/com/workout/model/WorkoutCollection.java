package com.workout.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workout_collection")
public class WorkoutCollection implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "workout_id")
	private int workoutId;
	
	@Column(name = "workout_title")
	private String workoutTitle;
	
	@Column(name = "workout_note")
	private String workoutNote;
	
	@Column(name = "calories_burn_per_min")
	private float caloriesBurnPerMin;
	
	@Column(name = "category_id", insertable = false, updatable = false)
	private int categoryId;
	
	@OneToOne
	@JoinColumn(name="category_id") 
	private WorkoutCategory workoutCategory;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public WorkoutCategory getWorkoutCategory() {
		return workoutCategory;
	}

	public void setWorkoutCategory(WorkoutCategory workoutCategory) {
		this.workoutCategory = workoutCategory;
	}

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	public String getWorkoutTitle() {
		return workoutTitle;
	}

	public void setWorkoutTitle(String workoutTitle) {
		this.workoutTitle = workoutTitle;
	}

	public String getWorkoutNote() {
		return workoutNote;
	}

	public void setWorkoutNote(String workoutNote) {
		this.workoutNote = workoutNote;
	}

	public float getCaloriesBurnPerMin() {
		return caloriesBurnPerMin;
	}

	public void setCaloriesBurnPerMin(float caloriesBurnPerMin) {
		this.caloriesBurnPerMin = caloriesBurnPerMin;
	}

}
