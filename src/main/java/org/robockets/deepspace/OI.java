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
import org.robockets.deepspace.cargo.*;
import org.robockets.deepspace.climber.*;
import org.robockets.deepspace.drivetrain.Joyride;
import org.robockets.deepspace.drivetrain.VisionAssistedControl;
import org.robockets.deepspace.hatch.*;

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

	public static JoystickButton selectButton = new JoystickButton(joystick, 7);
	public static JoystickButton startButton = new JoystickButton(joystick, 8);

	// Operator 1
	public static Joystick buttonBoard1 = new Joystick(1);

	public static JoystickButton button101 = new JoystickButton(buttonBoard1, 1);
	public static JoystickButton button102 = new JoystickButton(buttonBoard1, 2); // Cargo Low
	public static JoystickButton button103 = new JoystickButton(buttonBoard1, 3); // Hatch all out
	public static JoystickButton button104 = new JoystickButton(buttonBoard1, 4); // Cargo shoot
	public static JoystickButton button105 = new JoystickButton(buttonBoard1, 5); // Cargo Wheels Forward
	public static JoystickButton button106 = new JoystickButton(buttonBoard1, 6); // Cargo Intake
	public static JoystickButton button107 = new JoystickButton(buttonBoard1, 7);
	public static JoystickButton button108 = new JoystickButton(buttonBoard1, 8); // Cargo Ship
	public static JoystickButton button109 = new JoystickButton(buttonBoard1, 9); // Cargo out
	public static JoystickButton button110 = new JoystickButton(buttonBoard1, 10); // Hatch Start
	public static JoystickButton button111 = new JoystickButton(buttonBoard1, 11); // Hatch Release
	public static JoystickButton button112 = new JoystickButton(buttonBoard1, 12); // Hatch pickup
	public static JoystickButton button113 = new JoystickButton(buttonBoard1, 13); //+
	public static JoystickButton button114 = new JoystickButton(buttonBoard1, 14);
	public static JoystickButton button115 = new JoystickButton(buttonBoard1, 15);
	public static JoystickButton button116 = new JoystickButton(buttonBoard1, 16);
	public static JoystickButton button117 = new JoystickButton(buttonBoard1, 17);
	public static JoystickButton button118 = new JoystickButton(buttonBoard1, 18);
	public static JoystickButton button119 = new JoystickButton(buttonBoard1, 19); // Set climber left
	public static JoystickButton button120 = new JoystickButton(buttonBoard1, 20); // Set climber right
	public static JoystickButton button121 = new JoystickButton(buttonBoard1, 21);
	public static JoystickButton button122 = new JoystickButton(buttonBoard1, 22); // Cargo Ground
	public static JoystickButton button123 = new JoystickButton(buttonBoard1, 23);

	// Operator 2
	public static Joystick buttonBoard2 = new Joystick(2);

	public static JoystickButton button201 = new JoystickButton(buttonBoard2, 1);
	public static JoystickButton button202 = new JoystickButton(buttonBoard2, 2); // Intake Backward
	public static JoystickButton button203 = new JoystickButton(buttonBoard2, 3); // Intake Forward
	public static JoystickButton button204 = new JoystickButton(buttonBoard2, 4); // Climbing Wheels Forward > Other Piston Forward
	public static JoystickButton button205 = new JoystickButton(buttonBoard2, 5); // Climbing Piston Down
	public static JoystickButton button206 = new JoystickButton(buttonBoard2, 6);
	public static JoystickButton button207 = new JoystickButton(buttonBoard2, 7); // Inner Pistons Close
	public static JoystickButton button208 = new JoystickButton(buttonBoard2, 8); // Climbing Arms Down
	public static JoystickButton button209 = new JoystickButton(buttonBoard2, 9); // Outer Pistons Close
	public static JoystickButton button210 = new JoystickButton(buttonBoard2, 10); // Climbing Piston Up
	public static JoystickButton button211 = new JoystickButton(buttonBoard2, 11); // Climbing Arms Up
	public static JoystickButton button212 = new JoystickButton(buttonBoard2, 12); // Inner Pistons Open
	public static JoystickButton button213 = new JoystickButton(buttonBoard2, 13); // Outer Pistons Open
	public static JoystickButton button214 = new JoystickButton(buttonBoard2, 14);
	public static JoystickButton button215 = new JoystickButton(buttonBoard2, 15);
	public static JoystickButton button216 = new JoystickButton(buttonBoard2, 16);
	public static JoystickButton button217 = new JoystickButton(buttonBoard2, 17);
	public static JoystickButton button218 = new JoystickButton(buttonBoard2, 18); // Cargo Piston Up
	public static JoystickButton button219 = new JoystickButton(buttonBoard2, 19);
	public static JoystickButton button220 = new JoystickButton(buttonBoard2, 20); // Cargo Piston Down
	public static JoystickButton button221 = new JoystickButton(buttonBoard2, 21); // Climbing Wheels Backward > Other Piston Backward
	public static JoystickButton button222 = new JoystickButton(buttonBoard2, 22); // Arm Backward
	public static JoystickButton button223 = new JoystickButton(buttonBoard2, 23); // Arm Forward


	public OI() {
		//aButton.whileHeld(new MoveArms());
		/*bButton.whenPressed(new RetractPistons());
		xButton.whenPressed(new ExtendPistons());*/
		//yButton.whenPressed(new ToggleCompressor());
		bButton.whenPressed(new EjectHatch());
		//bButton.whenPressed(new SetHatch(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kReverse));
		//xButton.whenPressed(new SetHatch(DoubleSolenoid.Value.kReverse, DoubleSolenoid.Value.kForward));
		//yButton.whenPressed(new Joyride());
		//rightBumper.whenPressed(new ToggleCompressor());
		//leftBumper.whileHeld(new RunBottomWheelsManual(0.75));
		//leftBumper.whenPressed(new Climb());
		//yButton.whenPressed(new ToggleCargoDirection());
		//xButton.whenPressed(new ExtendPistons());
		//bButton.whenPressed(new RetractPistons());
		//selectButton.whileHeld(new RunBottomWheelsManual(0.3));
		//startButton.whenPressed(new ToggleCompressor());

		rightBumper.whileHeld(new VisionAssistedControl(false, true));

		aButton.whenPressed(new SetFinger(DoubleSolenoid.Value.kReverse)); // Grab Hatch

		startButton.whenPressed(new Joyride());

		yButton.whileHeld(new RunCargoIntake(1)); // Eject Cargo

		/*leftBumper.whileHeld(new MoveArms(-1.0));
		rightBumper.whileHeld(new MoveArms(1.0));*/

		// Hatch
		//button103.whenPressed(new SetHatch(DoubleSolenoid.Value.kForward, DoubleSolenoid.Value.kForward)); // All out
		button103.whenPressed(new CenterHatch()); // Center Hatch
		button110.whenPressed(new EjectHatch()); // RELEASE HATCH
		//button112.whenPressed(new SetFinger(DoubleSolenoid.Value.kForward));
		//button112.whenPressed(new SetFinger(DoubleSolenoid.Value.kReverse));
		//button111.whenPressed(new SetPusher(DoubleSolenoid.Value.kReverse));

		button212.whenPressed(new SetPusher(DoubleSolenoid.Value.kForward));
		button207.whenPressed(new SetPusher(DoubleSolenoid.Value.kReverse));

		button213.whenPressed(new SetFinger(DoubleSolenoid.Value.kForward));
		button209.whenPressed(new SetFinger(DoubleSolenoid.Value.kReverse));

		// Cargo
		//button104.whileHeld(new RunCargoIntake(1));
		//button106.whileHeld(new RunCargoIntake(-1));


		button102.whenPressed(new SetCargoPos(CargoPos.CARGO));
		button108.whenPressed(new SetCargoPos(CargoPos.LOW));
		button122.whenPressed(new SetCargoPos(CargoPos.PICKUP));
		button104.whenPressed(new SetCargoPos(CargoPos.BACK));

		button203.whileHeld(new RunCargoIntake(1));
		button202.whileHeld(new RunCargoIntake(-1));

		button223.whileHeld(new MoveCargoArm(0.5));
		button222.whileHeld(new MoveCargoArm(-0.5));

		button218.whenPressed(new SetCargoPiston(DoubleSolenoid.Value.kForward));
		button220.whenPressed(new SetCargoPiston(DoubleSolenoid.Value.kReverse));


		// Climber
		button105.whileHeld(new RunBottomWheelsManual(-.6));

		//button204.whenPressed(new SetLeftSolenoid(DoubleSolenoid.Value.kReverse));
		//button221.whenPressed(new SetLeftSolenoid(DoubleSolenoid.Value.kForward));

		button208.whileHeld(new RunArms(-0.65));
		button211.whileHeld(new RunArms(0.65));

		button205.whenPressed(new ExtendPistons());
		button210.whenPressed(new RetractPistons());

	}
}
