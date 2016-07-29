package org.gvaireth.server;

import org.gvaireth.model.WorkoutCrudData;
import org.springframework.stereotype.Component;

import com.moomeen.endo2java.model.Workout;

@Component
public class WorkoutConverter {
	public WorkoutCrudData convert(Workout rawWorkout) {
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

		crudData.setSportEnum(rawWorkout.getSport());
		crudData.setCalories((long) (double) rawWorkout.getCalories());
		return crudData;
	}

	public double trimDouble(double dist) {
		dist *= 100;
		dist = (double) (int) dist;
		dist /= 100;
		return dist;
	}
}
