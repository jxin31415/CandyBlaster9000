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
	
	boolean shouldHighFiveInput;
	long timePassed;
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
		shouldHighFiveInput = false;
		highFiveSystem.run();
		Assert.assertTrue(armSpeedOutput == 0);
	}
	
	/**
	 * Tests that when the user gives input, the motor is set to run forward
	 */
	@Test
	public void motorRunsWithInput() {
		shouldHighFiveInput = true;
		highFiveSystem.run();
		Assert.assertTrue(armSpeedOutput>0);
	}
	
	/**
	 * Tests that the motor continues to run forward after input has been
	 * given and time has passed
	 */
	@Test
	public void continuesMovingForward() {
		timePassed=(long) 0.1*highFiveSystem.highFiveLength;
		shouldHighFiveInput = true;
		highFiveSystem.run();
		Assert.assertTrue(armSpeedOutput>0);
	}
	
	/**
	 * Tests that the motor continues running even after the high five button is released
	 */
	@Test

	public void continuesAfterButtonReleased() {
		timePassed=(long) 0.1*highFiveSystem.highFiveLength;
		shouldHighFiveInput = true;
		highFiveSystem.run();
		shouldHighFiveInput = false;
		highFiveSystem.run();
		Assert.assertTrue(armSpeedOutput>0);
	}
	
	
	/**
	 * Tests that the motor starts to move back after running for half of the
	 * high five time
	 */
	@Test
	public void movesBack() {
		timePassed = (long) (0.9*highFiveSystem.highFiveLength);
		shouldHighFiveInput = true;
		highFiveSystem.run();

		Assert.assertTrue(armSpeedOutput<0);
	}
	
	/**
	 * Tests that the motor is turned off after the time of the highfive is over
	 */
	@Test
	public void stopsMoving() {
		shouldHighFiveInput = true;
		
		timePassed = (long) (0.9*highFiveSystem.highFiveLength);
		highFiveSystem.run();

		timePassed = (long) (1.1*highFiveSystem.highFiveLength);		
		highFiveSystem.run();

		Assert.assertTrue(armSpeedOutput==0);
	}
	
	/**
	 * Tests that the high five sequence can be run twice
	 */
	@Test
	public void canRunTwice() {
		shouldHighFiveInput = true;
		
		timePassed = (long) (0.9*highFiveSystem.highFiveLength);
		highFiveSystem.run();

		timePassed = (long) (1.1*highFiveSystem.highFiveLength);		
		highFiveSystem.run();
		
		shouldHighFiveInput = false;
		highFiveSystem.run();
		
		shouldHighFiveInput = true;
		timePassed = (long) (0.2*highFiveSystem.highFiveLength);
		highFiveSystem.run();
		

		Assert.assertTrue(armSpeedOutput>0);
	}
	
	
	/**
	 * Testable input for the high five system tests
	 */
	private class TestInput extends InputMethod {
		/* (non-Javadoc)
		 * @see org.usfirst.frc.team2585.input.InputMethod#shouldHighFive()
		 */
		@Override
		public boolean shouldHighFive() {
			return shouldHighFiveInput;
		}
	}
	
	/**
	 * A testable High Five System
	 */
	private class TestHighFiveSystem extends HighFiveSystem {
		/* (non-Javadoc)
		 * @see org.usfirst.frc.team2585.systems.HighFiveSystem#getTimeSinceHighFiveStarted()
		 */
		@Override
		public long getTimeSinceHighFiveStarted() {
			return timePassed;
		}
		
		/* (non-Javadoc)
		 * @see org.usfirst.frc.team2585.systems.HighFiveSystem#setArmSpeed(double)
		 */
		@Override
		public void setArmSpeed(double newSpeed) {
			armSpeedOutput = newSpeed;
		}	
	}
}
