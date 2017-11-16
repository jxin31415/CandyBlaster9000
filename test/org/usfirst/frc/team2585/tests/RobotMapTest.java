package org.usfirst.frc.team2585.tests;
import java.lang.reflect.Field;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;
import org.usfirst.frc.team2585.robot.RobotMap;


/**
 * Test the RobotMap
 */
public class RobotMapTest {
	/**
	 * Test that no Robot port numbers are used twice
	 */
	@Test
	public void noRepeats() {
		int portCount = RobotMap.class.getFields().length;
		HashSet<Integer> singlePorts = new HashSet<Integer>();
		for (Field portNum : RobotMap.class.getFields()) {
			try {
				singlePorts.add(portNum.getInt(null));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		Assert.assertTrue(singlePorts.size() == portCount);
	}

}
