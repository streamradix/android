package com.codelabs.java_developers.fundamentals;

// Utility class for SimpleCalc to perform the actual calculations
public class Fundamentals031_Calculator {

	// Available operations
	public enum Operator {ADD, SUB, DIV, MUL}

	// Addition operation
	public double add(double firstOperand, double secondOperand) {
		return firstOperand + secondOperand;
	}

	// Subtract operation
	public double sub(double firstOperand, double secondOperand) {
		return firstOperand - secondOperand;
	}

	// Divide operation
	public double div(double firstOperand, double secondOperand) {
		return firstOperand / secondOperand;
	}

	// Multiply operation
	public double mul(double firstOperand, double secondOperand) {
		return firstOperand * secondOperand;
	}
}