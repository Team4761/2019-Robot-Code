package org.robockets.deepspace.drivetrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;
import org.robockets.deepspace.pidsources.DoubleEncoderPIDSource;
import org.robockets.deepspace.pidsources.EncoderPIDSource;

public class Drivetrain extends Subsystem {

	private final double INCHES_PER_TICK = 1.0; // TODO: Get an actual value
	
	public PIDController leftPodPIDController;
	public PIDController rightPodPIDController;

	public Drivetrain() {
		DoubleEncoderPIDSource leftPIDSource = new DoubleEncoderPIDSource(RobotMap.frontLeftEncoder, RobotMap.backLeftEncoder, INCHES_PER_TICK);
		DoubleEncoderPIDSource rightPIDSource = new DoubleEncoderPIDSource(RobotMap.frontRightEncoder, RobotMap.backRightEncoder, INCHES_PER_TICK);
		
		leftPIDSource.setPIDSourceType(PIDSourceType.kDisplacement);
		rightPIDSource.setPIDSourceType(PIDSourceType.kDisplacement);
		
		leftPodPIDController = new PIDController(0, 0, 0, leftPIDSource, RobotMap.left);
		rightPodPIDController = new PIDController(0, 0, 0, rightPIDSource, RobotMap.left);
		
		leftPodPIDController.disable();
		leftPodPIDController.setAbsoluteTolerance(5.0);
		leftPodPIDController.setOutputRange(-1.0, 1.0);

		rightPodPIDController.disable();
		rightPodPIDController.setAbsoluteTolerance(5.0);
		rightPodPIDController.setOutputRange(-1.0, 1.0);
	}

	public void initDefaultCommand() {
	}

	public void driveArcade(double translate, double rotate) {
		RobotMap.robotDrive.arcadeDrive(translate, rotate);
	}


}