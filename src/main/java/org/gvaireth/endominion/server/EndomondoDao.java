package org.gvaireth.endominion.server;

import java.util.List;

import com.moomeen.endo2java.model.AccountInfo;
import com.moomeen.endo2java.model.DetailedWorkout;
import com.moomeen.endo2java.model.Workout;

public interface EndomondoDao {

	List<Workout> getWorkouts();

	DetailedWorkout getWorkoutDetails(long endomondoId);

	void setWorkouts(List<Workout> workouts);

	void fetchWorkouts();

	AccountInfo getAccountInfo();

}