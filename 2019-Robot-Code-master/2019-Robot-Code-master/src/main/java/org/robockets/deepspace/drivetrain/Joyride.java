package org.robockets.deepspace.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.OI;
import org.robockets.deepspace.Robot;

public class Joyride extends Command {

	private final double RAMP_FACTOR = 0.5;

	private double previousTranslate = 0.0;
	private double previousRotate = 0.0;

	public Joyride() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {

	}

	protected void execute() {
		double translate = OI.joystick.getRawAxis(1)*0.75;
		double rotate = -OI.joystick.getRawAxis(4);

		translate = ((translate-previousTranslate)*RAMP_FACTOR)+previousTranslate;
		rotate = ((rotate-previousRotate)*RAMP_FACTOR)+previousRotate;

		previousTranslate = translate;
		previousRotate = rotate;

		Robot.drivetrain.driveArcade(translate, rotate);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {
		end();
	}
}