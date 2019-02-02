/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.robockets.deepspace;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;


	// Drivetrain
	public static CANSparkMax frontLeftMotorController = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax backleftMotorController = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax frontRightMotorController = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax backRightMotorController = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);

	public static SpeedControllerGroup left = new SpeedControllerGroup(frontLeftMotorController, backleftMotorController);
	public static SpeedControllerGroup right = new SpeedControllerGroup(frontRightMotorController, backRightMotorController);
	public static DifferentialDrive robotDrive = new DifferentialDrive(left, right);

	public static CANEncoder frontLeftEncoder = frontLeftMotorController.getEncoder();
	public static CANEncoder backLeftEncoder = backleftMotorController.getEncoder();
	public static CANEncoder frontRightEncoder = frontRightMotorController.getEncoder();
	public static CANEncoder backRightEncoder = backRightMotorController.getEncoder();

	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();


	// Climber

	public static CANSparkMax leftClimber = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax rightClimber = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);

	public static SpeedControllerGroup climberMotors = new SpeedControllerGroup(leftClimber, rightClimber);

	public static CANEncoder leftClimberEncoder = leftClimber.getEncoder();
	public static CANEncoder rightClimberEncoder = rightClimber.getEncoder();

	public static Victor climberWheels = new Victor(6);

	public static DoubleSolenoid climberSolenoids = new DoubleSolenoid(0, 1);


	// Hatch

	public static DoubleSolenoid outerPusher = new DoubleSolenoid(2,3);
	public static DoubleSolenoid middlePusher = new DoubleSolenoid(4, 5);
}
