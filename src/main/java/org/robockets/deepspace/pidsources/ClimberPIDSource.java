package org.robockets.deepspace.pidsources;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import org.robockets.deepspace.RobotMap;

public class ClimberPIDSource implements PIDSource {

	private double zeroVal = 0;

	private final double DEG_PER_TICK = 90.0/118.0;

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {

	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		return (RobotMap.climberEncoder.getPosition() - zeroVal) * DEG_PER_TICK;
	}

	public void reset() {
		zeroVal = RobotMap.climberEncoder.getPosition() * DEG_PER_TICK;
	}
}
