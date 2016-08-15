package org.gvaireth.core;

import java.util.List;

import org.gvaireth.model.AccountInfoData;
import org.gvaireth.model.DetailedWorkoutData;
import org.gvaireth.model.PrefetchDataStatus;
import org.gvaireth.model.StatisticsData;
import org.gvaireth.model.WorkoutData;
import org.gvaireth.server.EndoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@Autowired
	private EndoService service;

	@RequestMapping("/old")
	public ModelAndView helloWorld(Model model) {
		System.out.println("front controller up");
		model.addAttribute("app", "home");
		model.addAttribute("data", service.getWorkouts());
		model.addAttribute("size", service.getWorkouts().size());
		model.addAttribute("statistics", service.getStatistics());
		model.addAttribute("totalPerSport", service.getStatistics().getTotalPerSport());
		model.addAttribute("topDuration", service.getStatistics().getTopDuration());
		model.addAttribute("topDistance", service.getStatistics().getTopDistance());
		model.addAttribute("topSpeedAvg", service.getStatistics().getTopSpeedAvg());
		return new ModelAndView("/oldviews/index.jsp");
	}

	@RequestMapping(value = "/prefetchData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrefetchDataStatus> prefetchData() {
		System.out.println("/prefetchData");
		PrefetchDataStatus status = service.prefetchData();
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/getWorkouts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WorkoutData>> getWorkouts() {
		System.out.println("/getWorkouts");
		List<WorkoutData> data = service.getWorkouts();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/getStatistics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatisticsData> getStatistics() {
		System.out.println("/getWorkouts");
		StatisticsData data = service.getStatistics();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/fetchWorkouts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WorkoutData>> fetchWorkouts() {
		System.out.println("/fetchWorkouts");
		List<WorkoutData> data = service.fetchWorkouts();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAccountInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountInfoData> getAccountInfo() {
		System.out.println("/getAccountInfo");
		AccountInfoData data = service.getAccountInfo();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/getDetailedWorkout/{endomondoId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DetailedWorkoutData> getDetailedWorkout(@PathVariable String endomondoId) {
		System.out.println("/getDetailedWorkout endomondoId=" + endomondoId);
		DetailedWorkoutData data = service.getWorkoutDetails(Long.parseLong(endomondoId));
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
