package org.robockets.deepspace.vision;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class VisionRotate extends Command{


    public VisionRotate() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
        double angle = Robot.AngleEntry.getDouble(0.0);
        Robot.drivetrain.setRelativeAngle(angle);
        Robot.drivetrain.enableRotate();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Robot.drivetrain.isRotateFinished();
    }

    protected void end() {
        Robot.drivetrain.disableRotate();
    }

    protected void interrupted() {
        end();
    }
}
