/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.robockets.deepspace;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.robockets.deepspace.climber.MoveArms;
import org.robockets.deepspace.climber.ExtendPistons;
import org.robockets.deepspace.climber.MoveBottomWheels;
import org.robockets.deepspace.climber.RetractPistons;
import org.robockets.deepspace.hatch.SetHatch;
import org.robockets.deepspace.misccommands.ToggleCompressor;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick joystick = new Joystick(0);

	public static JoystickButton aButton = new JoystickButton(joystick, 1);
	public static JoystickButton bButton = new JoystickButton(joystick, 2);
	public static JoystickButton xButton = new JoystickButton(joystick, 3);
	public static JoystickButton yButton = new JoystickButton(joystick, 4);

	public static JoystickButton leftBumper = new JoystickButton(joystick, 5);
	public static JoystickButton rightBumper = new JoystickButton(joystick, 6);

	public OI() {
		//aButton.whileHeld(new MoveArms());
		/*bButton.whenPressed(new RetractPistons());
		xButton.whenPressed(new ExtendPistons());
		yButton.whenPressed(new ToggleCompressor());*/
		aButton.whenPressed(new SetHatch(DoubleSolenoid.Value.kReverse, DoubleSolenoid.Value.kReverse));
		bButton.whenPressed(new SetHatch(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kReverse));
		xButton.whenPressed(new SetHatch(DoubleSolenoid.Value.kReverse, DoubleSolenoid.Value.kForward));
		yButton.whenPressed(new SetHatch(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kForward));
		rightBumper.whenPressed(new ToggleCompressor());

		/*leftBumper.whileHeld(new MoveArms(-1.0));
		rightBumper.whileHeld(new MoveArms(1.0));*/

	}
}
