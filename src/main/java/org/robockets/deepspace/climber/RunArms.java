package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class RunArms extends Command {

	private double speed;

	public RunArms(double speed) {
		this.speed = speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.climber.moveLeftArm(speed);
		Robot.climber.moveRightArm(speed);
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