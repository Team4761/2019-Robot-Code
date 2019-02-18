package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class SetOuterHatch extends Command {

	private DoubleSolenoid.Value val;

	public SetOuterHatch(DoubleSolenoid.Value val) {
		this.val = val;
	}

	protected void initialize() {
		Robot.hatch.setOuterPistons(val);
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