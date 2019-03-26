package org.robockets.deepspace.cargo;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class ToggleCargoDirection extends Command {

	public ToggleCargoDirection() {
	}

	protected void initialize() {
		DoubleSolenoid.Value val = Robot.cargo.getSolenoidValue();

		if (val == DoubleSolenoid.Value.kForward) {
			Robot.cargo.setSolenoid(DoubleSolenoid.Value.kReverse);
		} else {
			Robot.cargo.setSolenoid(DoubleSolenoid.Value.kForward);
		}
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