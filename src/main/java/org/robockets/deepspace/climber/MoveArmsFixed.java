package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;
import org.robockets.deepspace.RobotMap;

public class MoveArmsFixed extends Command {

	private final double FINAL_ENCODER_POS = 100.0; // This is about when the front wheels touch the ground

	public MoveArmsFixed() {
		requires(Robot.climber);
	}

	protected void initialize() {
		Robot.climber.setSpeed(4); // TODO: Put an actual value here
		Robot.climber.enablePID();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return RobotMap.leftClimberEncoder.getPosition() >= FINAL_ENCODER_POS;
	}

	protected void end() {
		Robot.climber.disablePID();
	}

	protected void interrupted() {
		end();
	}
}