package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;
import org.robockets.deepspace.RobotMap;

public class MoveArmsFixed extends Command {

	private double targetVerticalSpeed = 0;

	private double targetPos = 0; // This is about when the front wheels touch the ground

	public MoveArmsFixed(double speed, double target) {
		requires(Robot.climber);
		targetVerticalSpeed = speed;
		targetPos = target;
	}

	protected void initialize() {
		/*Robot.climber.setLeftSpeed(4); // TODO: Put an actual value here
		Robot.climber.setRightSpeed(4);*/
	}

	protected void execute() {

		double theta = RobotMap.leftClimberEncoder.getPosition()/Robot.climber.TURN_RADIUS;
		double sin = Math.sin(theta);

		double angularSpeed = targetVerticalSpeed/(Robot.climber.TURN_RADIUS*sin);

		Robot.climber.setLeftSpeed(angularSpeed);
		Robot.climber.setRightSpeed(angularSpeed);
	}

	protected boolean isFinished() {
		return RobotMap.leftClimberEncoder.getPosition() >= targetPos;
	}

	protected void end() {
		Robot.climber.disableLeftPID();
		Robot.climber.disableRightPID();
	}

	protected void interrupted() {
		end();
	}
}