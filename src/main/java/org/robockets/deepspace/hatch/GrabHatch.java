package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class GrabHatch extends Command {

	public GrabHatch() {
		requires(Robot.hatch);
	}

	protected void initialize() {
		Robot.hatch.setOuterPistons(DoubleSolenoid.Value.kForward);
		Robot.hatch.setMiddlePiston(DoubleSolenoid.Value.kForward);
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