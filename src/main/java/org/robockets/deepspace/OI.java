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
	// Driver
	public static Joystick joystick = new Joystick(0);

	public static JoystickButton aButton = new JoystickButton(joystick, 1);
	public static JoystickButton bButton = new JoystickButton(joystick, 2);
	public static JoystickButton xButton = new JoystickButton(joystick, 3);
	public static JoystickButton yButton = new JoystickButton(joystick, 4);

	public static JoystickButton leftBumper = new JoystickButton(joystick, 5);
	public static JoystickButton rightBumper = new JoystickButton(joystick, 6);


	// Operator 1
	public static Joystick buttonBoard1 = new Joystick(1);

	public static JoystickButton button101 = new JoystickButton(buttonBoard1, 1); // TODO: Change my name
	public static JoystickButton button102 = new JoystickButton(buttonBoard1, 2);
	public static JoystickButton button103 = new JoystickButton(buttonBoard1, 3);
	public static JoystickButton button104 = new JoystickButton(buttonBoard1, 4);
	public static JoystickButton button105 = new JoystickButton(buttonBoard1, 5);
	public static JoystickButton button106 = new JoystickButton(buttonBoard1, 6);
	public static JoystickButton button107 = new JoystickButton(buttonBoard1, 7);
	public static JoystickButton button108 = new JoystickButton(buttonBoard1, 8);
	public static JoystickButton button109 = new JoystickButton(buttonBoard1, 9);
	public static JoystickButton button110 = new JoystickButton(buttonBoard1, 10);
	public static JoystickButton button111 = new JoystickButton(buttonBoard1, 11);
	public static JoystickButton button112 = new JoystickButton(buttonBoard1, 12);
	public static JoystickButton button113 = new JoystickButton(buttonBoard1, 13);
	public static JoystickButton button114 = new JoystickButton(buttonBoard1, 14);
	public static JoystickButton button115 = new JoystickButton(buttonBoard1, 15);
	public static JoystickButton button116 = new JoystickButton(buttonBoard1, 16);
	public static JoystickButton button117 = new JoystickButton(buttonBoard1, 17);
	public static JoystickButton button118 = new JoystickButton(buttonBoard1, 18);
	public static JoystickButton button119 = new JoystickButton(buttonBoard1, 19);
	public static JoystickButton button120 = new JoystickButton(buttonBoard1, 20);

	// Operator 2
	public static Joystick buttonBoard2 = new Joystick(2);

	public static JoystickButton button201 = new JoystickButton(buttonBoard2, 1); // TODO: Change my name
	public static JoystickButton button202 = new JoystickButton(buttonBoard2, 2);
	public static JoystickButton button203 = new JoystickButton(buttonBoard2, 3);
	public static JoystickButton button204 = new JoystickButton(buttonBoard2, 4);
	public static JoystickButton button205 = new JoystickButton(buttonBoard2, 5);
	public static JoystickButton button206 = new JoystickButton(buttonBoard2, 6);
	public static JoystickButton button207 = new JoystickButton(buttonBoard2, 7);
	public static JoystickButton button208 = new JoystickButton(buttonBoard2, 8);
	public static JoystickButton button209 = new JoystickButton(buttonBoard2, 9);
	public static JoystickButton button210 = new JoystickButton(buttonBoard2, 10);
	public static JoystickButton button211 = new JoystickButton(buttonBoard2, 11);
	public static JoystickButton button212 = new JoystickButton(buttonBoard2, 12);
	public static JoystickButton button213 = new JoystickButton(buttonBoard2, 13);
	public static JoystickButton button214 = new JoystickButton(buttonBoard2, 14);
	public static JoystickButton button215 = new JoystickButton(buttonBoard2, 15);
	public static JoystickButton button216 = new JoystickButton(buttonBoard2, 16);
	public static JoystickButton button217 = new JoystickButton(buttonBoard2, 17);
	public static JoystickButton button218 = new JoystickButton(buttonBoard2, 18);
	public static JoystickButton button219 = new JoystickButton(buttonBoard2, 19);
	public static JoystickButton button220 = new JoystickButton(buttonBoard2, 20);


	public OI() {
		//aButton.whileHeld(new MoveArms());
		/*bButton.whenPressed(new RetractPistons());
		xButton.whenPressed(new ExtendPistons());
		yButton.whenPressed(new ToggleCompressor());*/
		aButton.whenPressed(new SetHatch(DoubleSolenoid.Value.kReverse, DoubleSolenoid.Value.kReverse));
		bButton.whenPressed(new SetHatch(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kReverse));
		xButton.whenPressed(new SetHatch(DoubleSolenoid.Value.kReverse, DoubleSolenoid.Value.kForward));
		yButton.whenPressed(new SetHatch(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kForward));
		//rightBumper.whenPressed(new ToggleCompressor());

		/*leftBumper.whileHeld(new MoveArms(-1.0));
		rightBumper.whileHeld(new MoveArms(1.0));*/

	}
}
