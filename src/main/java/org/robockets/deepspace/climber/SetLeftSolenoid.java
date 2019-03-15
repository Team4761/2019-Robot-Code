package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class SetLeftSolenoid extends Command {

	private DoubleSolenoid.Value value;

	public SetLeftSolenoid(DoubleSolenoid.Value direction) {
		value = direction;
	}

	protected void initialize() {
		Robot.climber.setLeftSolenoid(value);
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