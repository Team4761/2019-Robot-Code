package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class RetractPistons extends Command {

	public RetractPistons() {
		requires(Robot.hatch);
	}

	protected void initialize() {
		Robot.hatch.setOuterPistons(DoubleSolenoid.Value.kReverse);
		Robot.hatch.setMiddlePiston(DoubleSolenoid.Value.kReverse);
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