package org.gvaireth.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.gvaireth.core.SessionAttributes;
import org.gvaireth.core.Util;
import org.gvaireth.model.DetailedWorkoutData;
import org.gvaireth.model.Statistics;
import org.gvaireth.model.WorkoutCrudData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.moomeen.endo2java.EndomondoSession;
import com.moomeen.endo2java.error.InvocationException;
import com.moomeen.endo2java.model.DetailedWorkout;
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
	public void updateData() {
		cache.updateData();
	}

	@Override
	public Statistics getStatistics() {
		return statisticsCalculaor.getStatistics(getWorkouts());
	}

	@Override
	public DetailedWorkoutData getWorkoutDetails(long endomondoId) {
		// endomondoId = 780349296;
		HttpSession httpSession = Util.session();
		EndomondoSession endomondoSession = (EndomondoSession) httpSession
				.getAttribute(SessionAttributes.ENDOMONDO_SESSION.getName());
		DetailedWorkout rawDetailedWorkout = null;
		try {
			rawDetailedWorkout = endomondoSession.getWorkout(endomondoId);
		} catch (InvocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
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
