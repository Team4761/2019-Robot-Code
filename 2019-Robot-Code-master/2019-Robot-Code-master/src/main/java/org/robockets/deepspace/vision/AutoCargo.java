package org.robockets.deepspace.vision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.robockets.deepspace.cargo.*;

public class AutoCargo extends CommandGroup {

    public void AutoGrabCargo() {
        addSequential(new MoveToLine());
        addSequential(new GrabCargo());
    }

    /*public void AutoEjectCargo() {
        addSequential(new MoveToLine());
        addSequential(new RunCargoIntake()); //UNSURE ABOUT THIS ONE
    }*/

}