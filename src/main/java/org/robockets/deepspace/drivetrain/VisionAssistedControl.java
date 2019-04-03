package org.robockets.deepspace.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.OI;
import org.robockets.deepspace.Robot;

public class VisionAssistedControl extends Command {

	private final double RAMP_FACTOR = 0.5;

	private double previousTranslate = 0.0;

	private boolean endOnTarget;
	private boolean isTape;

	/**
	 *
	 * @param endOnTarget Stop when you have reached the target
	 * @param isTape True:Tape False:Cargo
	 */
	public VisionAssistedControl(boolean endOnTarget, boolean isTape) {
		requires(Robot.drivetrain);
		this.endOnTarget = endOnTarget;
		this.isTape = isTape;
	}

	protected void initialize() {
		Robot.drivetrain.enableGyroPID();
		Robot.drivetrain.startVisionControl(isTape);
	}

	protected void execute() {

		// TODO: Check if the braces need to be moved (possibly to only include vision stuff)
		if (Robot.drivetrain.canSeeTape()) { // Make sure to only run this if can see tape
			Robot.drivetrain.setRelativePosition(Robot.drivetrain.getTapeAngle());


			double translate = OI.joystick.getRawAxis(1) * 0.75;
			double rotate = Robot.drivetrain.getGyroPIDOutput();

			translate = ((translate - previousTranslate) * RAMP_FACTOR) + previousTranslate;

			previousTranslate = translate;

			Robot.drivetrain.driveArcade(translate, rotate);
		}
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
		Robot.drivetrain.stopVisionControl();
	}

	protected void interrupted() {
		end();
	}
}