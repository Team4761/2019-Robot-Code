package org.robockets.deepspace.drivetrain;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.robockets.deepspace.Robot;
import org.robockets.deepspace.RobotMap;
import org.robockets.deepspace.pidoutputs.GyroPIDOutput;
import org.robockets.deepspace.pidsources.DoubleEncoderPIDSource;
import org.robockets.deepspace.pidsources.EncoderPIDSource;

public class Drivetrain extends Subsystem {

	private final double INCHES_PER_TICK = 1.0; // TODO: Get an actual value
	
	private PIDController leftPodPIDController;
	private PIDController rightPodPIDController;

	private GyroPIDOutput gyroPIDOutput;
	private PIDController gyroPIDController;

	DoubleEncoderPIDSource leftPIDSource;
	DoubleEncoderPIDSource rightPIDSource;

	public NetworkTable chickenVisionTable;

	public static final double TRANSLATE_MULTIPLIER = 0.85;
	public static final double ROTATE_MULTIPLIER = 0.85;

	public Drivetrain() {
		/*leftPIDSource = new DoubleEncoderPIDSource(RobotMap.frontLeftEncoder, RobotMap.backLeftEncoder, INCHES_PER_TICK);
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
		rightPodPIDController.setOutputRange(-1.0, 1.0);*/

		gyroPIDOutput = new GyroPIDOutput(RobotMap.robotDrive);

		gyroPIDController = new PIDController(0, 0, 0, RobotMap.gyro, gyroPIDOutput);

		gyroPIDController.disable();
		gyroPIDController.setAbsoluteTolerance(5);
		gyroPIDController.setOutputRange(-1.0, 1.0);

		chickenVisionTable = Robot.ntInst.getTable("ChickenVision");

		/*SmartDashboard.putData(leftPodPIDController);
		SmartDashboard.putData(rightPodPIDController);*/
		gyroPIDController.setName("Gyro PID");
		SmartDashboard.putData(gyroPIDController);

	}

	public void initDefaultCommand() {
		setDefaultCommand(new Joyride());
	}

	public void setGyroAssistMode(boolean isAssisted) {
		gyroPIDOutput.setAssistMode(isAssisted);
	}

	public boolean getGyroAssistMode() {
		return gyroPIDOutput.getAssistMode();
	}

	public double getGyroPIDOutput() {
		return gyroPIDController.get();
	}

	public void setGyroSetpoint(double angle) {
		gyroPIDController.setSetpoint(angle);
	}

	public void enableGyroPID() {
		gyroPIDController.enable();
	}

	public void disableGyroPID() {
		gyroPIDController.disable();
	}

	public boolean isGyroOnTarget() {
		return gyroPIDController.onTarget();
	}

	public void startVisionControl(boolean isTape) {

		if (isTape) {
			chickenVisionTable.getEntry("Tape").setBoolean(true);
		} else {
			chickenVisionTable.getEntry("Cargo").setBoolean(true);
		}
	}

	public void stopVisionControl() {
		chickenVisionTable.getEntry("Tape").setBoolean(false);
		chickenVisionTable.getEntry("Cargo").setBoolean(false);
	}

	public boolean canSeeTape() {
		return chickenVisionTable.getEntry("tapeDetected").getBoolean(false);
	}

	public double getTapeAngle() {
		return chickenVisionTable.getEntry("tapeYaw").getDouble(0);
	}

	/**
	 *
	 * @param distance Distance in inches
	 */
	public void setRelativePosition(double distance) {
		//leftPodPIDController.setSetpoint(leftPIDSource.pidGet() + distance);
		//rightPodPIDController.setSetpoint(rightPIDSource.pidGet() + distance);
	}

	public void enableTranslatePID() {
		//leftPodPIDController.enable();
		//rightPodPIDController.enable();
	}

	public void disableTranslatePID() {
		//leftPodPIDController.disable();
		//rightPodPIDController.disable();
	}

	public boolean isTranslateFinished() {
		//return leftPodPIDController.onTarget() && rightPodPIDController.onTarget();
		return true;
	}

	public void driveArcade(double translate, double rotate) {
		RobotMap.robotDrive.arcadeDrive(translate, rotate);
	}


}