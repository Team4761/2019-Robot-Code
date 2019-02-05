package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

		SmartDashboard.putData(climberPIDController);
	}

	public void initDefaultCommand() {
	}

	public void moveArms(double speed) {
		RobotMap.climberMotors.set(speed);
	}

	public void moveLeftArm(double speed) {
		RobotMap.leftClimber.set(speed);
	}

	public void moveRightArm(double speed) {
		RobotMap.rightClimber.set(speed);
	}

	public void extendPistons() {
		RobotMap.climberSolenoids.set(DoubleSolenoid.Value.kForward);
	}

	public void closePistons() {
		RobotMap.climberSolenoids.set(DoubleSolenoid.Value.kReverse);
	}

	/**
	 *
	 * @param speed Vertical speed in inches per seoncd
	 */
	public void setSpeed(double speed) {
		climberPIDController.setSetpoint(speed);
	}

	public void enablePID() {
		climberPIDController.enable();
	}

	public void disablePID() {
		climberPIDController.disable();
	}

	public void moveBottomWheels(double speed) {
		RobotMap.climberWheels.set(speed);
	}

	public void stopPistons() {
		RobotMap.climberSolenoids.set(DoubleSolenoid.Value.kOff);
	}
}