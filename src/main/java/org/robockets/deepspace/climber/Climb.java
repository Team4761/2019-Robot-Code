package org.robockets.deepspace.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class Climb extends Command {

    int loopCounter = 0;

    protected void initialize() {
        Robot.climber.moveClimberSolenoid(DoubleSolenoid.Value.kForward);
        setTimeout(3);

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (loopCounter <= 25){
            Robot.climber.moveClimberArms(0.5);
            Robot.climber.moveClimberSolenoid(DoubleSolenoid.Value.kForward);
            loopCounter++;

        }


    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}