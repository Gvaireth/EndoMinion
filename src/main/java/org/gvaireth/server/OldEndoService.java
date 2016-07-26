package org.gvaireth.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moomeen.endo2java.model.Workout;

@Service("oldendoservice")
public class OldEndoService {

	@Autowired
	private EndomondoDao cache;

	public List<Workout> getRawWorkouts() {
		List<Workout> rawWorkouts = cache.getWorkouts();
		return rawWorkouts;
	}

	public String testCache() {
		// return "foo";
		return cache.test();
	}

}
