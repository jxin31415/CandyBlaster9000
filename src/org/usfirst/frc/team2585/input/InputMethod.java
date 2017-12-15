package org.usfirst.frc.team2585.input;

/**
 * Operator controls for the robot
 */
public abstract class InputMethod {
	/**
	 * @return value between -1 and 1 telling how quickly to move backwards/forwards
	 */
	public double forwardAmount() {
		return 0;
	}
	
	/**
	 * Positive denotes rightward rotation and negative denotes leftward rotation
	 * @return value between -1 and 1 telling how fast the robot should rotate
	 */
	public double rotationAmount() {
		return 0;
	}
	
	/**
	 * @return a boolean denoting whether or not the shooter should be running
	 */
	public boolean shouldShoot() {
		return false;
	}
	
	/**
	 * @return a boolean whether or not the high five arm should move up
	 */
	public boolean shouldHighFiveUp() {
		return false;
	}
	
	/**
	 * @return a boolean whether or not the high five arm should move down
	 */
	public boolean shouldHighFiveDown() {
		return false;
	}
}
