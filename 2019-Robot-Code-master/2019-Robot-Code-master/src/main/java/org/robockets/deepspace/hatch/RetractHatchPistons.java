package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class RetractHatchPistons extends Command {

	public RetractHatchPistons() {
		requires(Robot.hatch);
	}

	protected void initialize() {
		Robot.hatch.setMiddlePiston(DoubleSolenoid.Value.kReverse);
		Robot.hatch.setOuterPistons(DoubleSolenoid.Value.kReverse);
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