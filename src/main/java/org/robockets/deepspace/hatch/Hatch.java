package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;

public class Hatch extends Subsystem {


	public void initDefaultCommand() {
	}


	public void setPusher(DoubleSolenoid.Value value) {
		RobotMap.pusher.set(value);
	}

	public void setFinger(DoubleSolenoid.Value value) {
		RobotMap.finger.set(value);
	}
}