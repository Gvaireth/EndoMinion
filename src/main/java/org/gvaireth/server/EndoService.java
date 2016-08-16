package org.gvaireth.server;

import java.util.List;

import org.gvaireth.model.AccountInfoData;
import org.gvaireth.model.DetailedWorkoutData;
import org.gvaireth.model.PrefetchDataStatus;
import org.gvaireth.model.StatisticsData;
import org.gvaireth.model.WorkoutData;

import com.moomeen.endo2java.model.Sport;

public interface EndoService {

	List<WorkoutData> getWorkouts();

	DetailedWorkoutData getWorkoutDetails(long endomondoId);

	List<WorkoutData> fetchWorkouts();

	StatisticsData getStatistics();

	AccountInfoData getAccountInfo();

	PrefetchDataStatus prefetchData();

	List<String> getSports();

}
