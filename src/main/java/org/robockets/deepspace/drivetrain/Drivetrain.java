package org.robockets.deepspace.drivetrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.robockets.deepspace.RobotMap;
import org.robockets.deepspace.pidoutputs.GyroPIDOutput;
import org.robockets.deepspace.pidsources.DoubleEncoderPIDSource;
import org.robockets.deepspace.pidsources.EncoderPIDSource;

public class Drivetrain extends Subsystem {

	private final double INCHES_PER_TICK = 1.0; // TODO: Get an actual value
	
	private PIDController leftPodPIDController;
	private PIDController rightPodPIDController;

	private PIDController gyroPIDController;

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

		gyroPIDController = new PIDController(0, 0, 0, RobotMap.gyro, new GyroPIDOutput());

		gyroPIDController.disable();
		gyroPIDController.setAbsoluteTolerance(5);
		gyroPIDController.setOutputRange(-1.0, 1.0);

		SmartDashboard.putData(leftPodPIDController);
		SmartDashboard.putData(rightPodPIDController);
		SmartDashboard.putData(gyroPIDController);
	}

	public void initDefaultCommand() {
	}

	public void driveArcade(double translate, double rotate) {
		RobotMap.robotDrive.arcadeDrive(translate, rotate);
	}


}