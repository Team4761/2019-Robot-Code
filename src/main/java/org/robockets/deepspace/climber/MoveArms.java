package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class MoveArms extends Command {

	private double multi;

	public MoveArms(double multi) {
		requires(Robot.climber);
		this.multi = multi;
	}

	protected void initialize() {
		//Robot.climber.extendPistons();
		//setTimeout(1); // For now... This will eventually be based on encoders
	}

	protected void execute() {
		Robot.climber.moveArms(0.15*multi);
	}

	protected boolean isFinished() {
		//return isTimedOut();
		return false;
	}

	protected void end() {
		Robot.climber.moveArms(0);
		//Robot.climber.closePistons();
		//Robot.climber.stopPistons();
	}

	protected void interrupted() {
		end();
	}
}