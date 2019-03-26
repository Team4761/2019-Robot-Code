package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class SetExtraSolenoid extends Command {

	private DoubleSolenoid.Value value;

	public SetExtraSolenoid(DoubleSolenoid.Value direction) {
		value = direction;
	}

	protected void initialize() {
		Robot.climber.setExtraSolenoid(value);
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