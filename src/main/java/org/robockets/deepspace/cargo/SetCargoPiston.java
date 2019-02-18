package org.robockets.deepspace.cargo;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class SetCargoPiston extends Command {

	private DoubleSolenoid.Value val;

	public SetCargoPiston(DoubleSolenoid.Value val) {
		this.val = val;
	}

	protected void initialize() {
		Robot.cargo.setSolenoid(val);
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