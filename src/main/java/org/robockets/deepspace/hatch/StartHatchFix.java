package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class StartHatchFix extends CommandGroup {

	public StartHatchFix() {
		addSequential(new SetFinger(DoubleSolenoid.Value.kForward));
		addSequential(new WaitCommand(0.1));
		addSequential(new SetFinger(DoubleSolenoid.Value.kReverse));
	}
}