package org.gvaireth.core;

import java.util.Date;

import org.gvaireth.server.EndoService;
import org.springframework.beans.factory.annotation.Autowired;
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
	private EndoService service;// = new EndoService();;

	@RequestMapping("/*")
	public ModelAndView helloWorld(Model model) {
		model.addAttribute("app", "home");
		return new ModelAndView("index.jsp");
	}

	@RequestMapping("/raw")
	public ModelAndView rawData(Model model) {
		return new ModelAndView("raw.jsp");
	}

	@RequestMapping(value = "/workouts", method = RequestMethod.GET)
	public ModelAndView workouts(@RequestParam(defaultValue = "none") String action, Model model) {
		model.addAttribute("data", service.getWorkouts());
		model.addAttribute("size", service.getWorkouts().size());
		System.out.println("displaying workouts: " + action);
		if (action.equals("update")) {
			service.updateData();
		}
		return new ModelAndView("workouts.jsp");
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

	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public ModelAndView statistics(@RequestParam(defaultValue = "all") String action, Model model) {
		model.addAttribute("statistics", service.getStatistics());
		model.addAttribute("totalPerSport", service.getStatistics().getTotalPerSport());
		model.addAttribute("topDuration", service.getStatistics().getTopDuration());
		model.addAttribute("topDistance", service.getStatistics().getTopDistance());
		model.addAttribute("topSpeedAvg", service.getStatistics().getTopSpeedAvg());
		System.out.println("displaying statistic: " + action);

		return new ModelAndView("statistics.jsp");
	}

}
