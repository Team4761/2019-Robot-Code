package org.robockets.deepspace.cargo;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
		/*double val = OI.joystick.getRawAxis(3)*0.3; // 0.1 stops it

		if (OI.joystick.getRawButton(6)) {
			val *= -1.0;
		}

		SmartDashboard.putNumber("Cargo Output", val);*/

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