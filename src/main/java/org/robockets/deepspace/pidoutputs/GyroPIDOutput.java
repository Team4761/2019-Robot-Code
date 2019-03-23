package org.robockets.deepspace.pidoutputs;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.robockets.deepspace.Robot;

public class GyroPIDOutput implements PIDOutput {

	private DifferentialDrive robotDrive;

	private boolean isAssistMode = false;

	public GyroPIDOutput(DifferentialDrive dd) {
		robotDrive = dd;
	}

	@Override
	public void pidWrite(double output) {
		if (!isAssistMode) {
			robotDrive.arcadeDrive(0, output);
		}
	}

	public void setAssistMode(boolean isAssistMode) {
		this.isAssistMode = isAssistMode;
	}

	public boolean getAssistMode() {
		return isAssistMode;
	}
}
