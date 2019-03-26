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

	DoubleEncoderPIDSource leftPIDSource;
	DoubleEncoderPIDSource rightPIDSource;

	public Drivetrain() {
		leftPIDSource = new DoubleEncoderPIDSource(RobotMap.frontLeftEncoder, RobotMap.backLeftEncoder, INCHES_PER_TICK);
		rightPIDSource = new DoubleEncoderPIDSource(RobotMap.frontRightEncoder, RobotMap.backRightEncoder, INCHES_PER_TICK);

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

		/*SmartDashboard.putData(leftPodPIDController);
		SmartDashboard.putData(rightPodPIDController);
		SmartDashboard.putData(gyroPIDController);*/
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Joyride());
	}

	/**
	 * @param distance Distance in inches
	 */
	public void setRelativePosition(double distance) {
		leftPodPIDController.setSetpoint(leftPIDSource.pidGet() + distance);
		rightPodPIDController.setSetpoint(rightPIDSource.pidGet() + distance);
	}

	public void setRelativeAngle(double angle) {
		gyroPIDController.setSetpoint(RobotMap.gyro.getAngle() + angle);
	}

	public void enableTranslatePID() {
		leftPodPIDController.enable();
		rightPodPIDController.enable();
	}

	public void disableTranslatePID() {
		leftPodPIDController.disable();
		rightPodPIDController.disable();
	}

	public void enableRotate() {
		gyroPIDController.enable();
	}

	public void disableRotate() {
		gyroPIDController.disable();
	}

	public boolean isTranslateFinished() {
		return leftPodPIDController.onTarget() && rightPodPIDController.onTarget();
	}

	public boolean isRotateFinished() {
		return gyroPIDController.onTarget()	;
	}

	public void driveArcade(double translate, double rotate) {
		RobotMap.robotDrive.arcadeDrive(translate, rotate);
	}


}