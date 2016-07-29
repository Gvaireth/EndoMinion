package org.gvaireth.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.gvaireth.model.Statistics;
import org.gvaireth.model.WorkoutCrudData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.moomeen.endo2java.model.Workout;

@Service("endoservice")
public class EndoServiceImpl implements EndoService, ServletContextAware {

	@Autowired
	private EndomondoDao cache;

	@Autowired
	private WorkoutConverter workoutConverter;

	@Autowired
	private StatisticsCalculator statisticsCalculaor;

	ServletContext servletContext;

	public EndoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<WorkoutCrudData> getWorkouts() {
		List<Workout> rawWorkouts = cache.getWorkouts();
		List<WorkoutCrudData> converted = new ArrayList<WorkoutCrudData>(rawWorkouts.size());
		for (Workout rawWorkout : rawWorkouts) {
			if (rawWorkout != null) {
				converted.add(workoutConverter.convert(rawWorkout));
			} else {
				System.out.println("null workout");
			}
		}
		statisticsCalculaor.calculateRanks(converted);
		return converted;
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
	public void updateData() {
		cache.updateData();
	}

	@Override
	public Statistics getStatistics() {
		return statisticsCalculaor.getStatistics(getWorkouts());
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
