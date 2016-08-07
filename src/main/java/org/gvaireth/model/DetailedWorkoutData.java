package org.gvaireth.model;

import java.io.Serializable;
import java.util.List;

public class DetailedWorkoutData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer weatherType;
	private String feedStory;
	private List<PointData> points;

	public Integer getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(Integer weatherType) {
		this.weatherType = weatherType;
	}

	public String getFeedStory() {
		return feedStory;
	}

	public void setFeedStory(String feedStory) {
		this.feedStory = feedStory;
	}

	public List<PointData> getPoints() {
		return points;
	}

	public void setPoints(List<PointData> points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "DetailedWorkoutData [weatherType=" + weatherType + ", feedStory=" + feedStory + ", points=" + points
				+ "]";
	}

}
