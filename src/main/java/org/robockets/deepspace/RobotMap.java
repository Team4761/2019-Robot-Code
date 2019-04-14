/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.robockets.deepspace;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

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

    public static CANSparkMax leftClimber = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);
    public static CANSparkMax rightClimber = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);

    public static SpeedControllerGroup climberMotors = new SpeedControllerGroup(leftClimber, rightClimber);

    public static CANEncoder leftClimberEncoder = leftClimber.getEncoder();
    public static CANEncoder rightClimberEncoder = rightClimber.getEncoder();

    public static CANSparkMax climberWheels = new CANSparkMax(6, CANSparkMaxLowLevel.MotorType.kBrushed);

    public static DoubleSolenoid rightClimberSolenoids = new DoubleSolenoid(1,4, 5);

    public static DoubleSolenoid leftClimberSolenoids = new DoubleSolenoid(0, 7,6);

    public static DigitalInput leftLimitSwitch = new DigitalInput(2);
    public static DigitalInput rightLimitSwitch = new DigitalInput(3);

    // Hatch

    public static DoubleSolenoid pusher = new DoubleSolenoid(1,0,1);
    public static DoubleSolenoid finger = new DoubleSolenoid(1,2, 3);

    public static DigitalInput hatchLimitSwitch = new DigitalInput(4);

    // Cargo

    public static CANSparkMax cargoArmMotor = new CANSparkMax(7, CANSparkMaxLowLevel.MotorType.kBrushless);
    //public static WPI_VictorSPX cargoIntakeMotor = new WPI_VictorSPX(7);
    public static CANSparkMax cargoIntakeMotor = new CANSparkMax(8, CANSparkMaxLowLevel.MotorType.kBrushed);
    //public static Victor cargoIntakeMotor = new Victor(2);

    public static CANEncoder cargoEncoder = cargoArmMotor.getEncoder();

    public static DoubleSolenoid cargoSolenoid = new DoubleSolenoid(1,6, 7);

    public static DigitalInput cargoBreakbeam = new DigitalInput(0);

    // Misc
    public static Compressor compressor = new Compressor(1);
    public static AnalogInput pressure1 = new AnalogInput(0);
    public static AnalogInput pressure2 = new AnalogInput(1);

    public static Spark ledStrip = new Spark(1);

}
