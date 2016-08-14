package org.gvaireth.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.gvaireth.model.AccountInfoData;
import org.gvaireth.model.DetailedWorkoutData;
import org.gvaireth.model.StatisticsData;
import org.gvaireth.model.WorkoutCrudData;
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
		// TODO Auto-generated constructor stub
	}

	public List<WorkoutCrudData> getWorkouts() {
		List<Workout> rawWorkouts = endomondoDao.getWorkouts();
		List<WorkoutCrudData> convertedList = new ArrayList<WorkoutCrudData>(rawWorkouts.size());
		long id = rawWorkouts.size();
		for (Workout rawWorkout : rawWorkouts) {
			if (rawWorkout != null) {
				WorkoutCrudData converted = workoutConverter.convertWorkout(rawWorkout);
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
	public List<WorkoutCrudData> fetchWorkouts() {
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
		System.out.println(converted);
		return converted;
	}

	@Override
	public AccountInfoData getAccountInfo() {
		AccountInfo accountInfoRaw = endomondoDao.getAccountInfo();
		return workoutConverter.convertAccountInfo(accountInfoRaw);
	}

}
