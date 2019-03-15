package org.robockets.deepspace.misccommands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class ResetPneumatics extends Command {

	public ResetPneumatics() {
	}

	protected void initialize() {
		Robot.climber.closeRightSolenoid();
		Robot.hatch.setPusher(DoubleSolenoid.Value.kReverse);
		Robot.hatch.setFinger(DoubleSolenoid.Value.kReverse);
		Robot.cargo.setSolenoid(DoubleSolenoid.Value.kReverse);
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