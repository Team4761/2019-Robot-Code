package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class MoveBottomWheels extends Command {

	private double speed;
	private double time;

	public MoveBottomWheels(double speed, double time) {
		this.speed = speed;
		this.time = time;
	}

	protected void initialize() {
		setTimeout(time);
	}

	protected void execute() {
		Robot.climber.moveBottomWheels(speed);
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}