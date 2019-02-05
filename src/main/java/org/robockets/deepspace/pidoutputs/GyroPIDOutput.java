package org.robockets.deepspace.pidoutputs;

import edu.wpi.first.wpilibj.PIDOutput;
import org.robockets.deepspace.Robot;

public class GyroPIDOutput implements PIDOutput {
	@Override
	public void pidWrite(double output) {
		//Robot.drivetrain.driveArcade(0, output);
	}
}
