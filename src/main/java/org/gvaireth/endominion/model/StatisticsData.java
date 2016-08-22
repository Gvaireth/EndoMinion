package org.gvaireth.endominion.model;

import java.util.List;

public class StatisticsData {
	private WorkoutTotalData total;
	private List<WorkoutTotalData> totalPerSport;
	private List<WorkoutData> topDuration;
	private List<WorkoutData> topDistance;
	private List<WorkoutData> topSpeedAvg;

	public List<WorkoutData> getTopSpeedAvg() {
		return topSpeedAvg;
	}

	public void setTopSpeedAvg(List<WorkoutData> topSpeedAvg) {
		this.topSpeedAvg = topSpeedAvg;
	}

	public List<WorkoutData> getTopDistance() {
		return topDistance;
	}

	public void setTopDistance(List<WorkoutData> topDistance) {
		this.topDistance = topDistance;
	}

	public WorkoutTotalData getTotal() {
		return total;
	}

	public void setTotal(WorkoutTotalData total) {
		this.total = total;
	}

	public List<WorkoutTotalData> getTotalPerSport() {
		return totalPerSport;
	}

	public void setTotalPerSport(List<WorkoutTotalData> totalPerSport) {
		this.totalPerSport = totalPerSport;
	}

	@Override
	public String toString() {
		return "Statistics [total=" + total + ", totalPerSport=" + totalPerSport + "]";
	}

	public List<WorkoutData> getTopDuration() {
		return topDuration;
	}

	public void setTopDuration(List<WorkoutData> longest) {
		this.topDuration = longest;
	}

}
