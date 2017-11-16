package org.usfirst.frc.team2585.robot;

import org.impact2585.lib2585.ExecuterBasedRobot;
import org.omg.CORBA.Environment;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends ExecuterBasedRobot {
	
	private Environment environ;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.IterativeRobot#teleopInit()
	 */
	@Override 
	public void teleopInit() {

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}
