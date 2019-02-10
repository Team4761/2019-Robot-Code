package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.robockets.deepspace.RobotMap;

public class BBVelocityControl extends Command {

	private final double kP = 0.001;

	public BBVelocityControl() {
		SmartDashboard.putNumber("BBVelocity", 0);
		SmartDashboard.putNumber("BB kP", kP);
	}

	protected void initialize() {
	}

	protected void execute() {
		double setVelocity = SmartDashboard.getNumber("BBVelocity", 0);
		double leftVel = RobotMap.leftClimberEncoder.getVelocity();
		//double rightVal = RobotMap.rightClimberEncoder.getVelocity();

		double leftDelta = setVelocity-leftVel;

		double newKP = SmartDashboard.getNumber("BB kP", kP);
		double output = leftDelta*newKP;

		RobotMap.leftClimber.set(output);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}