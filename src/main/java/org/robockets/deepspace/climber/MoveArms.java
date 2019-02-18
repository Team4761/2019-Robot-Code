package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.robockets.deepspace.OI;
import org.robockets.deepspace.Robot;

public class MoveArms extends Command {

	private double multi;

	public MoveArms(/*double multi*/) {
		requires(Robot.climber);
		requires(Robot.triggers);
		//this.multi = multi;
	}

	protected void initialize() {
		//Robot.climber.extendPistons();
		//setTimeout(1); // For now... This will eventually be based on encoders
	}

	protected void execute() {
		//Robot.climber.moveArms(0.15*multi);
		double leftVal = OI.joystick.getRawAxis(2)*0.20;
		double rightVal = OI.joystick.getRawAxis(3)*0.20;

		if (OI.joystick.getRawButton(5)) {
			leftVal *= -1.0;
		}

		if (OI.joystick.getRawButton(6)) {
			rightVal *= -1.0;
		}

		Robot.climber.moveLeftArm(leftVal);
		Robot.climber.moveRightArm(rightVal);
	}

	protected boolean isFinished() {
		//return isTimedOut();
		return false;
	}

	protected void end() {
		//Robot.climber.moveArms(0);
		//Robot.climber.closePistons();
		//Robot.climber.stopPistons();
	}

	protected void interrupted() {
		end();
	}
}