package org.robockets.deepspace.vision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.robockets.deepspace.cargo.*;
import org.robockets.deepspace.hatch.*;

public class AutoCommands extends CommandGroup {

    public void AutoGrabHatch() {
        addSequential(new MoveToLine());
        addSequential(new GrabHatch());
    }

    public void AutoEjectHatch() {
        addSequential(new MoveToLine());
        addSequential(new EjectHatch());
    }

    public void AutoGrabCargo() {
        addSequential(new MoveToLine());
        addSequential(new GrabCargo());
    }

    /*public void AutoEjectCargo() {
        addSequential(new MoveToLine());
        addSequential(new RunCargoIntake()); //UNSURE ABOUT THIS ONE
    }*/

}