package org.robockets.deepspace.cargo;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;

public class Cargo extends Subsystem {


	public void initDefaultCommand() {
	}


	public void setSolenoid(DoubleSolenoid.Value value) {
		RobotMap.cargoSolenoid.set(value);
	}

	public void moveArmMotor(double speed) {
		RobotMap.cargoArmMotor.set(speed);
	}

}