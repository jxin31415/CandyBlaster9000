package org.usfirst.frc.team2585.robot;

import org.impact2585.lib2585.RobotEnvironment;
import org.usfirst.frc.team2585.input.InputMethod;
import org.usfirst.frc.team2585.input.XBoxInput;

/**
 * A class containing the robot's systems and input
 */
public class Environment extends RobotEnvironment {
	private static final long serialVersionUID = -5250612316835166409L;
	private InputMethod input;

	/**
	 * Initializes the systems and input
	 * @param robot the instance of the robot that belongs to the environment
	 */
	public Environment(Robot robot) {
		super(robot);
		input = new XBoxInput();
	}
	
	/**
	 * @return the input
	 */
	public InputMethod getInput() {
		return input;
	}
	
	/* (non-Javadoc)
	 * @see org.impact2585.lib2585.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		// Destroy all of the systems
	}

}
