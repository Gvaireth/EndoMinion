package org.gvaireth.core;

import java.util.Date;
import java.util.List;

import org.gvaireth.model.DetailedWorkoutData;
import org.gvaireth.model.SimpleData;
import org.gvaireth.model.StatisticsData;
import org.gvaireth.model.WorkoutCrudData;
import org.gvaireth.server.EndoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping("/raw")
	public ModelAndView rawData(Model model) {
		System.out.println("raw");
		return new ModelAndView("raw.jsp");
	}

	@RequestMapping(value = "/getSimpleData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimpleData> getSimpleData() {
		System.out.println("/getSimpleData");
		SimpleData data = new SimpleData("one", "two");
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/getWorkouts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WorkoutCrudData>> getWorkouts() {
		System.out.println("/getWorkouts");
		System.out.println(service.getAccountInfo());
		List<WorkoutCrudData> data = service.getWorkouts();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/getStatistics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatisticsData> getStatistics() {
		System.out.println("/getWorkouts");
		StatisticsData data = service.getStatistics();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/fetchWorkouts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WorkoutCrudData>> fetchWorkouts() {
		System.out.println("/fetchWorkouts");
		List<WorkoutCrudData> data = service.fetchWorkouts();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@RequestMapping(value = "/getDetailedWorkout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DetailedWorkoutData> getDetailedWorkout(@RequestParam String endomondoId) {
		System.out.println("/getDetailedWorkout endomondoId=" + endomondoId);
		DetailedWorkoutData data = service.getWorkoutDetails(Long.parseLong(endomondoId));
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@RequestMapping("/angular")
	public ModelAndView angular(Model model) {
		return new ModelAndView("angular.jsp");
	}

	@RequestMapping(value = "/angular/getTime", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody String show() {
		String msg = "Time is: " + new Date();
		System.out.println(msg);
		return msg;
	}

}
