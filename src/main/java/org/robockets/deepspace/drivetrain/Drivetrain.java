package org.robockets.deepspace.drivetrain;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;


public class Drivetrain extends Subsystem {
    @Override
    protected void initDefaultCommand() {

    }

    public void driveArcade(double translate, double rotate) {
        RobotMap.robotDrive.arcadeDrive(translate, rotate);
    }


}