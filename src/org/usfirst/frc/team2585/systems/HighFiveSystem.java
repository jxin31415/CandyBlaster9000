package org.usfirst.frc.team2585.systems;

import org.usfirst.frc.team2585.robot.Environment;
import org.usfirst.frc.team2585.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * The system that gives high fives when the user presses a button
 */
public class HighFiveSystem extends RobotSystem implements Runnable {
	SpeedController armMotor;
	
	boolean previousInput = false;
	boolean isHighFiving = false;
	long highFiveStartTime = 0;
	public int highFiveLength = 500;
	
	/* (non-Javadoc)
	 * @see org.usfirst.frc.team2585.systems.RobotSystem#init(org.usfirst.frc.team2585.robot.Environment)
	 */
	@Override
	public void init(Environment environ) {
		super.init(environ);

		armMotor = new Victor(RobotMap.HIGH_FIVE_MOTOR);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		boolean currentInput = input.shouldHighFive();
		if (!previousInput && currentInput) {
			startHighFive();
		}
		
		if (isHighFiving) {
			long elapsedTime = getTimeSinceHighFiveStarted();
			if (elapsedTime < highFiveLength/2) {
				setArmSpeed(0.4);
			} else if (elapsedTime < highFiveLength) {
				setArmSpeed(-0.4);
			} else {
				setArmSpeed(0);
				isHighFiving = false;
			}
		} else {
			setArmSpeed(0);
		}
		
		previousInput = currentInput;
	}
	
	/**
	 * @param armSpeed the speed to set the arm motor to
	 */
	public void setArmSpeed(double armSpeed) {
		armMotor.set(armSpeed);
	}
	
	/**
	 * @return the time that has passed since the most recent high five was started
	 */
	public long getTimeSinceHighFiveStarted() {
		return System.currentTimeMillis()-highFiveStartTime;
	}
	
	/**
	 * Does one high five
	 */
	private void startHighFive() {
		highFiveStartTime = System.currentTimeMillis();
		isHighFiving = true;
	}

	/* (non-Javadoc)
	 * @see org.impact2585.lib2585.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
