package org.gvaireth.endominion.server;

import java.util.List;

import org.gvaireth.endominion.model.AccountInfoData;
import org.gvaireth.endominion.model.DetailedWorkoutData;
import org.gvaireth.endominion.model.PrefetchDataStatus;
import org.gvaireth.endominion.model.StatisticsData;
import org.gvaireth.endominion.model.WorkoutData;

public interface EndoService {

	List<WorkoutData> getWorkouts();

	DetailedWorkoutData getWorkoutDetails(long endomondoId);

	List<WorkoutData> fetchWorkouts();

	StatisticsData getStatistics();

	AccountInfoData getAccountInfo();

	PrefetchDataStatus prefetchData();

	List<String> getSports();

}
