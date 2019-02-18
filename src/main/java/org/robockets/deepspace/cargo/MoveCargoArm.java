package org.robockets.deepspace.cargo;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.OI;
import org.robockets.deepspace.Robot;
import org.robockets.deepspace.RobotMap;

public class MoveCargoArm extends Command {

	private double speed;

	public MoveCargoArm(double speed) {
		requires(Robot.cargo);
		//requires(Robot.triggers);
		this.speed = speed;
	}

	protected void initialize() {
	}

	protected void execute() {
		/*double val = OI.joystick.getRawAxis(3);

		if (OI.joystick.getRawButton(6)) {
			val *= -1.0;
		}

		System.out.println(RobotMap.cargoEncoder.getPosition());*/

		Robot.cargo.moveArmMotor(speed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.cargo.moveArmMotor(0);
	}

	protected void interrupted() {
		end();
	}
}