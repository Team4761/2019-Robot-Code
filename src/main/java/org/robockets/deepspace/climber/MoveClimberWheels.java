package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class MoveClimberWheels extends Command {

    double speed;
    double time;

    public MoveClimberWheels(double speed, double time) {
        //what exactly does this.*; do again?
        //jake this leaves me brainhurt
        this.time = time;
        this.speed = speed;


    }
    protected void initialize(){
        setTimeout(time);
        
    }

    protected void execute(){
        Robot.climber.moveClimberWheels(speed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
