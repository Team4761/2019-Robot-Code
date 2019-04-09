package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.OI;
import org.robockets.deepspace.Robot;
import org.robockets.deepspace.RobotMap;

public class RunArms extends Command {

	private double speed;

	public RunArms(double speed) {
		this.speed = speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		boolean isLeft = OI.button204.get();
		boolean isRight = OI.button221.get();

		System.out.println(speed);

		if (isLeft) {
			leftMove();
		} else if (isRight) {
			rightMove();
		} else {
			leftMove();
			rightMove();
		}
	}

	private void leftMove() {
		boolean leftLimit = RobotMap.leftLimitSwitch.get();
		if (speed < 0) {
			Robot.climber.moveLeftArm(speed);
		} else if (speed >0  && leftLimit) {
			Robot.climber.moveLeftArm(speed);
		}
	}

	private void rightMove() {
		boolean rightLimit = RobotMap.rightLimitSwitch.get();
		if(speed < 0) {
			Robot.climber.moveRightArm(speed);
		} else if (speed > 0 && rightLimit) {
			Robot.climber.moveRightArm(speed);
		}
	}



	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.climber.moveLeftArm(0);
		Robot.climber.moveRightArm(0);
	}

	protected void interrupted() {
		end();
	}
}