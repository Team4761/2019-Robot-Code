package org.robockets.deepspace.cargo;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.OI;
import org.robockets.deepspace.Robot;

public class RunCargoIntake extends Command {

	private double speed;

	public RunCargoIntake(double speed) {
		this.speed = speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		/*double speed = OI.joystick.getRawAxis(2);

		if (OI.joystick.getRawButton(5)) {
			speed *= -1.0;
		}*/

		Robot.cargo.moveIntake(speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.cargo.moveIntake(0);
	}

	protected void interrupted() {
		end();
	}
}