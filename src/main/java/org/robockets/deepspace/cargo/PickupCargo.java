package org.robockets.deepspace.cargo;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickupCargo extends CommandGroup {

	public PickupCargo() {
		addSequential(new SetCargoPos(CargoPos.PICKUP));
		addSequential(new GrabCargo());
	}
}