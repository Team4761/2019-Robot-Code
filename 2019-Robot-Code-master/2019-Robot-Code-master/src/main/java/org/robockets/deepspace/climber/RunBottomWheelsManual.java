package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class RunBottomWheelsManual extends Command {

	private double speed;

	public RunBottomWheelsManual(double speed) {
		this.speed = speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.climber.moveBottomWheels(speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.climber.moveBottomWheels(0);
	}

	protected void interrupted() {
		end();
	}
}