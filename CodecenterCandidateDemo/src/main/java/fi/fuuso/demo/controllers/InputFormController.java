package fi.fuuso.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import fi.fuuso.demo.models.beans.InputData;
import fi.fuuso.demo.services.impl.UserInputServiceImpl;
import fi.fuuso.demo.utils.StringValidator;

@Controller
@RequestMapping(value="/inputform")
public class InputFormController {
	
	private UserInputServiceImpl userInputService;
	
	public UserInputServiceImpl getUserInputService() {
		return userInputService;
	}

	@Autowired
	public void setUserInputService(UserInputServiceImpl userInputService) {
		this.userInputService = userInputService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getInputForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inputform");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postInputForm(WebRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inputform");
		String firstName = StringValidator.cleanString(request.getParameter("firstName"));
		String lastName = StringValidator.cleanString(request.getParameter("lastName"));
		String gender = StringValidator.cleanString(request.getParameter("gender"));
		String description = StringValidator.cleanString(request.getParameter("description"));
		String[][] dataToValidate = new String[][]{{"firstName", firstName}, {"lastName", lastName}, {"gender", gender}, {"description", description}};
		boolean isInputDataValid = true;
		// Validates all the input data and adds invalida data "flags" to mav
		// TODO: Beware of magic numbers, maybe use a different data structure?
		for (int i = 0; i < dataToValidate[0].length; i++) {
			if(!StringValidator.validateString(dataToValidate[i][1])) {
				mav.addObject(dataToValidate[i][0] + "Invalid", "INVALID DATA");
				isInputDataValid = false;
			}
		}
		if(isInputDataValid) {
			InputData inputData = new InputData();
			inputData.setFirstName(firstName);
			inputData.setLastName(lastName);
			inputData.setGender(gender);
			inputData.setDescription(description);
			try {
				userInputService.storeUserInput(inputData);
				StringBuilder message = new StringBuilder();
				message.append("Data stored successfully. Data was: ");
				message.append(firstName + ", ");
				message.append(lastName + ", ");
				message.append(gender + ", ");
				message.append(description);
				mav.addObject("resultMessage", message);
			} catch (Exception e) {
				StringBuilder message = new StringBuilder();
				message.append("Storing data failed. Error was: ");
				message.append(e.toString());
				mav.addObject("resultMessage", message);
			}
		} else{
			mav.addObject("resultMessage", "Your input was invalid. Data was not stored.");
		}
		return mav;
	}
	
}
