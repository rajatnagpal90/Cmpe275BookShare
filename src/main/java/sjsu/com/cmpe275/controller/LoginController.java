package sjsu.com.cmpe275.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjsu.com.cmpe275.Model.UserModel;

@Controller
public class LoginController {
	/*
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	   public ModelAndView login() throws Exception
	   {
		   ModelAndView mav = new ModelAndView("login", "command", new UserModel());
		   return mav;
	   }
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	   public ModelAndView home() throws Exception
	   {
	      //_repo.indexBooks();

	      ModelAndView mav = new ModelAndView("home");
	      mav.addObject("message", "Welcome to Papa Pustak Bhandar!");
	      return mav;
	   }
	   
	   @RequestMapping(value = "/signup", method = RequestMethod.GET)
	   public ModelAndView signup() throws Exception
	   {
		   ModelAndView mav = new ModelAndView("signup", "command", new UserModel());
		   return mav;
	   }
*/
}
