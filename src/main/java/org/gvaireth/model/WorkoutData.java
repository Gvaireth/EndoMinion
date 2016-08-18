package org.gvaireth.model;

import java.io.Serializable;
import java.util.Date;

import org.gvaireth.core.Util;

import org.gvaireth.model.Sport;

public class WorkoutData implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private long endomondoId;
	private Date startTime;
	private Long duration;
	private Double distance;
	private Long calories;
	private Sport sportEnum;
	private Double speedAvg;
	private Integer durationRank;
	private Integer distanceRank;
	private Integer speedAvgRank;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getSpeedAvgRank() {
		return speedAvgRank;
	}

	public void setSpeedAvgRank(Integer speedAvgRank) {
		this.speedAvgRank = speedAvgRank;
	}

	public Integer getDurationRank() {
		return durationRank;
	}

	public void setDurationRank(Integer durationRank) {
		this.durationRank = durationRank;
	}

	public Integer getDistanceRank() {
		return distanceRank;
	}

	public void setDistanceRank(Integer distanceRank) {
		this.distanceRank = distanceRank;
	}

	public Double getSpeedAvg() {
		return speedAvg;
	}

	public void setSpeedAvg(Double speedAvg) {
		if (speedAvg == 0) {
			this.speedAvg = null;
		} else {
			this.speedAvg = speedAvg;
		}
	}

	public Sport getSportEnum() {
		return sportEnum;
	}

	public void setSportEnum(Sport sportEnum) {
		this.sportEnum = sportEnum;
	}

	public Long getCalories() {
		return calories;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
		if (distance == 0) {
			this.distance = null;
		} else {
			this.distance = distance;
		}
	}

	public String getSport() {
		return sportEnum.description();
	}

	public void setSport(String sport) {
	}

	public String getReadableDuration() {
		return Util.formatDuration(duration);
	}

	public String getReadableStartTime() {
		return Util.formatDate(startTime);
	}

	public long getEndomondoId() {
		return endomondoId;
	}

	public void setEndomondoId(long endomondoId) {
		this.endomondoId = endomondoId;
	}

}
