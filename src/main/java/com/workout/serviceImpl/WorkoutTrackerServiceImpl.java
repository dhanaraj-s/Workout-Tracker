/**
 * 
 */
package com.workout.serviceImpl;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workout.model.WorkoutActive;
import com.workout.model.WorkoutCategory;
import com.workout.model.WorkoutCollection;
import com.workout.repository.WorkoutActiveRepository;
import com.workout.repository.WorkoutCategoryRepository;
import com.workout.repository.WorkoutCollectionRepository;
import com.workout.service.WorkoutTrackerService;
import com.workout.vo.CategoryVO;
import com.workout.vo.WorkoutVO;

/**
 * @author Admin
 *
 */
@Service("workoutTrackerService")
public class WorkoutTrackerServiceImpl implements WorkoutTrackerService {

	@Autowired
	private WorkoutCollectionRepository workoutCollectionRepository;

	@Autowired
	private WorkoutCategoryRepository workoutCategoryRepository;

	@Autowired
	private WorkoutActiveRepository workoutActiveRepository;

	@Override
	public List<WorkoutVO> getAllWorkouts() {
		List<WorkoutVO> workoutList = new ArrayList<>();
		List<WorkoutCollection> workoutEntityList = (List<WorkoutCollection>) workoutCollectionRepository.findAll();
		for (WorkoutCollection workoutCollection : workoutEntityList) {
			WorkoutVO workoutVO = new WorkoutVO();
			workoutVO.setWorkoutId(workoutCollection.getWorkoutId());
			workoutVO.setWorkoutTitle(workoutCollection.getWorkoutTitle());
			workoutVO.setWorkoutNote(workoutCollection.getWorkoutNote());
			workoutVO.setCaloriesBurnPerMin(workoutCollection.getCaloriesBurnPerMin());
			workoutVO.setCategoryId(workoutCollection.getWorkoutCategory().getCategoryId());
			workoutList.add(workoutVO);
		}
		return workoutList;
	}

	@Override
	public String createWorkout(WorkoutVO workoutVO) {
		WorkoutCollection workoutCollection = mapWorkoutCollection(workoutVO);
		if (null != workoutCollection) {
			workoutCollectionRepository.save(workoutCollection);
			return "success";
		}
		return "failure";
	}

	private WorkoutCollection mapWorkoutCollection(WorkoutVO workoutVO) {
		WorkoutCollection workoutCollection = null;
		Optional<WorkoutCategory> workoutCategory = workoutCategoryRepository.findById(workoutVO.getCategoryId());
		if (workoutCategory.isPresent()) {
			workoutCollection = new WorkoutCollection();
			workoutCollection.setWorkoutCategory(workoutCategory.get());
			workoutCollection.setWorkoutTitle(workoutVO.getWorkoutTitle());
			workoutCollection.setWorkoutNote(workoutVO.getWorkoutNote());
			workoutCollection.setCaloriesBurnPerMin(workoutVO.getCaloriesBurnPerMin());
		}
		return workoutCollection;
	}

	@Override
	public String updateWorkout(WorkoutVO workoutVO) {
		Optional<WorkoutCollection> workoutCollection = workoutCollectionRepository.findById(workoutVO.getWorkoutId());
		if (workoutCollection.isPresent()) {
			Optional<WorkoutCategory> workoutCategory = workoutCategoryRepository.findById(workoutVO.getCategoryId());
			if (workoutCategory.isPresent()) {
				workoutCollection.get().setWorkoutCategory(workoutCategory.get());
				workoutCollection.get().setWorkoutTitle(workoutVO.getWorkoutTitle());
				workoutCollection.get().setWorkoutNote(workoutVO.getWorkoutNote());
				workoutCollection.get().setCaloriesBurnPerMin(workoutVO.getCaloriesBurnPerMin());
				workoutCollectionRepository.save(workoutCollection.get());
				return "success";
			}
		}
		return "failure";
	}

	@Override
	public List<WorkoutVO> deleteWorkout(String workoutId) {
		workoutCollectionRepository.deleteById(Integer.parseInt(workoutId));
		return getAllWorkouts();
	}

