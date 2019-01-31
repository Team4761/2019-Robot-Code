package org.robockets.deepspace.pidsources;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import org.robockets.deepspace.RobotMap;

public class ClimberPIDSource implements PIDSource {

	private final double RADIUS = 1.0;

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kRate;
	}

	@Override
	public double pidGet() {
		double theta = RobotMap.leftClimberEncoder.getPosition()/RADIUS;
		double sin = Math.sin(theta);

		return RADIUS * RobotMap.leftClimberEncoder.getVelocity() * sin;
	}
}
