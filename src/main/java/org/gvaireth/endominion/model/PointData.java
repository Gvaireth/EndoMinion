package org.gvaireth.endominion.model;

import java.io.Serializable;

import org.joda.time.DateTime;

import com.moomeen.endo2java.model.PointInstruction;

public class PointData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DateTime time;
	private Double speed;
	private Double distance;
	private Double altitude;
	private Double longitude;
	private Double latitude;
	private PointInstruction instruction;

	public DateTime getTime() {
		return time;
	}

	public void setTime(DateTime time) {
		this.time = time;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public PointInstruction getInstruction() {
		return instruction;
	}

	public void setInstruction(PointInstruction instruction) {
		this.instruction = instruction;
	}

	@Override
	public String toString() {
		return "PointData [time=" + time + ", speed=" + speed + ", distance=" + distance + ", altitude=" + altitude
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", instruction=" + instruction + "]";
	}

}
