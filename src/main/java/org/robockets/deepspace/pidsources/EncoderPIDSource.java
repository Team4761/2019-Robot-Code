package org.robockets.deepspace.pidsources;

import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class EncoderPIDSource implements PIDSource {

	private PIDSourceType type = PIDSourceType.kDisplacement;

	private CANEncoder canEncoder;
	private Encoder pwmEncoder;

	private double multiplier = 1.0;

	private boolean isCAN = false;

	public EncoderPIDSource(CANEncoder encoder, double multiplier) {
		this.multiplier = multiplier;

		isCAN = true;
		canEncoder = encoder;
	}

	public EncoderPIDSource(Encoder encoder, double multiplier) {
		this.multiplier = multiplier;

		isCAN = false;
		pwmEncoder = encoder;
	}

	public EncoderPIDSource(CANEncoder encoder) {
		this(encoder, 1.0);
	}

	public EncoderPIDSource(Encoder encoder) {
		this(encoder, 1.0);
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		type = pidSource;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return type;
	}

	@Override
	public double pidGet() {
		if (isCAN) {
			switch (type) {
				case kDisplacement:
					return canEncoder.getPosition()*multiplier;
				case kRate:
					return canEncoder.getVelocity()*multiplier;
			}
			return canEncoder.getPosition()*multiplier;
		} else {
			switch (type) {
				case kDisplacement:
					return pwmEncoder.getDistance()*multiplier;
				case kRate:
					return pwmEncoder.getRate()*multiplier;
			}
			return pwmEncoder.getDistance()*multiplier;
		}
	}
}
