package org.gvaireth.server;

import java.util.List;

import org.gvaireth.model.DetailedWorkoutData;
import org.gvaireth.model.StatisticsData;
import org.gvaireth.model.WorkoutCrudData;

public interface EndoService {

	List<WorkoutCrudData> getWorkouts();

	DetailedWorkoutData getWorkoutDetails(long endomondoId);

	List<WorkoutCrudData> fetchWorkouts();

	StatisticsData getStatistics();

}
