package com.codelabs.java_developers.fundamentals;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * JUnit4 unit tests for the calculator logic
 * - These are local unit tests
 * - no device needed
 */
@RunWith(JUnit4.class)
public class Fundamentals031_CalculatorTest {

	private Fundamentals031_Calculator mCalculator;

	/**
	 * Set up the environment for testing
	 */
	@Before
	public void setUp() {
		mCalculator = new Fundamentals031_Calculator();
	}

	/**
	 * Test for simple addition
	 */
	@Test
	public void addTwoNumbers() {
		double resultAdd = mCalculator.add(1d, 1d);
		assertEquals(resultAdd, 2d, 0.0);
	}

	@Test
	public void addTwoNumbersNegative() {
		double resultAdd = mCalculator.add(-1d, 2d);
		assertEquals(resultAdd, 1d, 0.0);
	}

	@Test
	public void addTwoNumbersFloats() {
		double resultAdd = mCalculator.add(1.111f, 1.111d);
		assertEquals(resultAdd, 2.222d, 0.01);
	}

	@Test
	public void subTwoNumbers() {
		double resultSub = mCalculator.sub(1d, 1d);
		assertEquals(resultSub, 0d, 0.0);
	}

	@Test
	public void subWorksWithNegativeResults() {
		double resultSub = mCalculator.sub(1d, 17d);
		assertEquals(resultSub, -16d, 0.0);
	}

	@Test
	public void mulTwoNumbers() {
		double resultMul = mCalculator.mul(32d, 2d);
		assertEquals(resultMul, 64d, 0.0);
	}

	@Test
	public void mulTwoNumbersZero() {
		double resultMul = mCalculator.mul(16d, 0);
		assertEquals(resultMul, 0d, 0.0);
	}

	@Test
	public void divTwoNumbers() {
		double resultDiv = mCalculator.div(32d, 2d);
		assertEquals(resultDiv, 16d, 0.0);
	}

	@Test
	public void divTwoNumbersZero() {
		double resultDiv = mCalculator.div(32d, 0);
		assertEquals(resultDiv, Double.POSITIVE_INFINITY, 0);
	}
}