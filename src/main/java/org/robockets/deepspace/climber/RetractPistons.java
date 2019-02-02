package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class RetractPistons extends Command {

	public RetractPistons() {
		requires(Robot.climber);
	}

	protected void initialize() {
		Robot.climber.closePistons();
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