package br.com.julio.controller;

import br.com.julio.math.ValidateNumber;
import br.com.julio.exceptions.UnsupportedMathOperationException;
import br.com.julio.math.SimpleMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;
import java.lang.*;


@RestController
public class MathController {

	private SimpleMath math = new SimpleMath();

	private static final AtomicLong counter = new AtomicLong();


	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws  Exception{
		if (!ValidateNumber.isNumeric(numberOne) || !ValidateNumber.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(ValidateNumber.convertToDouble(numberOne), ValidateNumber.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/subtract/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public double subtract(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws  Exception{
		if (!ValidateNumber.isNumeric(numberOne) || !ValidateNumber.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.subtract(ValidateNumber.convertToDouble(numberOne), ValidateNumber.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/multiply/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public double multiply(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws  Exception{
		if (!ValidateNumber.isNumeric(numberOne) || !ValidateNumber.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.multiply(ValidateNumber.convertToDouble(numberOne), ValidateNumber.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/division/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws  Exception{
		if (!ValidateNumber.isNumeric(numberOne) || !ValidateNumber.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.division(ValidateNumber.convertToDouble(numberOne), ValidateNumber.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) throws  Exception{
		if (!ValidateNumber.isNumeric(numberOne) || !ValidateNumber.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.mean(ValidateNumber.convertToDouble(numberOne), ValidateNumber.convertToDouble(numberTwo));
	}


	@RequestMapping(value = "/sqrt/{numbersqrt}",
			method = RequestMethod.GET)
	public double sqrt(
			@PathVariable(value = "numbersqrt") String numbersqrt
	) throws  Exception{
		if (!ValidateNumber.isNumeric(numbersqrt)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sqrt(ValidateNumber.convertToDouble(numbersqrt));
	}





}
