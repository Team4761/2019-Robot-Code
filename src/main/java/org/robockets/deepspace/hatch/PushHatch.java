package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class PushHatch extends Command {

    protected void initialize() {
        Robot.hatch.setPiston(DoubleSolenoid.Value.kForward);
        setTimeout(1);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        Robot.hatch.setPiston(DoubleSolenoid.Value.kReverse);
    }

    protected void interrupted() {
        end();
    }
}
