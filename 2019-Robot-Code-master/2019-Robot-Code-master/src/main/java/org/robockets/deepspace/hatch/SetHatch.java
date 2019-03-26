package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class SetHatch extends Command {

	private DoubleSolenoid.Value outerVal;
	private DoubleSolenoid.Value innerVal;

	public SetHatch(DoubleSolenoid.Value outerVal, DoubleSolenoid.Value innerVal) {
		this.outerVal = outerVal;
		this.innerVal = innerVal;
	}

	protected void initialize() {
		Robot.hatch.setOuterPistons(outerVal);
		Robot.hatch.setMiddlePiston(innerVal);
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