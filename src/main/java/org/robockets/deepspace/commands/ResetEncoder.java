package org.robockets.deepspace.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class ResetEncoder extends Command {

	public ResetEncoder() {
		setRunWhenDisabled(true);
	}

	protected void initialize() {
		Robot.climber.pidSource.reset();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}