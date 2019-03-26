package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class MoveBottomWheels extends Command {

	private double speed;
	private double time;
	private double waitTime;
	private Timer timer;

	public MoveBottomWheels(double speed, double time, double waitTime) {
		this.speed = speed;
		this.time = time;
		timer = new Timer();
		this.waitTime = waitTime;
	}

	protected void initialize() {
		setTimeout(time);
		timer.reset();
		timer.start();
	}

	protected void execute() {
		if (timer.hasPeriodPassed(waitTime)) {
			Robot.climber.moveBottomWheels(speed);
		}
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}