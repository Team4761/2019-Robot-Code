package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;

public class Hatch extends Subsystem {
    @Override
    protected void initDefaultCommand() {

    }

    public void setPiston (DoubleSolenoid.Value value) {
        RobotMap.hatchPusher.set(value);
    }
}
