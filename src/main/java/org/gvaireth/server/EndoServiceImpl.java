package org.gvaireth.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.gvaireth.model.DetailedWorkoutData;
import org.gvaireth.model.StatisticsData;
import org.gvaireth.model.WorkoutCrudData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.moomeen.endo2java.model.DetailedWorkout;
import com.moomeen.endo2java.model.Workout;

@Service("endoservice")
public class EndoServiceImpl implements EndoService, ServletContextAware {

	@Autowired
	private EndomondoDao endomondoDao;

	@Autowired
	private WorkoutConverter workoutConverter;

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

	public List<Workout> getRawWorkouts() {
		List<Workout> rawWorkouts = new EndomondoDaoImpl().getWorkouts();
		return rawWorkouts;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		System.out.println("setting context");
		this.servletContext = servletContext;
		System.out.println(servletContext);

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

	// public AccountInfo getAccountInfo() {
	// if (accountInfo == null) {
	// EndomondoSession session = new EndomondoSession(EMAIL, PASSWORD);
	// try {
	// session.login();
	// accountInfo = session.getAccountInfo();
	// } catch (InvocationException e) {
	// System.out.println("well");
	// }
	// }
	// return accountInfo;
	// }

}
