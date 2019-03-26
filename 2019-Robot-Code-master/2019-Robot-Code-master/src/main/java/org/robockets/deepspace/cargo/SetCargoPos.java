package org.robockets.deepspace.cargo;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class SetCargoPos extends Command {

	private CargoPos position;

	public SetCargoPos(CargoPos position) {
		requires(Robot.cargo);
		this.position = position;
	}

	protected void initialize() {
		switch (position) {
			case START:
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kForward);
				Robot.cargo.setArmPosition(0); // TODO: Change me
				break;
			case PICKUP:
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kReverse);
				Robot.cargo.setArmPosition(90); // TODO: Change Me
				break;
			case LOW:
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kReverse);
				Robot.cargo.setArmPosition(45); // TODO: Change Me
				break;
			case MID:
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kReverse);
				Robot.cargo.setArmPosition(20); // TODO: Change Me
				break;
			case CARGO:
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kReverse);
				Robot.cargo.setArmPosition(10); // TODO: Change Me
				break;
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return Robot.cargo.onTarget();
	}

	protected void end() {
		Robot.cargo.disablePID();
	}

	protected void interrupted() {
		end();
	}
}