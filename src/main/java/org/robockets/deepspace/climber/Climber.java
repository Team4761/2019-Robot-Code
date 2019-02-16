package org.robockets.deepspace.climber;

import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.robockets.deepspace.RobotMap;
import org.robockets.deepspace.pidsources.ClimberPIDSource;
import org.robockets.deepspace.pidsources.DoubleEncoderPIDSource;

public class Climber extends Subsystem {

	private CANPIDController leftClimberPIDController;
	private CANPIDController rightClimberPIDController;

	private double leftKP, leftKI, leftKD, leftKIz, leftKFF, leftSetPoint, rightKP, rightKI, rightKD, rightKIz, rightKFF, rightSetPoint, kMaxOutput, kMinOutput;

	public final double TURN_RADIUS = 1.0; // In inches

	public final double REV_PER_DEG = 1.538;

	public Climber() {

		leftClimberPIDController = RobotMap.leftClimber.getPIDController();
		rightClimberPIDController = RobotMap.rightClimber.getPIDController();

		leftKP = 0.00055;
		leftKI = 0.00001;
		leftKD = 0;
		leftKIz = 0;
		leftKFF = 0;
		leftSetPoint = 0;

		rightKP = 0.00055;
		rightKI = 0.00001;
		rightKD = 0;
		rightKIz = 0;
		rightKFF = 0;
		rightSetPoint = 0;

		kMaxOutput = 1;
		kMinOutput = -1;

		leftClimberPIDController.setP(leftKP);
		leftClimberPIDController.setI(leftKI);
		leftClimberPIDController.setD(leftKD);
		//leftClimberPIDController.setIZone(leftKIz);
		leftClimberPIDController.setFF(leftKFF);
		leftClimberPIDController.setOutputRange(kMinOutput, kMaxOutput);

		rightClimberPIDController.setP(rightKP);
		rightClimberPIDController.setI(rightKI);
		rightClimberPIDController.setD(rightKD);
		//rightClimberPIDController.setIZone(rightKIz);
		rightClimberPIDController.setFF(rightKFF);
		rightClimberPIDController.setOutputRange(kMinOutput, kMaxOutput);

		/*SmartDashboard.putNumber("Left P Gain", leftKP);
		SmartDashboard.putNumber("Left I Gain", leftKI);
		SmartDashboard.putNumber("Left D Gain", leftKD);
		//SmartDashboard.putNumber("I Zone", kIz);
		SmartDashboard.putNumber("Left Feed Forward", leftKFF);

		SmartDashboard.putNumber("Right P Gain", rightKP);
		SmartDashboard.putNumber("Right I Gain", rightKI);
		SmartDashboard.putNumber("Right D Gain", rightKD);
		//SmartDashboard.putNumber("I Zone", kIz);
		SmartDashboard.putNumber("Right Feed Forward", rightKFF);

		SmartDashboard.putNumber("Max Output", kMaxOutput);
		SmartDashboard.putNumber("Min Output", kMinOutput);*/

		//SmartDashboard.putNumber("Left SetPoint", leftSetPoint);
		SmartDashboard.putNumber("Left Velocity", (RobotMap.leftClimberEncoder.getVelocity()/REV_PER_DEG)/60.0);

		//SmartDashboard.putNumber("Right SetPoint", rightSetPoint);
		SmartDashboard.putNumber("Right Velocity", (RobotMap.rightClimberEncoder.getVelocity()/REV_PER_DEG)/60.0);

		RobotMap.leftClimber.burnFlash();
		RobotMap.rightClimber.burnFlash();
	}

	public void initDefaultCommand() {
	}

