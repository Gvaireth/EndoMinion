package org.gvaireth.endominion.model;

/*
 * based on : https://apidev.accuweather.com/developers/weatherIcons
 */
public enum Weather {
	SUNNY(1, "Sunny"),

	MOSTLY_SUNNY(2, "Mostly Sunny"),

	PARTLY_SUNNY(3, "Partly Sunny"),

	INTERMITTENT_CLOUDS(4, "Intermittent Clouds"),

	HAZY_SUNSHINE(5, "Hazy Sunshine"),

	MOSTLY_CLOUDY(6, "Mostly Cloudy"),

	CLOUDY(7, "Cloudy"),

	DREARY_OVERCAST(8, "Dreary Overcast"),

	FOG(11, "Fog"),

	SHOWERS(12, "Showers"),

	MOSTLY_CLOUDY_W_SHOWERS(13, "Mostly Cloudy w Showers"),

	PARTLY_SUNNY_W_SHOWERS(14, "Partly Sunny w Showers"),

	T_STORMS(15, "T-Storms"),

	MOSTLY_CLOUDY_W_T_STORMS(16, "Mostly Cloudy w T-Storms"),

	PARTLY_SUNNY_W_T_STORMS(17, "Partly Sunny w T-Storms"),

	RAIN(18, "Rain"),

	FLURRIES(19, "Flurries"),

	MOSTLY_CLOUDY_W_FLURRIES(20, "Mostly Cloudy w Flurries"),

	PARTLY_SUNNY_W_FLURRIES(21, "Partly Sunny w Flurries"),

	SNOW(22, "Snow"),

	MOSTLY_CLOUDY_W_SNOW(23, "Mostly Cloudy w Snow"),

	ICE(24, "Ice"),

	SLEET(25, "Sleet"),

	FREEZING_RAIN(26, "Freezing Rain"),

	RAIN_AND_SNOW(29, "Rain and Snow"),

	HOT(30, "Hot"),

	COLD(31, "Cold"),

	WINDY(32, "Windy"),

	CLEAR(33, "Clear"),

	MOSTLY_CLEAR(34, "Mostly Clear"),

	PARTLY_CLOUDY(35, "Partly Cloudy"),

	INTERMITTENT_CLOUDS2(36, "Intermittent Clouds"),

	HAZY_MOONLIGHT(37, "Hazy Moonlight"),

	MOSTLY_CLOUDY2(38, "Mostly Cloudy"),

	PARTLY_CLOUDY_W_SHOWERS(39, "Partly Cloudy w Showers"),

	MOSTLY_CLOUDY_W_SHOWERS2(40, "Mostly Cloudy w Showers"),

	PARTLY_CLOUDY_W_T_STORMS2(41, "Partly Cloudy w T-Storms"),

	MOSTLY_CLOUDY_W_T_STORMS2(42, "Mostly Cloudy w T-Storms"),

	MOSTLY_CLOUDY_W_FLURRIES2(43, "Mostly Cloudy w Flurries"),

	MOSTLY_CLOUDY_W_SNOW2(44, "Mostly Cloudy w Snow"),

	UNKNOWN(999, "Unknown");

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

	public static Weather fromNumber(Integer weatherNumber) {
		for (Weather weather : Weather.values()) {
			if (weather.getNumber() == weatherNumber) {
				return weather;
			}
		}
		return UNKNOWN;
	}

}
