package org.robockets.deepspace.vision;

import org.robockets.deepspace.drivetrain.Rotate;
import org.robockets.deepspace.drivetrain.DriveStraight;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class MoveToLine extends CommandGroup{

    private static NetworkTable visionTable;

    private double Width  = visionTable.getEntry("ViewedWidth").getDouble(0.0);
    private double Angle = visionTable.getEntry("Angle").getDouble(0.0);

    private double ActualWidth = 3.5; //Inches
    private double actuallength = 18.0; //Inches
    private double CameraToInch = 0.0;

    /**
     * When the robot is aligned with the line,
     * the length of the line in this position is not measured in a standard unit.
     * Camera To Inch will convert this to Inches.
     * TODO: FIND THIS NUMBER BY DIVIDING THE DEFAULT LINE POS BY THE ACTUAL LINE LENGTH!!!
     */

    /*private double LineCenterX = 0.0; //We are using the "ActualWidth" Coords.
    private double LineCenterY = 0.0; //you Can offset these points if necessary.
    private double CenterAngle = Math.atan2(LineCenterY, LineCenterX);
    */

    //TODO: NUMBERS ABOVE ARE ARBITRARY!!! FIND THE ACTUAL NUMBERS!!!!

    public MoveToLine() {
        addSequential(new Rotate(-Angle));
        addSequential(new DriveStraight(Width/ActualWidth));
        addSequential(new Rotate(Angle));
        //addSequential(new DriveStraight());
    }


}
