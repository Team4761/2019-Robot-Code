package frc.org.robockets.deepspace.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.org.robockets.deepspace.Robot;

public class ReleaseClimber extends Command {

	public ReleaseClimber() {
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