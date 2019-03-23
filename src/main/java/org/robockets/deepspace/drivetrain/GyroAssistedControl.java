package org.robockets.deepspace.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.OI;
import org.robockets.deepspace.Robot;

public class GyroAssistedControl extends Command {

	private final double RAMP_FACTOR = 0.5;

	private double previousTranslate = 0.0;

	private boolean endOnTarget;

	public GyroAssistedControl(boolean endOnTarget) {
		requires(Robot.drivetrain);
		this.endOnTarget = endOnTarget;
	}

	protected void initialize() {
		Robot.drivetrain.enableGyroPID();
	}

	protected void execute() {
		double translate = OI.joystick.getRawAxis(1)*0.75;
		double rotate = Robot.drivetrain.getGyroPIDOutput();

		translate = ((translate-previousTranslate)*RAMP_FACTOR)+previousTranslate;

		previousTranslate = translate;

		Robot.drivetrain.driveArcade(translate, rotate);
	}

	protected boolean isFinished() {
		if (endOnTarget) {
			return Robot.drivetrain.isGyroOnTarget();
		} else {
			return false;
		}
	}

	protected void end() {
		Robot.drivetrain.disableGyroPID();
	}

	protected void interrupted() {
		end();
	}
}