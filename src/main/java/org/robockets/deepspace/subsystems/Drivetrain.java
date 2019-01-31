package org.robockets.deepspace.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;

public class Drivetrain extends Subsystem {


	public void initDefaultCommand() {
	}

	public void driveArcade(double translate, double rotate) {
		RobotMap.robotDrive.arcadeDrive(translate, rotate);
	}


}