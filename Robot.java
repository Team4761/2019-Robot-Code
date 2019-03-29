/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.robockets.deepspace;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.robockets.deepspace.cargo.Cargo;
import org.robockets.deepspace.cargo.MoveCargoArm;
import org.robockets.deepspace.cargo.RunCargoIntake;
import org.robockets.deepspace.climber.*;
import org.robockets.deepspace.drivetrain.DriveTimed;
import org.robockets.deepspace.drivetrain.Drivetrain;
import org.robockets.deepspace.drivetrain.Joyride;
import org.robockets.deepspace.hatch.Hatch;
import org.robockets.deepspace.hatch.PressureManager;
import org.robockets.deepspace.misccommands.ToggleCompressor;
import org.robockets.deepspace.subsystemlocks.Triggers;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Drivetrain drivetrain;
  public static Hatch hatch;
  public static Climber climber;
  public static Cargo cargo;
  public static Triggers triggers;
  public static OI m_oi;
  public static NetworkTable visionTable;
  public static NetworkTableEntry AngleEntry;
  public static NetworkTableEntry WidthEntry;

  private static Command joyride;
  private static Command moveArms;
  private static Command pressureManager;
  private static Command bbVelControl;
  private static Command runCargoIntake;
  private static Command moveCargoArm;


  Command startDriveStraight;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    drivetrain = new Drivetrain();
    hatch = new Hatch();
    climber = new Climber();
    cargo = new Cargo();
    triggers = new Triggers();

    joyride = new Joyride();
    moveArms = new MoveArms();
    pressureManager = new PressureManager();
    runCargoIntake = new RunCargoIntake(0.75);
    moveCargoArm = new MoveCargoArm(0);
    startDriveStraight = new DriveTimed(0.4, 4);

    m_oi = new OI();

    NetworkTableInstance ntinst = NetworkTableInstance.getDefault();
    visionTable = ntinst.getTable("VisionTable");
    AngleEntry = visionTable.getEntry("Angle");
    WidthEntry = visionTable.getEntry("ViewedWidth");

    RobotMap.leftClimber.setInverted(true);

    SmartDashboard.putData(new StopPID());
    SmartDashboard.putData(new MoveArmsFixed(12, 1000000));

    /*SmartDashboard.putData(RobotMap.leftClimber);
    SmartDashboard.putData(RobotMap.rightClimber);*/
    //SmartDashboard.putData(RobotMap.climberMotors);
    //SmartDashboard.putData(RobotMap.climberSolenoids);
    //SmartDashboard.putData(new MoveArms(1));
    //SmartDashboard.putData(new RetractPistons());
    SmartDashboard.putData(moveArms);
    SmartDashboard.putData(moveCargoArm);
    SmartDashboard.putData(new ToggleCompressor());


    System.out.println(RobotMap.leftClimber.getFirmwareString());
    System.out.println(RobotMap.rightClimber.getFirmwareString());

    SmartDashboard.putData(new ExtendPistons());
    SmartDashboard.putData(new RetractPistons());

    //CameraServer.getInstance().startAutomaticCapture();

    //SmartDashboard.putNumber("LED Val", 0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Left Climber Deg", RobotMap.leftClimberEncoder.getPosition()/climber.REV_PER_DEG);
    SmartDashboard.putNumber("Right Climber Deg", RobotMap.rightClimberEncoder.getPosition()/climber.REV_PER_DEG);


    SmartDashboard.putNumber("Pressure 1", (RobotMap.pressure1.getValue()-500)/10.0);
    SmartDashboard.putNumber("Pressure 2", (RobotMap.pressure2.getValue()-428)/32.0);

    SmartDashboard.putBoolean("Left Limit", climber.isLeftLimitPressed());
    SmartDashboard.putBoolean("Right Limit", climber.isRightLimitPressed());

    SmartDashboard.putNumber("Raw Cargo", RobotMap.cargoEncoder.getPosition());

    //RobotMap.ledStrip.set(SmartDashboard.getNumber("LED Val", 0));

    SmartDashboard.putBoolean("Has Hatch?", !RobotMap.hatchLimitSwitch.get());
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    //startDriveStraight.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (startDriveStraight != null) {
      startDriveStraight.cancel();
    }
    //joyride.start();
    //moveArms.start();
    //pressureManager.start();
    //bbVelControl.start();
    //runCargoIntake.start();
    //moveCargoArm.start();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    //climber.climberDashboard();
    cargo.cargoPeriodic();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
