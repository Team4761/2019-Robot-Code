package org.robockets.deepspace.cargo;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class GrabCargo extends Command {

	public GrabCargo() {
		requires(Robot.cargo);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.cargo.moveIntake(0.75);
	}

	protected boolean isFinished() {
		return Robot.cargo.hasCargo();
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}