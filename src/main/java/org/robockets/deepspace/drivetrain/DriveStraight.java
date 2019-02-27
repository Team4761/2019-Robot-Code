package org.robockets.deepspace.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class DriveStraight extends Command {

	private double distance;

	public DriveStraight(double distance) {
		requires(Robot.drivetrain);
		this.distance = distance;
	}

	protected void initialize() {
		Robot.drivetrain.setRelativePosition(distance);
		Robot.drivetrain.enableTranslatePID();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return Robot.drivetrain.isTranslateFinished();
	}

	protected void end() {
		Robot.drivetrain.disableTranslatePID();
	}

	protected void interrupted() {
		end();
	}
}