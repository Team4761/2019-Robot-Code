package org.robockets.deepspace.cargo;

import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;

public class Cargo extends Subsystem {

	public final double REV_PER_DEGREES = 72.88323211669922/90.0;
	private final double ABSOLUTE_TOLERANCE = 5.0; // Degrees

	private CANPIDController m_pidController;

	public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, setpoint;

	public Cargo() {
		m_pidController = RobotMap.cargoArmMotor.getPIDController();

		kP = 0.02;
		kI = 0;
		kD = 0.00001;
		kIz = 0;
		kFF = 0;
		kMaxOutput = 1;
		kMinOutput = -1;
		setpoint = 0;


		m_pidController.setP(kP);
		m_pidController.setI(kI);
		m_pidController.setD(kD);
		//m_pidController.setIZone(kIz);
		m_pidController.setFF(kFF);
		m_pidController.setOutputRange(kMinOutput, kMaxOutput);


		/*SmartDashboard.putNumber("Cargo P Gain", kP);
		SmartDashboard.putNumber("Cargo I Gain", kI);
		SmartDashboard.putNumber("Cargo D Gain", kD);
		//SmartDashboard.putNumber("Cargo I Zone", kIz);
		SmartDashboard.putNumber("Cargo Feed Forward", kFF);
		SmartDashboard.putNumber("Cargo Max Output", kMaxOutput);
		SmartDashboard.putNumber("Cargo Min Output", kMinOutput);

		SmartDashboard.putNumber("Cargo SetPoint", 0);*/

		RobotMap.cargoArmMotor.burnFlash();
	}

	@SuppressWarnings("Duplicates")
	public void cargoPeriodic() {


		/*double p = SmartDashboard.getNumber("Cargo P Gain", 0);
		double i = SmartDashboard.getNumber("Cargo I Gain", 0);
		double d = SmartDashboard.getNumber("Cargo D Gain", 0);
		double iz = SmartDashboard.getNumber("Cargo I Zone", 0);
		double ff = SmartDashboard.getNumber("Cargo Feed Forward", 0);
		double max = SmartDashboard.getNumber("Cargo Max Output", 0);
		double min = SmartDashboard.getNumber("Cargo Min Output", 0);

		double sp = SmartDashboard.getNumber("Cargo SetPoint", 0);

		// if PID coefficients on SmartDashboard have changed, write new values to controller
		if((p != kP)) { m_pidController.setP(p); kP = p; }
		if((i != kI)) { m_pidController.setI(i); kI = i; }
		if((d != kD)) { m_pidController.setD(d); kD = d; }
		if((iz != kIz)) { m_pidController.setIZone(iz); kIz = iz; }
		if((ff != kFF)) { m_pidController.setFF(ff); kFF = ff; }
		if((max != kMaxOutput) || (min != kMinOutput)) {
			m_pidController.setOutputRange(min, max);
			kMinOutput = min; kMaxOutput = max;
		}

		if (sp != setpoint) {
			m_pidController.setReference(sp*REV_PER_DEGREES, ControlType.kPosition);
			setpoint = sp;
		}*/
	}

	public void initDefaultCommand() {
	}

	public void setArmPosition(double angle) {
		m_pidController.setReference(angle* REV_PER_DEGREES, ControlType.kPosition);
		setpoint = angle* REV_PER_DEGREES;
	}

	public boolean onTarget() {
		double currentPos = RobotMap.cargoEncoder.getPosition()/ REV_PER_DEGREES;

		return (currentPos>=setpoint-ABSOLUTE_TOLERANCE&&currentPos<=setpoint+ABSOLUTE_TOLERANCE);
	}

	public void disablePID() {
		m_pidController.setReference(RobotMap.cargoEncoder.getPosition()/ REV_PER_DEGREES, ControlType.kPosition);
	}

	public void setSolenoid(DoubleSolenoid.Value value) {
		RobotMap.cargoSolenoid.set(value);
	}

	public DoubleSolenoid.Value getSolenoidValue() {
		return RobotMap.cargoSolenoid.get();
	}

	public void moveArmMotor(double speed) {
		RobotMap.cargoArmMotor.set(speed);
	}

	public void moveIntake(double speed) {
		RobotMap.cargoIntakeMotor.set(speed);
	}

	public boolean hasCargo() {
		return RobotMap.cargoBreakbeam.get();
	}

}