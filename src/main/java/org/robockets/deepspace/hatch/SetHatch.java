package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class SetHatch extends Command {

	private DoubleSolenoid.Value setPusherVal;
	private DoubleSolenoid.Value setFingerVal;

	public SetHatch(DoubleSolenoid.Value setPusherVal, DoubleSolenoid.Value setFingerVal) {
		this.setPusherVal = setPusherVal;
		this.setFingerVal = setFingerVal;
	}

	protected void initialize() {
		Robot.hatch.setPusher(setPusherVal);
		Robot.hatch.setFinger(setFingerVal);
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