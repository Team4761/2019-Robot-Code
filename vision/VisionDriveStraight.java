package org.robockets.deepspace.vision;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class VisionDriveStraight extends Command {

    private double CameraToInch = 0.0;

    /**
     * When the robot is aligned with the line,
     * the length of the line in this position is not measured in a standard unit.
     * Camera To Inch will convert this to Inches.
     * TODO: FIND THIS NUMBER BY DIVIDING THE DEFAULT LINE POS BY THE ACTUAL LINE LENGTH!!!
     */

    public VisionDriveStraight() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
        double distance = Robot.WidthEntry.getDouble(0.0);

        Robot.drivetrain.setRelativePosition(distance);
        Robot.drivetrain.enableTranslatePID();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Robot.drivetrain.isTranslateFinished();
    }

    protected void end() {
        Robot.drivetrain.disableTranslatePID();
    }

    protected void interrupted() {
        end();
    }
}