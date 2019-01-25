/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.org.robockets.deepspace.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.org.robockets.deepspace.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ClimberSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void moveLeftArmForward() {
        //set speed of left climber
        RobotMap.leftClimber.set(0.5);
    }

    public void moveRightArmForward() {
        //set speed of right climber
        RobotMap.rightClimber.set(0.5);
    }

    public void moveLeftArmBackward() {
        //set speed of left climber in reverse
        RobotMap.leftClimber.set(-0.5);
    }

    public void moveRightArmBackward() {
        //set speed of left climber in reverse
        RobotMap.rightClimber.set(-0.5);
    }

    public void moveClimberSolenoidUp() {
        //Move Robot upwards
        RobotMap.climberSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void moveClimberSolenoidDown() {
        //Move Robot Downwards
        RobotMap.climberSolenoid.set(DoubleSolenoid.Value.kReverse);
    }



    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
