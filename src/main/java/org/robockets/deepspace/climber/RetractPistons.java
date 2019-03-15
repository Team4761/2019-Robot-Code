package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class RetractPistons extends Command {

	public RetractPistons() {
	}

	protected void initialize() {
		Robot.climber.closeRightSolenoid();
		Robot.climber.closeLeftSolenoid();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		//Robot.climber.stopPistons();
	}

	protected void interrupted() {
		end();
	}
}