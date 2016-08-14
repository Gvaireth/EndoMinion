package org.gvaireth.server;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.gvaireth.core.SessionAttributes;
import org.gvaireth.core.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.moomeen.endo2java.EndomondoSession;
import com.moomeen.endo2java.error.InvocationException;
import com.moomeen.endo2java.error.LoginException;
import com.moomeen.endo2java.model.AccountInfo;
import com.moomeen.endo2java.model.DetailedWorkout;
import com.moomeen.endo2java.model.Workout;

@Component("cache")
public class EndomondoDaoImpl implements EndomondoDao {

	private List<Workout> workouts;
	private AccountInfo accountInfo;

	@Value("${endo.email}")
	private String endoEmail;

	@Value("${endo.pass}")
	private String endoPass;

	public EndomondoDaoImpl() {
	}

	@Override
	public List<Workout> getWorkouts() {
		if (workouts == null) {
			fetchWorkouts();
		} else {
			System.out.println("retriveing cached data");
		}
		return workouts;
	}

	public void fetchWorkouts() {

		System.out.println("fetching workouts for " + endoEmail);
		EndomondoSession endomondoSession;
		try {
			endomondoSession = getEndomondoSession();
			endomondoSession.login();
			workouts = endomondoSession.getWorkouts(1000);
		} catch (InvocationException e) {
			System.out.println("fetchWorkouts fuckup " + e);
		}
	}

	public EndomondoSession getEndomondoSession() throws LoginException {
		HttpSession httpSession = Util.session();
		EndomondoSession endomondoSession = (EndomondoSession) httpSession
				.getAttribute(SessionAttributes.ENDOMONDO_SESSION.getName());
		if (endomondoSession == null) {
			endomondoSession = new EndomondoSession(endoEmail, endoPass);
			endomondoSession.login();
			httpSession.setAttribute(SessionAttributes.ENDOMONDO_SESSION.getName(), endomondoSession);
		}
		return endomondoSession;
	}

	@Override
	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	@Override
	public DetailedWorkout getWorkoutDetails(long endomondoId) {
		DetailedWorkout rawDetailedWorkout = null;
		try {
			EndomondoSession endomondoSession = getEndomondoSession();
			rawDetailedWorkout = endomondoSession.getWorkout(endomondoId);
		} catch (InvocationException e) {
			e.printStackTrace();
		}
		return rawDetailedWorkout;
	}

	public AccountInfo getAccountInfo() {
		if (accountInfo == null) {
			EndomondoSession session;
			try {
				session = getEndomondoSession();
				accountInfo = session.getAccountInfo();
			} catch (InvocationException e) {
				System.out.println("getAccountInfo fuckup " + e);
			}

		}
		return accountInfo;
	}
}
