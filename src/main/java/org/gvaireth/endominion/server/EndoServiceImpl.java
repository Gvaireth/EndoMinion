package org.gvaireth.endominion.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.gvaireth.endominion.model.AccountInfoData;
import org.gvaireth.endominion.model.DetailedWorkoutData;
import org.gvaireth.endominion.model.PrefetchDataStatus;
import org.gvaireth.endominion.model.Sport;
import org.gvaireth.endominion.model.StatisticsData;
import org.gvaireth.endominion.model.WorkoutData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moomeen.endo2java.model.AccountInfo;
import com.moomeen.endo2java.model.DetailedWorkout;
import com.moomeen.endo2java.model.Workout;

@Service("endoservice")
public class EndoServiceImpl implements EndoService {

	@Autowired
	private EndomondoDao endomondoDao;

	@Autowired
	private Converter workoutConverter;

	@Autowired
	private StatisticsCalculator statisticsCalculaor;

	ServletContext servletContext;

	public EndoServiceImpl() {
	}

	public List<WorkoutData> getWorkouts() {
		List<Workout> rawWorkouts = endomondoDao.getWorkouts();
		List<WorkoutData> convertedList = new ArrayList<WorkoutData>(rawWorkouts.size());
		long id = rawWorkouts.size();
		for (Workout rawWorkout : rawWorkouts) {
			if (rawWorkout != null) {
				WorkoutData converted = workoutConverter.convertWorkout(rawWorkout);
				converted.setId(id--);
				convertedList.add(converted);
			} else {
				System.out.println("null workout");
			}
		}
		statisticsCalculaor.calculateRanks(convertedList);
		return convertedList;
	}

	@Override
	public List<WorkoutData> fetchWorkouts() {
		endomondoDao.fetchWorkouts();
		return getWorkouts();
	}

	@Override
	public StatisticsData getStatistics() {
		return statisticsCalculaor.getStatistics(getWorkouts());
	}

	@Override
	public DetailedWorkoutData getWorkoutDetails(long endomondoId) {
		DetailedWorkout rawDetailedWorkout = endomondoDao.getWorkoutDetails(endomondoId);
		DetailedWorkoutData converted = workoutConverter.convertDetailedWorkout(rawDetailedWorkout);
		List<WorkoutData> allWorkouts = getWorkouts();
		WorkoutData enrichedWorkout = null;
		for (WorkoutData workout : allWorkouts) {
			if (workout.getEndomondoId() == endomondoId) {
				enrichedWorkout = workout;
			}
		}
		converted.setBasicWorkoutData(enrichedWorkout);
		return converted;
	}

	@Override
	public AccountInfoData getAccountInfo() {
		AccountInfo accountInfoRaw = endomondoDao.getAccountInfo();
		return workoutConverter.convertAccountInfo(accountInfoRaw);
	}

	@Override
	public PrefetchDataStatus prefetchData() {
		PrefetchDataStatus status = new PrefetchDataStatus();
		long start = System.currentTimeMillis();
		List<WorkoutData> workouts = getWorkouts();
		status.setWorkoutsFetched(workouts.size());
		getAccountInfo();
		long end = System.currentTimeMillis();
		status.setFetchTime(end - start);
		return status;
	}

	@Override
	public List<String> getSports() {
		Set<Sport> sportsEnums = statisticsCalculaor.getSportsPresent(getWorkouts());
		List<String> sports = new ArrayList<>();
		for (Sport sportEnum : sportsEnums) {
			sports.add(sportEnum.description());
		}
		Collections.sort(sports);
		sports.add(0, Sport.ALL.description());
		return sports;
	}

}
