package org.gvaireth.server;

import java.util.ArrayList;

import org.gvaireth.model.DetailedWorkoutData;
import org.gvaireth.model.PointData;
import org.gvaireth.model.WorkoutCrudData;
import org.springframework.stereotype.Component;

import com.moomeen.endo2java.model.DetailedWorkout;
import com.moomeen.endo2java.model.Point;
import com.moomeen.endo2java.model.Workout;

@Component
public class WorkoutConverter {
	public WorkoutCrudData convertWorkout(Workout rawWorkout) {
		WorkoutCrudData crudData = new WorkoutCrudData();
		if (rawWorkout.getDistance() != null) {
			double dist = trimDouble(rawWorkout.getDistance());
			crudData.setDistance(dist);
		}
		if (rawWorkout.getStartTime() != null) {
			crudData.setStartTime(rawWorkout.getStartTime().toDate());
		}
		if (rawWorkout.getDuration() != null) {
			crudData.setDuration(rawWorkout.getDuration().getMillis());
		}
		if (rawWorkout.getSpeedAvg() != null) {
			crudData.setSpeedAvg(trimDouble(rawWorkout.getSpeedAvg()));
		}
		crudData.setEndomondoId(rawWorkout.getId());
		crudData.setSportEnum(rawWorkout.getSport());
		crudData.setCalories((long) (double) rawWorkout.getCalories());
		return crudData;
	}

	public DetailedWorkoutData convertDetailedWorkout(DetailedWorkout rawDetailedWorkout) {
		DetailedWorkoutData converted = new DetailedWorkoutData();
		converted.setFeedStory(rawDetailedWorkout.getFeedStory());
		converted.setWeatherType(rawDetailedWorkout.getWeatherType());
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

	public double trimDouble(double dist) {
		dist *= 100;
		dist = (double) (int) dist;
		dist /= 100;
		return dist;
	}
}
