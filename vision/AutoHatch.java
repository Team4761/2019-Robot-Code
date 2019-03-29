package org.robockets.deepspace.vision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.robockets.deepspace.hatch.*;

public class AutoHatch extends CommandGroup {

    public void AutoGrabHatch() {
        addSequential(new MoveToLine());
        addSequential(new GrabHatch());
    }

    public void AutoEjectHatch() {
        addSequential(new MoveToLine());
        addSequential(new EjectHatch());
    }
}
