package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;

public class Climber extends Subsystem {


	public void initDefaultCommand() {
	}

	public void moveArms(double speed) {
		RobotMap.climberMotors.set(speed);
	}

	public void extendPistons() {
		RobotMap.climberSolenoids.set(DoubleSolenoid.Value.kForward);
	}

	public void closePistons() {
		RobotMap.climberSolenoids.set(DoubleSolenoid.Value.kReverse);
	}


	public void stopPistons() {
		RobotMap.climberSolenoids.set(DoubleSolenoid.Value.kOff);
	}
}