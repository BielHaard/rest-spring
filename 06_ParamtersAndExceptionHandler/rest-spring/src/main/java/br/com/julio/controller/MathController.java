package br.com.julio.controller;

import br.com.julio.exceptions.UnsupportedMathOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;
import java.lang.*;


@RestController
public class MathController {

	private final ValidateNumberController validateNumberController;

	@Autowired
	public MathController(ValidateNumberController validateNumberController) {
		this.validateNumberController = validateNumberController;
	}

	private static final AtomicLong counter = new AtomicLong();


	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws  Exception{
		if (!validateNumberController.isNumeric(numberOne) || !validateNumberController.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return validateNumberController.convertToDouble(numberOne) + validateNumberController.convertToDouble(numberTwo);
	}

	@RequestMapping(value = "/subtract/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public double subtract(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws  Exception{
		if (!validateNumberController.isNumeric(numberOne) || !validateNumberController.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return validateNumberController.convertToDouble(numberOne) - validateNumberController.convertToDouble(numberTwo);
	}

	@RequestMapping(value = "/multiply/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public double multiply(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws  Exception{
		if (!validateNumberController.isNumeric(numberOne) || !validateNumberController.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return validateNumberController.convertToDouble(numberOne) * validateNumberController.convertToDouble(numberTwo);
	}

	@RequestMapping(value = "/division/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws  Exception{
		if (!validateNumberController.isNumeric(numberOne) || !validateNumberController.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return validateNumberController.convertToDouble(numberOne) / validateNumberController.convertToDouble(numberTwo);
	}

	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws  Exception{
		if (!validateNumberController.isNumeric(numberOne) || !validateNumberController.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return (validateNumberController.convertToDouble(numberOne) / validateNumberController.convertToDouble(numberTwo)) / 2;
	}


	@RequestMapping(value = "/sqrt/{numbersqrt}",
			method = RequestMethod.GET)
	public double sqrt(
			@PathVariable(value = "numbersqrt") String numbersqrt
	) throws  Exception{
		if (!validateNumberController.isNumeric(numbersqrt)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return Math.sqrt(validateNumberController.convertToDouble(numbersqrt));
	}





}
