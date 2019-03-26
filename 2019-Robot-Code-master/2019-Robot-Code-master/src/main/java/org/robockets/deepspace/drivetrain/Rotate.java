package org.robockets.deepspace.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class Rotate extends Command{

    private double angle;

    public Rotate(double angle) {
        requires(Robot.drivetrain);
        this.angle = angle;
    }

    protected void initialize() {
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
