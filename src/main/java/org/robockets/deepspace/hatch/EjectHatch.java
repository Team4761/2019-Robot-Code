package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class EjectHatch extends CommandGroup {

	public EjectHatch() {
		addSequential(new SetFinger(DoubleSolenoid.Value.kReverse));
		addSequential(new WaitCommand(0.1));
		addSequential(new SetPusher(DoubleSolenoid.Value.kForward));
		addSequential(new WaitCommand(0.2));
		addSequential(new SetPusher(DoubleSolenoid.Value.kReverse));
	}
}