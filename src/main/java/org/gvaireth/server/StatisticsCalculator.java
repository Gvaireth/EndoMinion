package org.gvaireth.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.gvaireth.model.StatisticsData;
import org.gvaireth.model.WorkoutData;
import org.gvaireth.model.WorkoutTotalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moomeen.endo2java.model.Sport;

@Component
public class StatisticsCalculator {

	@Autowired
	private Converter workoutConverter;

	Comparator<WorkoutData> distanceComparator = (WorkoutData w1, WorkoutData w2) -> {
		if (w1.getDistance() != null && w2.getDistance() != null) {
			return w1.getDistance().compareTo(w2.getDistance());
		} else if (w1.getDistance() == null) {
			return -1;
		} else if (w2.getDistance() == null) {
			return 1;
		} else {
			return 0;
		}
	};

	Comparator<WorkoutData> durationComparator = (WorkoutData w1, WorkoutData w2) -> {
		if (w1.getDuration() != null && w2.getDuration() != null) {
			return w1.getDuration().compareTo(w2.getDuration());
		} else if (w1.getDuration() == null) {
			return -1;
		} else if (w2.getDuration() == null) {
			return 1;
		} else {
			return 0;
		}
	};

	Comparator<WorkoutData> speedAvgComparator = (WorkoutData w1, WorkoutData w2) -> {
		if (w1.getSpeedAvg() != null && w2.getSpeedAvg() != null) {
			return w1.getSpeedAvg().compareTo(w2.getSpeedAvg());
		} else if (w1.getSpeedAvg() == null) {
			return -1;
		} else if (w2.getSpeedAvg() == null) {
			return 1;
		} else {
			return 0;
		}
	};

	public StatisticsData getStatistics(List<WorkoutData> workouts) {
		StatisticsData statistics = new StatisticsData();
		Set<Sport> sportsPresent = getSportsPresent(workouts);
		setTotal(workouts, statistics, sportsPresent);
		setTopDuration(workouts, statistics);
		setTopDistance(workouts, statistics);
		setTopSpeedAvg(workouts, statistics);
		return statistics;
	}

	private void setTopDistance(List<WorkoutData> workouts, StatisticsData statistics) {
		List<WorkoutData> topDistance = generateTopDistance(workouts);
		Collections.sort(topDistance, distanceComparator);
		Collections.reverse(topDistance);
		statistics.setTopDistance(topDistance);
	}

	private void setTopDuration(List<WorkoutData> workouts, StatisticsData statistics) {
		List<WorkoutData> topDuration = generateTopDuration(workouts);
		Collections.sort(topDuration, durationComparator);
		Collections.reverse(topDuration);
		statistics.setTopDuration(topDuration);
	}

	private void setTopSpeedAvg(List<WorkoutData> workouts, StatisticsData statistics) {
		List<WorkoutData> topSpeedAvg = generateTopSpeedAvg(workouts);
		Collections.sort(topSpeedAvg, speedAvgComparator);
		Collections.reverse(topSpeedAvg);
		statistics.setTopSpeedAvg(topSpeedAvg);
	}

	private void setTotal(List<WorkoutData> workouts, StatisticsData statistics, Set<Sport> sportsPresent) {
		statistics.setTotal(getTotal(workouts, Sport.ALL));
		List<WorkoutTotalData> totalPerSport = new ArrayList<>();
		for (Sport sport : sportsPresent) {
			totalPerSport.add(getTotal(workouts, sport));
		}
		Collections.sort(totalPerSport);
		Collections.reverse(totalPerSport);
		statistics.setTotalPerSport(totalPerSport);
	}

	public Set<Sport> getSportsPresent(List<WorkoutData> workouts) {
		Set<Sport> sportsPresent = new HashSet<>();
		for (WorkoutData workout : workouts) {
			sportsPresent.add(workout.getSportEnum());
		}
		return sportsPresent;
	}

