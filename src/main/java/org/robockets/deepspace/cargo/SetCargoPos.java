package org.robockets.deepspace.cargo;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.deepspace.Robot;

public class SetCargoPos extends Command {

	private CargoPos position;
	private Timer timer;

	private boolean isCounting;

	public SetCargoPos(CargoPos position) {
		requires(Robot.cargo);
		this.position = position;
		this.timer = new Timer();
		isCounting = false;
	}

	protected void initialize() {
		System.out.println(position);
		switch (position) {
			case START:
				//Robot.cargo.setSolenoid(DoubleSolenoid.Value.kForward);
				//Robot.cargo.setArmPosition(0); // TODO: Change me
				break;
			case PICKUP:
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kForward);
				Robot.cargo.setArmPosition(-144);
				break;
			case LOW:
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kReverse);
				Robot.cargo.setArmPosition(-150);
				break;
			case MID:
				//Robot.cargo.setSolenoid(DoubleSolenoid.Value.kReverse);
				//Robot.cargo.setArmPosition(20); // TODO: Change Me
				break;
			case CARGO:
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kForward);
				// Wait 1 second
				isCounting = true;
				timer.start();
				break;
		}
	}

	protected void execute() {
		if (isCounting) {

			switch (position) {
				case CARGO:
					System.out.println(timer.get());
					if (timer.hasPeriodPassed(0.35)) {
						Robot.cargo.setArmPosition(-2);
						isCounting = false;
					}
					break;
			}
		}
	}

	protected boolean isFinished() {
		if (!isCounting) {
			return Robot.cargo.onTarget();
		}
		return false;
	}

	protected void end() {
		isCounting = false;
		timer.stop();
		Robot.cargo.disablePID();
	}

	protected void interrupted() {
		end();
	}
}