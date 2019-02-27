package org.robockets.deepspace.hatch;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.RobotMap;

public class PressureManager extends Command {

	public PressureManager() {
	}

	protected void initialize() {
		RobotMap.compressor.stop();
	}

	boolean wasMax = false;
	protected void execute() {
		/*double pressure = (RobotMap.pressure1.getValue()-500)/10.0;

		if (pressure > 30) {
			wasMax = true;
			if (RobotMap.compressor.enabled()) {
				RobotMap.compressor.stop();
			}
		} else {
			if (!RobotMap.compressor.enabled() && pressure < 20 && wasMax) {
				RobotMap.compressor.start();
			}
		}*/
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}