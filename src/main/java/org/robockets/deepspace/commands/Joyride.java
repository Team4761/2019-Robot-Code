package org.robockets.deepspace.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.OI;
import org.robockets.deepspace.Robot;

public class Joyride extends Command {

	public Joyride() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {

	}

	protected void execute() {
		double translate = OI.joystick.getRawAxis(1);
		double rotate = -OI.joystick.getRawAxis(4)*0.6;

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