	private List<WorkoutData> generateTopDuration(List<WorkoutData> workouts) {
		Map<Sport, WorkoutData> perSportMax = new HashMap<>();
		for (WorkoutData workout : workouts) {
			if (workout.getDurationRank() != null && workout.getDurationRank() == 1) {
				perSportMax.put(workout.getSportEnum(), workout);
			}
		}
		return new ArrayList<>(perSportMax.values());
	}

	private List<WorkoutData> generateTopDistance(List<WorkoutData> workouts) {
		Map<Sport, WorkoutData> perSportMax = new HashMap<>();
		for (WorkoutData workout : workouts) {
			if (workout.getDistanceRank() != null && workout.getDistanceRank() == 1) {
				perSportMax.put(workout.getSportEnum(), workout);
			}
		}
		return new ArrayList<>(perSportMax.values());
	}

	private List<WorkoutData> generateTopSpeedAvg(List<WorkoutData> workouts) {
		Map<Sport, WorkoutData> perSportMax = new HashMap<>();
		for (WorkoutData workout : workouts) {
			if (workout.getSpeedAvgRank() != null && workout.getSpeedAvgRank() == 1) {
				perSportMax.put(workout.getSportEnum(), workout);
			}
		}
		return new ArrayList<>(perSportMax.values());
	}

	public void calculateRanks(List<WorkoutData> workouts) {

		Map<Sport, List<WorkoutData>> workoutsBySport = new HashMap<>();
		Set<Sport> sportsPresent = getSportsPresent(workouts);
		for (Sport sport : sportsPresent) {
			workoutsBySport.put(sport, new ArrayList<>());
		}
		for (WorkoutData workout : workouts) {
			workoutsBySport.get(workout.getSportEnum()).add(workout);
		}
		for (Sport sport : workoutsBySport.keySet()) {
			List<WorkoutData> currentWorkouts = workoutsBySport.get(sport);
			calculateDistanceRank(currentWorkouts);
			calculateDurationRank(currentWorkouts);
			calculateSpeedAvgRank(currentWorkouts);
		}
		return;

	}

	private void calculateDistanceRank(List<WorkoutData> currentWorkouts) {
		Collections.sort(currentWorkouts, distanceComparator);
		Collections.reverse(currentWorkouts);
		int rank = 1;
		for (WorkoutData workout : currentWorkouts) {
			if (workout.getDistance() != null) {
				workout.setDistanceRank(rank++);
			}
		}
	}

	private void calculateDurationRank(List<WorkoutData> currentWorkouts) {
		Collections.sort(currentWorkouts, durationComparator);
		Collections.reverse(currentWorkouts);
		int rank = 1;
		for (WorkoutData workout : currentWorkouts) {
			if (workout.getDuration() != null) {
				workout.setDurationRank(rank++);
			}
		}
	}

	private void calculateSpeedAvgRank(List<WorkoutData> currentWorkouts) {
		Collections.sort(currentWorkouts, speedAvgComparator);
		Collections.reverse(currentWorkouts);
		int rank = 1;
		for (WorkoutData workout : currentWorkouts) {
			if (workout.getSpeedAvg() != null) {
				workout.setSpeedAvgRank(rank++);
			}
		}
	}

	private WorkoutTotalData getTotal(List<WorkoutData> workouts, Sport sport) {
		WorkoutTotalData total = new WorkoutTotalData();
		Integer workoutsNo = 0;
		Long duration = 0l;
		Double distance = 0.0;
		Long calories = 0l;
		for (WorkoutData workout : workouts) {
			if (workout.getSportEnum() == sport || sport == Sport.ALL) {
				workoutsNo++;
				if (workout.getDuration() != null) {
					duration += workout.getDuration();
				}
				if (workout.getDistance() != null) {
					distance += workout.getDistance();
				}
				if (workout.getCalories() != null) {
					calories += workout.getCalories();
				}
			}
		}
		total.setSportEnum(sport);
		total.setWorkoutsNo(workoutsNo);
		total.setDuration(duration);
		total.setDistance(workoutConverter.trimDouble(distance));
		total.setCalories(calories);
		return total;
	}
}
