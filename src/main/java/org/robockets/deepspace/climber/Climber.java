/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.robockets.deepspace.climber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Climber extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void moveClimberArms(double speed){
        RobotMap.leftClimberArm.set(speed);
        RobotMap.rightClimberArm.set(speed);

    }

    public void moveClimberSolenoid(DoubleSolenoid.Value value) {
        //Move Robot Downwards
        RobotMap.climberSolenoid.set(value);
    }

    public void moveClimberWheels(double speed){
        RobotMap.smallClimberWheelThingy.set(speed);
    }


    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());



    }
}
