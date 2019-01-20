package org.robockets.deepspace;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import edu.wpi.first.hal.util.BoundaryException;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

public class SparkMaxPIDController extends PIDController {
	private CANPIDController pidController;

	public SparkMaxPIDController(double Kp, double Ki, double Kd, double Kf, CANSparkMax motorController, CANEncoder encoder, double period) {
		super(Kp, Ki, Kd, Kf, new PIDSource() {
			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return PIDSourceType.kDisplacement;
			}

			@Override
			public double pidGet() {
				return encoder.getPosition();
			}
		}, motorController, period);
		pidController = motorController.getPIDController();
	}

	public SparkMaxPIDController(double Kp, double Ki, double Kd, CANSparkMax motorController, CANEncoder encoder, double period) {
		this(Kp, Ki, Kd, 0, motorController, encoder, period);
	}

	public SparkMaxPIDController(double Kp, double Ki, double Kd, CANSparkMax motorController, CANEncoder encoder) {
		this(Kp, Ki, Kd, motorController, encoder, 0.05);
	}

	public SparkMaxPIDController(double Kp, double Ki, double Kd, double Kf, CANSparkMax motorController, CANEncoder encoder) {
		this(Kp, Ki, Kd, Kf, motorController, encoder, 0.05);
	}

	/**
	 * Set the PID Controller gain parameters. Set the proportional, integral, and differential
	 * coefficients.
	 *
	 * @param p Proportional coefficient
	 * @param i Integral coefficient
	 * @param d Differential coefficient
	 * @param f Feed forward coefficient
	 */
	@SuppressWarnings("ParameterName")
	public void setPID(double p, double i, double d, double f) {
		m_thisMutex.lock();
		try {
			pidController.setP(p);
			pidController.setI(i);
			pidController.setD(d);
			pidController.setFF(f);
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Set the Proportional coefficient of the PID controller gain.
	 *
	 * @param p Proportional coefficient
	 */
	@SuppressWarnings("ParameterName")
	public void setP(double p) {
		m_thisMutex.lock();
		try {
			pidController.setP(p);
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Set the Integral coefficient of the PID controller gain.
	 *
	 * @param i Integral coefficient
	 */
	@SuppressWarnings("ParameterName")
	public void setI(double i) {
		m_thisMutex.lock();
		try {
			pidController.setI(i);
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Set the Differential coefficient of the PID controller gain.
	 *
	 * @param d differential coefficient
	 */
	@SuppressWarnings("ParameterName")
	public void setD(double d) {
		m_thisMutex.lock();
		try {
			pidController.setD(d);
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Set the Feed forward coefficient of the PID controller gain.
	 *
	 * @param f feed forward coefficient
	 */
	@SuppressWarnings("ParameterName")
	public void setF(double f) {
		m_thisMutex.lock();
		try {
			pidController.setFF(f);
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Get the Proportional coefficient.
	 *
	 * @return proportional coefficient
	 */
	@Override
	public double getP() {
		m_thisMutex.lock();
		try {
			return pidController.getP();
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Get the Integral coefficient.
	 *
	 * @return integral coefficient
	 */
	@Override
	public double getI() {
		m_thisMutex.lock();
		try {
			return pidController.getI();
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Get the Differential coefficient.
	 *
	 * @return differential coefficient
	 */
	@Override
	public double getD() {
		m_thisMutex.lock();
		try {
			return pidController.getD();
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Get the Feed forward coefficient.
	 *
	 * @return feed forward coefficient
	 */
	public double getF() {
		m_thisMutex.lock();
		try {
			return pidController.getFF();
		} finally {
			m_thisMutex.unlock();
		}
	}

	private double m_maximumInput;
	private double m_minimumInput;
	/**
	 * Sets the maximum and minimum values expected from the input and setpoint.
	 *
	 * @param minimumInput the minimum value expected from the input
	 * @param maximumInput the maximum value expected from the input
	 */
	public void setInputRange(double minimumInput, double maximumInput) {
		m_minimumInput = minimumInput;
		m_maximumInput = maximumInput;
	}

	/**
	 * Sets the minimum and maximum values to write.
	 *
	 * @param minimumOutput the minimum percentage to write to the output
	 * @param maximumOutput the maximum percentage to write to the output
	 */
	public void setOutputRange(double minimumOutput, double maximumOutput) {
		m_thisMutex.lock();
		try {
			if (minimumOutput > maximumOutput) {
				throw new BoundaryException("Lower bound is greater than upper bound");
			}
			pidController.setOutputRange(minimumOutput, maximumOutput);
		} finally {
			m_thisMutex.unlock();
		}
	}



	/**
	 * Set the setpoint for the PIDController.
	 *
	 * @param setpoint the desired setpoint
	 */
	@Override
	public void setSetpoint(double setpoint) {
		m_thisMutex.lock();
		try {
			if (m_maximumInput > m_minimumInput) {
				if (setpoint > m_maximumInput) {
					pidController.setReference(m_maximumInput, ControlType.kPosition);
				} else if (setpoint < m_minimumInput) {
					pidController.setReference(m_minimumInput, ControlType.kPosition);
				} else {
					pidController.setReference(setpoint, ControlType.kPosition);
				}
			} else {
				pidController.setReference(setpoint, ControlType.kPosition);
			}
		} finally {
			m_thisMutex.unlock();
		}
	}

	/*
	/**
	 * Returns the current setpoint of the PIDController.
	 *
	 * @return the current setpoint
	 **
	@Override
	public double getSetpoint() {
		m_thisMutex.lock();
		try {
			return m_setpoint;
		} finally {
			m_thisMutex.unlock();
		}
	}*/


	@Override
	public void close() {
		super.close();
		//m_controlLoop.close();
		m_thisMutex.lock();
		try {
			m_pidOutput = null;
			m_pidInput = null;
			//m_controlLoop = null;
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Begin running the PIDController.
	 */
	@Override
	public void enable() {
		m_thisMutex.lock();
		try {
			m_enabled = true;
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Stop running the PIDController, this sets the output to zero before stopping.
	 */
	@Override
	public void disable() {
		// Ensures m_enabled check and pidWrite() call occur atomically
		m_pidWriteMutex.lock();
		try {
			m_thisMutex.lock();
			try {
				m_enabled = false;
			} finally {
				m_thisMutex.unlock();
			}

			m_pidOutput.pidWrite(0);
		} finally {
			m_pidWriteMutex.unlock();
		}
	}

	/**
	 * Set the enabled state of the PIDController.
	 */
	public void setEnabled(boolean enable) {
		if (enable) {
			enable();
		} else {
			disable();
		}
	}

	/**
	 * Return true if PIDController is enabled.
	 */
	public boolean isEnabled() {
		m_thisMutex.lock();
		try {
			return m_enabled;
		} finally {
			m_thisMutex.unlock();
		}
	}

	/**
	 * Reset the previous error, the integral term, and disable the controller.
	 */
	@Override
	public void reset() {
		disable();

		super.reset();
	}

	@Override
	public void initSendable(SendableBuilder builder) {
		super.initSendable(builder);
		builder.addBooleanProperty("enabled", this::isEnabled, this::setEnabled);
	}
}
