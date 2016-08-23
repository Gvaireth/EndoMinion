package org.gvaireth.endominion.server;

import java.util.ArrayList;

import org.gvaireth.endominion.model.AccountInfoData;
import org.gvaireth.endominion.model.DetailedWorkoutData;
import org.gvaireth.endominion.model.PointData;
import org.gvaireth.endominion.model.Sport;
import org.gvaireth.endominion.model.Weather;
import org.gvaireth.endominion.model.WorkoutData;
import org.springframework.stereotype.Component;

import com.moomeen.endo2java.model.AccountInfo;
import com.moomeen.endo2java.model.DetailedWorkout;
import com.moomeen.endo2java.model.Point;

import com.moomeen.endo2java.model.Workout;

@Component
public class Converter {
	public WorkoutData convertWorkout(Workout rawWorkout) {
		WorkoutData crudData = new WorkoutData();
		Double distance = rawWorkout.getDistance();
		if (distance != null) {
			distance = trimDouble(distance);
		}
		crudData.setDistance(distance);
		if (rawWorkout.getStartTime() != null) {
			crudData.setStartTime(rawWorkout.getStartTime().toDate());
		}
		if (rawWorkout.getDuration() != null) {
			crudData.setDuration(rawWorkout.getDuration().getMillis());
		}
		Double speedAvg = rawWorkout.getSpeedAvg();
		if (speedAvg != null) {
			speedAvg = trimDouble(speedAvg);
		}
		crudData.setSpeedAvg(speedAvg);
		crudData.setEndomondoId(rawWorkout.getId());
		Sport sport = Sport.fromNumber(rawWorkout.getSport().getNumber());
		crudData.setSportEnum(sport);
		crudData.setCalories((long) (double) rawWorkout.getCalories());
		return crudData;
	}

	public DetailedWorkoutData convertDetailedWorkout(DetailedWorkout rawDetailedWorkout) {
		DetailedWorkoutData converted = new DetailedWorkoutData();
		String feedStory = rawDetailedWorkout.getFeedStory();
		feedStory = feedStory.replace("<0>", "").replace("</0>", "");
		converted.setFeedStory(feedStory);
		converted.setWeatherType(Weather.fromNumber(rawDetailedWorkout.getWeatherType()));
		converted.setPoints(new ArrayList<>());
		if (rawDetailedWorkout.getPoints() != null) {
			for (Point rawPoint : rawDetailedWorkout.getPoints()) {
				converted.getPoints().add(convertPoint(rawPoint));
			}
		}
		return converted;
	}

	private PointData convertPoint(Point rawPoint) {
		PointData converted = new PointData();
		converted.setAltitude(rawPoint.getAltitude());
		converted.setDistance(rawPoint.getDistance());
		converted.setInstruction(rawPoint.getInstruction());
		converted.setLatitude(rawPoint.getLatitude());
		converted.setLongitude(rawPoint.getLongitude());
		converted.setSpeed(rawPoint.getSpeed());
		converted.setTime(rawPoint.getTime());
		return converted;
	}

	public AccountInfoData convertAccountInfo(AccountInfo rawInfo) {
		AccountInfoData converted = new AccountInfoData();
		converted.setWeight(rawInfo.getWeight());
		converted.setPhone(rawInfo.getPhone());
		converted.setSex(rawInfo.getSex());
		converted.setSyncTime(rawInfo.getSyncTime());
		converted.setDateOfBirth(rawInfo.getDateOfBirth());
		converted.setLoungeMember(rawInfo.getLoungeMember());
		converted.setFavoriteSportEnum(rawInfo.getFavoriteSport());
		converted.setFavoriteSport2Enum(rawInfo.getFavoriteSport2());
		converted.setUnits(rawInfo.getUnits());
		converted.setCountry(rawInfo.getCountry());
		converted.setId(rawInfo.getId());
		converted.setFirstName(rawInfo.getFirstName());
		converted.setLastName(rawInfo.getLastName());
		converted.setPictureId(rawInfo.getPictureId());
		converted.setWeightTime(rawInfo.getWeightTime());
		converted.setHeight(rawInfo.getHeight());
		converted.setCreatedTime(rawInfo.getCreatedTime());
		converted.setTimeZone(rawInfo.getTimeZone());
		return converted;
	}

	public double trimDouble(double dist) {
		dist *= 100;
		dist = (double) (int) dist;
		dist /= 100;
		return dist;
	}
}
