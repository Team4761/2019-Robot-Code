package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;
import org.robockets.deepspace.pidsources.ClimberPIDSource;
import org.robockets.deepspace.pidsources.DoubleEncoderPIDSource;

public class Climber extends Subsystem {

	private PIDController climberPIDController;

	public Climber() {
		climberPIDController = new PIDController(0, 0, 0, new ClimberPIDSource(), RobotMap.climberMotors);
		climberPIDController.disable();
		climberPIDController.setAbsoluteTolerance(1);
		climberPIDController.setOutputRange(-1.0, 1.0);
	}

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