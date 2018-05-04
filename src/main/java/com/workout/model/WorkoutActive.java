package com.workout.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workout_active")
public class WorkoutActive implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@Column(name = "workout_id", insertable = false, updatable = false)
	private int workoutId;
	
	@Column(name = "start_time")
	private Time startTime;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "end_time")
	private Time endTime;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "status")
	private boolean status;
	
	@OneToOne
	@JoinColumn(name = "workout_id")
	private WorkoutCollection workoutCollection;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public WorkoutCollection getWorkoutCollection() {
		return workoutCollection;
	}

	public void setWorkoutCollection(WorkoutCollection workoutCollection) {
		this.workoutCollection = workoutCollection;
	}
		
	
}