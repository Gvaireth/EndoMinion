package org.gvaireth.server;

import java.util.List;

import com.moomeen.endo2java.model.Workout;

public interface EndomondoDao {

	List<Workout> getWorkouts();

	void setWorkouts(List<Workout> workouts);

	public void updateData();

	String test();

}