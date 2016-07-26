package org.gvaireth.model;

import org.gvaireth.core.Util;

import com.moomeen.endo2java.model.Sport;

public class WorkoutTotalCrudData implements Comparable<WorkoutTotalCrudData> {
	private Integer workoutsNo;
	private Long duration;
	private Double distance;
	private Long calories;
	private Sport sportEnum;

	public Sport getSportEnum() {
		return sportEnum;
	}

	public void setSportEnum(Sport sportEnum) {
		this.sportEnum = sportEnum;
	}

	public Integer getWorkoutsNo() {
		return workoutsNo;
	}

	public void setWorkoutsNo(Integer workouts) {
		this.workoutsNo = workouts;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Long getCalories() {
		return calories;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
	}

	public String getSport() {
		return sportEnum.description();
	}

	public void setSport(String sport) {
	}

	public String getReadableDuration() {
		return Util.formatDuration(duration);
	}

	@Override
	public String toString() {
		return "WorkoutTotalCrudData [workoutsNo=" + workoutsNo + ", duration=" + duration + ", distance=" + distance
				+ ", calories=" + calories + ", sportEnum=" + sportEnum + "]";
	}

	@Override
	public int compareTo(WorkoutTotalCrudData o) {
		return workoutsNo - o.workoutsNo;
	}

}
