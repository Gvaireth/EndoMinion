package org.gvaireth.model;

import java.util.List;

public class Statistics {
	private WorkoutTotalCrudData total;
	private List<WorkoutTotalCrudData> totalPerSport;
	private List<WorkoutCrudData> topDuration;
	private List<WorkoutCrudData> topDistance;
	private List<WorkoutCrudData> topSpeedAvg;

	public List<WorkoutCrudData> getTopSpeedAvg() {
		return topSpeedAvg;
	}

	public void setTopSpeedAvg(List<WorkoutCrudData> topSpeedAvg) {
		this.topSpeedAvg = topSpeedAvg;
	}

	public List<WorkoutCrudData> getTopDistance() {
		return topDistance;
	}

	public void setTopDistance(List<WorkoutCrudData> topDistance) {
		this.topDistance = topDistance;
	}

	public WorkoutTotalCrudData getTotal() {
		return total;
	}

	public void setTotal(WorkoutTotalCrudData total) {
		this.total = total;
	}

	public List<WorkoutTotalCrudData> getTotalPerSport() {
		return totalPerSport;
	}

	public void setTotalPerSport(List<WorkoutTotalCrudData> totalPerSport) {
		this.totalPerSport = totalPerSport;
	}

	@Override
	public String toString() {
		return "Statistics [total=" + total + ", totalPerSport=" + totalPerSport + "]";
	}

	public List<WorkoutCrudData> getTopDuration() {
		return topDuration;
	}

	public void setTopDuration(List<WorkoutCrudData> longest) {
		this.topDuration = longest;
	}

}
