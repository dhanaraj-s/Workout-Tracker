package com.workout.vo;

import java.util.Date;

public class WorkoutVO {
	
	private Integer workoutId;
	
	private String workoutTitle;
	
	private String workoutNote;
	
	private Float caloriesBurnPerMin;
	
	private Integer categoryId;
	
	private String startTime;
	
	private String startDate;
	
	private String endTime;
	
	private String endDate;
	
	private String comment;

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
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

	public Float getCaloriesBurnPerMin() {
		return caloriesBurnPerMin;
	}

	public void setCaloriesBurnPerMin(Float caloriesBurnPerMin) {
		this.caloriesBurnPerMin = caloriesBurnPerMin;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "WorkoutVO [workoutId=" + workoutId + ", workoutTitle=" + workoutTitle + ", workoutNote=" + workoutNote
				+ ", caloriesBurnPerMin=" + caloriesBurnPerMin + ", categoryId=" + categoryId + ", startTime="
				+ startTime + ", startDate=" + startDate + ", endTime=" + endTime + ", endDate=" + endDate
				+ ", comment=" + comment + "]";
	}


}
