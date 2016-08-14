package org.gvaireth.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.gvaireth.model.AccountInfoData;
import org.gvaireth.model.DetailedWorkoutData;
import org.gvaireth.model.StatisticsData;
import org.gvaireth.model.WorkoutData;
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
		Workout basicWorkoutData = rawDetailedWorkout;
		WorkoutData convertedBasicData = workoutConverter.convertWorkout(basicWorkoutData);
		converted.setBasicWorkoutData(convertedBasicData);
		return converted;
	}

	@Override
	public AccountInfoData getAccountInfo() {
		AccountInfo accountInfoRaw = endomondoDao.getAccountInfo();
		return workoutConverter.convertAccountInfo(accountInfoRaw);
	}

}
