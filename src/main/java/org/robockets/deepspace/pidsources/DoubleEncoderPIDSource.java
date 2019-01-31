package org.robockets.deepspace.pidsources;

import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class DoubleEncoderPIDSource implements PIDSource {

	private PIDSourceType type = PIDSourceType.kDisplacement;

	private EncoderPIDSource source1;
	private EncoderPIDSource source2;

	public DoubleEncoderPIDSource(CANEncoder encoder1, CANEncoder encoder2, double multiplier) {
		source1 = new EncoderPIDSource(encoder1, multiplier);
		source2 = new EncoderPIDSource(encoder2, multiplier);
	}

	public DoubleEncoderPIDSource(Encoder encoder1, Encoder encoder2, double multiplier) {
		source1 = new EncoderPIDSource(encoder1, multiplier);
		source2 = new EncoderPIDSource(encoder2, multiplier);
	}

	public DoubleEncoderPIDSource(CANEncoder encoder1, CANEncoder encoder2) {
		this(encoder1, encoder2, 1.0);
	}

	public DoubleEncoderPIDSource(Encoder encoder1, Encoder encoder2) {
		this(encoder1, encoder2, 1.0);
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		type = pidSource;
		source1.setPIDSourceType(pidSource);
		source2.setPIDSourceType(pidSource);
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return type;
	}

	@Override
	public double pidGet() {
		return (source1.pidGet()+source2.pidGet())/2.0;
	}
}
