package org.robockets.deepspace.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class DriveTimed extends Command {

	private double speed;
	private double time;

	public DriveTimed(double speed, double time) {
		requires(Robot.drivetrain);
		this.speed = speed;
		this.time = time;
	}

	protected void initialize() {
		setTimeout(time);
	}

	protected void execute() {
		Robot.drivetrain.driveArcade(speed, 0);
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