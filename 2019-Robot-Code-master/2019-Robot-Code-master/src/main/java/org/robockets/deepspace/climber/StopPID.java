package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class StopPID extends Command {

	public StopPID() {
		requires(Robot.climber);
	}

	protected void initialize() {
		Robot.climber.disableRightPID();
		Robot.climber.disableLeftPID();
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