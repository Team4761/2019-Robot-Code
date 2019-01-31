package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class Climb extends Command {

	public Climb() {
		requires(Robot.climber);
	}

	protected void initialize() {
		//Robot.climber.extendPistons();
		//setTimeout(1); // For now... This will eventually be based on encoders
	}

	protected void execute() {
		Robot.climber.moveArms(0.9);
	}

	protected boolean isFinished() {
		//return isTimedOut();
		return false;
	}

	protected void end() {
		Robot.climber.moveArms(0);
		//Robot.climber.closePistons();
		Robot.climber.stopPistons();
	}

	protected void interrupted() {
		end();
	}
}