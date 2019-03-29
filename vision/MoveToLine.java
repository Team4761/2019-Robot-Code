package org.robockets.deepspace.vision;

import org.robockets.deepspace.drivetrain.DriveStraight;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveToLine extends CommandGroup{

    private double ActualWidth = 3.5; //Inches
    private double actuallength = 18.0; //Inches

    /*private double LineCenterX = 0.0; //We are using the "ActualWidth" Coords.
    private double LineCenterY = 0.0; //you Can offset these points if necessary.
    private double CenterAngle = Math.atan2(LineCenterY, LineCenterX);
    */

    //TODO: NUMBERS ABOVE ARE ARBITRARY!!! FIND THE ACTUAL NUMBERS!!!!

    public MoveToLine() {
        addSequential(new VisionRotate());
        addSequential(new VisionDriveStraight());
        addSequential(new VisionRotate());
        //addSequential(new DriveStraight());
    }


}
