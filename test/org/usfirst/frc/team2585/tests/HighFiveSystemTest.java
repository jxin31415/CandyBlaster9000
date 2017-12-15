package org.usfirst.frc.team2585.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc.team2585.input.InputMethod;
import org.usfirst.frc.team2585.systems.HighFiveSystem;


/**
 * Unit Tests for the high five system
 */
public class HighFiveSystemTest {
	private TestInput input;
	private TestHighFiveSystem highFiveSystem;
	
	boolean shouldHighFiveUpInput;
	boolean shouldHighFiveDownInput;
	
	double armSpeedOutput;
	
	/**
	 * Create new input and high five system for testing
	 */
	@Before
	public void setUp() {
		input = new TestInput();
		highFiveSystem = new TestHighFiveSystem();
		highFiveSystem.setInput(input);
	}
	
	/**
	 * Tests that the speed of the motor starts as zero when the 
	 * user gives no input
	 */
	@Test
	public void defaultsToZero() {
		shouldHighFiveUpInput = false;
		shouldHighFiveDownInput = false;
		highFiveSystem.run();
		Assert.assertTrue(armSpeedOutput == 0);
	}
	
	/**
	 * Tests that the arm speed is positive when the user high fives up
	 */
	@Test
	public void highFivesUp() {
		shouldHighFiveUpInput = true;
		highFiveSystem.run();
		Assert.assertTrue(armSpeedOutput>0);
	}
	
	/**
	 * Tests that the arm speed is negative when the user high fives up
	 */
	@Test
	public void highFivesDown() {
		shouldHighFiveDownInput = true;
		highFiveSystem.run();
		Assert.assertTrue(armSpeedOutput<0);
	}
	
	/**
	 * Tests that the arm doesn't move when both buttons are pressed
	 */
	@Test
	public void bothPressed() {
		shouldHighFiveDownInput = true;
		shouldHighFiveUpInput = true;
		highFiveSystem.run();
		Assert.assertTrue(armSpeedOutput==0);
	}
	
	/**
	 * Tests that the output returns to zero after releasing the highFiveUp button
	 */
	@Test
	public void returnsToZeroAfterUp() {
		shouldHighFiveUpInput = true;
		highFiveSystem.run();
		shouldHighFiveUpInput = false;
		highFiveSystem.run();
		
		Assert.assertTrue(armSpeedOutput==0);
	}
	
	/**
	 * Tests that the output returns to zero after releasing the highFiveDown button
	 */
	@Test
	public void returnsToZeroAfterDown() {
		shouldHighFiveDownInput = true;
		highFiveSystem.run();
		shouldHighFiveDownInput = false;
		highFiveSystem.run();
		
		Assert.assertTrue(armSpeedOutput==0);
	}
	
	
	/**
	 * Testable input for the high five system tests
	 */
	private class TestInput extends InputMethod {
		/* (non-Javadoc)
		 * @see org.usfirst.frc.team2585.input.InputMethod#shouldHighFiveUp()
		 */
		@Override
		public boolean shouldHighFiveUp() {
			return shouldHighFiveUpInput;
		}
		
		@Override
		public boolean shouldHighFiveDown() {
			return shouldHighFiveDownInput;
		}
	}
	
	/**
	 * A testable High Five System
	 */
	private class TestHighFiveSystem extends HighFiveSystem {
		
		/* (non-Javadoc)
		 * @see org.usfirst.frc.team2585.systems.HighFiveSystem#setArmSpeed(double)
		 */
		@Override
		public void setArmSpeed(double newSpeed) {
			armSpeedOutput = newSpeed;
		}	
	}
}
