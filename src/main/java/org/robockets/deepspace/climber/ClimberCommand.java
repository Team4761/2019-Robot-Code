package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimberCommand extends CommandGroup {
    public ClimberCommand(){

        //add sequence of events and times in here!!!!!!!
        addSequential(new Climb());
        addSequential(new MoveClimberWheels(0.5,0.5 /*Change these because there placeholders*/));



    }

}