	@SuppressWarnings("Duplicates")
	public void climberDashboard() {
		/*double leftP = SmartDashboard.getNumber("Left P Gain", 0);
		double leftI = SmartDashboard.getNumber("Left I Gain", 0);
		double leftD = SmartDashboard.getNumber("Left D Gain", 0);
		//double leftIz = SmartDashboard.getNumber("Left I Zone", 0);
		double leftFf = SmartDashboard.getNumber("Left Feed Forward", 0);
		double leftSp = SmartDashboard.getNumber("Left SetPoint", 0);

		double rightP = SmartDashboard.getNumber("Right P Gain", 0);
		double rightI = SmartDashboard.getNumber("Right I Gain", 0);
		double rightD = SmartDashboard.getNumber("Right D Gain", 0);
		//double rightIz = SmartDashboard.getNumber("Right I Zone", 0);
		double rightFf = SmartDashboard.getNumber("Right Feed Forward", 0);
		double rightSp = SmartDashboard.getNumber("Right SetPoint", 0);

		double max = SmartDashboard.getNumber("Max Output", 0);
		double min = SmartDashboard.getNumber("Min Output", 0);*/

		SmartDashboard.putNumber("Left Velocity", (RobotMap.leftClimberEncoder.getVelocity()/REV_PER_DEG)/60.0);
		SmartDashboard.putNumber("Right Velocity", (RobotMap.rightClimberEncoder.getVelocity()/REV_PER_DEG)/60.0);

		// if PID coefficients on SmartDashboard have changed, write new values to controller
		/*if ((leftP != leftKP)) {
			leftClimberPIDController.setP(leftP);
			leftKP = leftP;
		}
		if ((leftI != leftKI)) {
			leftClimberPIDController.setI(leftI);
			leftKI = leftI;
		}
		if ((leftD != leftKD)) {
			leftClimberPIDController.setD(leftD);
			leftKD = leftD;
		}
		//if((leftIz != leftKIz)) { leftClimberPIDController.setIZone(leftIz); leftKIz = leftIz; }
		if ((leftFf != leftKFF)) {
			leftClimberPIDController.setFF(leftFf);
			leftKFF = leftFf;
		}
		
		/*if (leftSp != leftSetPoint) {
			leftClimberPIDController.setReference(leftSp*REV_PER_DEG*60.0, ControlType.kVelocity);
			leftSetPoint = leftSp;
		}*/
		
		
		/*if ((max != kMaxOutput) || (min != kMinOutput)) {
			leftClimberPIDController.setOutputRange(min, max);
			kMinOutput = min;
			kMaxOutput = max;
		}

		if((rightP != rightKP)) { rightClimberPIDController.setP(rightP); rightKP = rightP; }
		if((rightI != rightKI)) { rightClimberPIDController.setI(rightI); rightKI = rightI; }
		if((rightD != rightKD)) { rightClimberPIDController.setD(rightD); rightKD = rightD; }
		//if((rightIz != rightKIz)) { rightClimberPIDController.setIZone(rightIz); rightKIz = rightIz; }
		if((rightFf != rightKFF)) { rightClimberPIDController.setFF(rightFf); rightKFF = rightFf; }*/

		/*if (rightSp != rightSetPoint) {
			rightClimberPIDController.setReference(rightSp*REV_PER_DEG*60.0, ControlType.kVelocity);
			rightSetPoint = rightSp;
		}*/

		/*if((max != kMaxOutput) || (min != kMinOutput)) {
			rightClimberPIDController.setOutputRange(min, max);
			kMinOutput = min; kMaxOutput = max;
		}*/
		
	}

	public void setLeftSpeed(double speed) {
		leftClimberPIDController.setReference(speed*REV_PER_DEG*60.0, ControlType.kVelocity);
	}

	public void setRightSpeed(double speed) {
		rightClimberPIDController.setReference(speed*REV_PER_DEG*60.0, ControlType.kVelocity);
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

	// Set to current position
	public void disableLeftPID() {
		leftClimberPIDController.setReference(0, ControlType.kVelocity);
	}

	public void disableRightPID() {
		rightClimberPIDController.setReference(0, ControlType.kVelocity);
	}

	public void moveBottomWheels(double speed) {
		RobotMap.climberWheels.set(speed);
	}

	public void stopPistons() {
		RobotMap.climberSolenoids.set(DoubleSolenoid.Value.kOff);
	}

	public boolean isLeftLimitPressed() {
		return !RobotMap.leftLimitSwitch.get();
	}

	public boolean isRightLimitPressed() {
		return !RobotMap.rightLimitSwitch.get();
	}
}