	@Override
	public String setActiveWorkout(WorkoutVO workoutVO) {
		WorkoutActive workoutActive = mapWorkoutActive(workoutVO);
		if (null != workoutActive) {
			workoutActiveRepository.save(workoutActive);
			return "success";
		}
		return "failure";
	}

	private WorkoutActive mapWorkoutActive(WorkoutVO workoutVO) {
		WorkoutActive workoutActive = null;
		if (null != workoutVO) {
			Optional<WorkoutCollection> workoutCollection = workoutCollectionRepository
					.findById(workoutVO.getWorkoutId());
			if (workoutCollection.isPresent()) {
				workoutActive = new WorkoutActive();
				workoutActive.setWorkoutCollection(workoutCollection.get());
				workoutActive.setComment(workoutVO.getComment());
				DateFormat formatter = new SimpleDateFormat("HH:mm");
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					workoutActive.setEndDate(dateFormatter.parse(workoutVO.getEndDate()));
					workoutActive.setStartDate(dateFormatter.parse(workoutVO.getStartDate()));
					workoutActive.setEndTime(new Time(formatter.parse(workoutVO.getEndTime()).getTime()));
					workoutActive.setStartTime(new Time(formatter.parse(workoutVO.getStartTime()).getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				workoutActive.setStatus(true);
			}
		}
		return workoutActive;
	}

	@Override
	public List<WorkoutVO> getActiveWorkouts() {
		List<WorkoutVO> workoutList = new ArrayList<>();
		List<WorkoutActive> workoutActives = (List<WorkoutActive>) workoutActiveRepository.findAll();
		for (WorkoutActive workoutActive : workoutActives) {
			WorkoutVO workoutVO = new WorkoutVO();
			workoutVO.setWorkoutId(workoutActive.getWorkoutId());
			workoutVO.setWorkoutTitle(workoutActive.getWorkoutCollection().getWorkoutTitle());
			workoutVO.setCaloriesBurnPerMin(workoutActive.getWorkoutCollection().getCaloriesBurnPerMin());
			workoutVO.setCategoryId(workoutActive.getWorkoutCollection().getCategoryId());
			DateFormat formatter = new SimpleDateFormat("HH:mm");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			workoutVO.setStartDate(dateFormatter.format(workoutActive.getStartDate()));
			workoutVO.setEndDate(dateFormatter.format(workoutActive.getEndDate()));
			workoutVO.setStartTime(formatter.format(workoutActive.getStartTime()));
			workoutVO.setEndTime(formatter.format(workoutActive.getEndTime()));
			workoutList.add(workoutVO);
		}
		return workoutList;
	}

	@Override
	public List<CategoryVO> viewAllCategory() {
		List<CategoryVO> categoryVOList = new ArrayList<>();
		List<WorkoutCategory> categoryList = (List<WorkoutCategory>) workoutCategoryRepository.findAll();
		for (WorkoutCategory workoutCategory : categoryList) {
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setCategoryId(workoutCategory.getCategoryId());
			categoryVO.setCategoryName(workoutCategory.getCategoryName());
			categoryVOList.add(categoryVO);
		}
		return categoryVOList;
	}

	@Override
	public List<CategoryVO> addCategory(CategoryVO categoryVO) {
		WorkoutCategory workoutCategory = mapWorkoutCategory(categoryVO);
		if (null != workoutCategory) {
			workoutCategoryRepository.save(workoutCategory);
		}
		return viewAllCategory();
	}

	private WorkoutCategory mapWorkoutCategory(CategoryVO categoryVO) {
		WorkoutCategory workoutCategory = new WorkoutCategory();
		workoutCategory.setCategoryName(categoryVO.getCategoryName());
		return workoutCategory;
	}

	@Override
	public List<CategoryVO> editCategory(CategoryVO categoryVO) {
		Optional<WorkoutCategory> workoutCategory = workoutCategoryRepository.findById(categoryVO.getCategoryId());
		if (workoutCategory.isPresent()) {
			workoutCategory.get().setCategoryName(categoryVO.getCategoryName());
			workoutCategoryRepository.save(workoutCategory.get());
		}
		return viewAllCategory();
	}

	@Override
	public List<CategoryVO> deleteCategory(String categoryid) {
		try {
			workoutCategoryRepository.deleteById(Integer.parseInt(categoryid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewAllCategory();
	}

}
