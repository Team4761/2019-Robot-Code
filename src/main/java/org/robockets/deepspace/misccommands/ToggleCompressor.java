package org.robockets.deepspace.misccommands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.RobotMap;

public class ToggleCompressor extends Command {

	public ToggleCompressor() {
	}

	protected void initialize() {
		boolean isEnabled = RobotMap.compressor.enabled();

		if (isEnabled) {
			RobotMap.compressor.stop();
		} else {
			RobotMap.compressor.start();
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}