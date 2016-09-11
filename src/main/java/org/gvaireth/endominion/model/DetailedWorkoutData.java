package org.gvaireth.endominion.model;

import java.io.Serializable;
import java.util.List;

public class DetailedWorkoutData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Weather weatherType;
	private String feedStory;
	private List<PointData> points;
	private WorkoutData basicWorkoutData;

	public Weather getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(Weather weatherType) {
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

	public WorkoutData getBasicWorkoutData() {
		return basicWorkoutData;
	}

	public void setBasicWorkoutData(WorkoutData basicWorkoutData) {
		this.basicWorkoutData = basicWorkoutData;
	}

	public String getWeatherDescription() {
		return weatherType.getDescription();
	}

}
