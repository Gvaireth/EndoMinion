package org.gvaireth.endominion.model;

public class PrefetchDataStatus {
	private long workoutsFetched;
	private long fetchTime;

	public long getWorkoutsFetched() {
		return workoutsFetched;
	}

	public void setWorkoutsFetched(long workoutsFetched) {
		this.workoutsFetched = workoutsFetched;
	}

	public long getFetchTime() {
		return fetchTime;
	}

	public void setFetchTime(long fetchTime) {
		this.fetchTime = fetchTime;
	}
}
