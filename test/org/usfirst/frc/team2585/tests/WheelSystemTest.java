package org.usfirst.frc.team2585.tests;

import org.junit.Test;
import org.junit.Assert;
import org.usfirst.frc.team2585.systems.WheelSystem;


/**
 * Tests the WheelSystem
 */
public class WheelSystemTest {
	/**
	 * Ensure that a Wheel System can be constructed without errors
	 */
	@Test
	public void constructable() {
		WheelSystem wheels = new WheelSystem();
		Assert.assertFalse(wheels == null);
	}

}
