package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.robockets.deepspace.Robot;
import org.robockets.deepspace.drivetrain.DriveStraight;
import org.robockets.deepspace.drivetrain.DriveTimed;

public class Climb extends CommandGroup {

	public Climb() {
		addParallel(new ExtendPistons());
		addParallel(new MoveBottomWheels(0.5, 10));
		addSequential(new MoveArmsFixed(4, 100)); // This goes until it is almost cleared
		addParallel(new RetractPistons());
		addParallel(new DriveTimed(0.75, 5));
	}
}