package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.robockets.deepspace.Robot;
import org.robockets.deepspace.drivetrain.DriveStraight;
import org.robockets.deepspace.drivetrain.DriveTimed;

public class Climb extends CommandGroup {

	public Climb() {
		addParallel(new ExtendPistons());
		addParallel(new MoveBottomWheels(0.3, 10, 3));
		addSequential(new MoveArmsFixed(13, 10000)); // This goes until it is almost cleared
	}
}