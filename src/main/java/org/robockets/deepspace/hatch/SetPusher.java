package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class SetPusher extends Command {

	private DoubleSolenoid.Value val;

	public SetPusher(DoubleSolenoid.Value val) {
		this.val = val;
	}

	protected void initialize() {
		Robot.hatch.setPusher(val);
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