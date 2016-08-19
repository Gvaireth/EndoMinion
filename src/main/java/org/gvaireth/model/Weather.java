package org.gvaireth.model;

/*
 * based on : https://apidev.accuweather.com/developers/weatherIcons
 */
public enum Weather {
	SUNNY(1, "Sunny"),

	MOSTLY_SUNNY(2, "Mostly Sunny"),

	PARTLY_SUNNY(3, "Partly Sunny");

	private int number;

	private String description;

	public int getNumber() {
		return number;
	}

	public String getDescription() {
		return description;
	}

	private Weather(int number, String description) {
		this.number = number;
		this.description = description;
	}

}
