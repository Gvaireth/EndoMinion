package org.gvaireth.model;

import org.gvaireth.core.Util;

import org.gvaireth.model.Sport;

public class WorkoutTotalData implements Comparable<WorkoutTotalData> {
	private Integer workoutsNo;
	private Long duration;
	private Double distance;
	private Long calories;
	private Sport sportEnum = Sport.RUNNING;
	private String sport;

	public Sport getSportEnum() {
		return sportEnum;
	}

	public void setSportEnum(Sport sportEnum) {
		this.sportEnum = sportEnum;
		this.sport = sportEnum != null ? sportEnum.description() : null;
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
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
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
	public int compareTo(WorkoutTotalData o) {
		return workoutsNo - o.workoutsNo;
	}

}
