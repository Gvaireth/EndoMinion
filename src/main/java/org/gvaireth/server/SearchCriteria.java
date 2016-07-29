package org.gvaireth.server;

public class SearchCriteria {
	private Timespan timespan = Timespan.ALL;

	public Timespan getTimespan() {
		return timespan;
	}

	public void setTimespan(Timespan timespan) {
		this.timespan = timespan;
	}
}
