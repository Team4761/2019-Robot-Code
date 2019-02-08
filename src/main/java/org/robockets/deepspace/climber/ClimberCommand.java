package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimberCommand extends CommandGroup {
    public ClimberCommand(){
        addSequential(new Climb());



    }

}
