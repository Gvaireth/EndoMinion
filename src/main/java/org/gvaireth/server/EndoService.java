package org.gvaireth.server;

import java.util.List;

import org.gvaireth.model.Statistics;
import org.gvaireth.model.WorkoutCrudData;

public interface EndoService {

	List<WorkoutCrudData> getWorkouts();

	void updateData();

	Statistics getStatistics();

}
