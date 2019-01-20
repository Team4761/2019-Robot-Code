package org.robockets.deepspace.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.deepspace.RobotMap;
import org.robockets.deepspace.pidsources.ClimberPIDSource;

public class Climber extends Subsystem {


	public ClimberPIDSource pidSource;

	public PIDController controller;

	public Climber() {
		//RobotMap.climberEncoder.setDistancePerPulse(0);
		pidSource = new ClimberPIDSource();

		controller = new PIDController(0, 0, 0, pidSource, RobotMap.climberMotor);
		controller.disable();
		controller.setOutputRange(-1.0, 1.0);
		controller.setAbsoluteTolerance(2);

	}

	public void initDefaultCommand() {

	}

}