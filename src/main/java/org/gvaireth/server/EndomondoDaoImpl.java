package org.gvaireth.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.moomeen.endo2java.EndomondoSession;
import com.moomeen.endo2java.error.InvocationException;
import com.moomeen.endo2java.model.Workout;

@Component("cache")
public class EndomondoDaoImpl implements EndomondoDao {

	int i = 0;

	private List<Workout> workouts;

	@Value("${endo.email}")
	private String endoEmail;

	@Value("${endo.pass}")
	private String endoPass;

	public EndomondoDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Workout> getWorkouts() {
		if (workouts == null) {
			updateData();
		} else {
			System.out.println("retriveing cached data");
		}
		return workouts;
	}

	public void updateData() {

		System.out.println("fetching workouts for " + endoEmail);
		EndomondoSession session = new EndomondoSession(endoEmail, endoPass);
		try {
			session.login();
			workouts = session.getWorkouts(1000);
		} catch (InvocationException e) {
			System.out.println("well");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gvaireth.server.ICache#getWorkouts()
	 */
	// @SuppressWarnings("unchecked")
	// @Override
	// public List<Workout> getWorkouts() {
	// HttpSession httpSession = Util.session();
	// List<Workout> workouts = null;
	// if (httpSession.getAttribute("workouts") == null) {
	// System.out.println("fetching workouts");
	// EndomondoSession session = new EndomondoSession(Const.EMAIL,
	// Const.PASSWORD);
	// try {
	// session.login();
	// workouts = session.getWorkouts(1000);
	// httpSession.setAttribute("workouts", workouts);
	// } catch (InvocationException e) {
	// System.out.println("well");
	// }
	// }
	// return (List<Workout>) httpSession.getAttribute("workouts");
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gvaireth.server.ICache#setWorkouts(java.util.List)
	 */
	@Override
	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.gvaireth.server.ICache#test()
	 */
	@Override
	public String test() {
		return "cache singleton invocation " + i++;
	}

}
