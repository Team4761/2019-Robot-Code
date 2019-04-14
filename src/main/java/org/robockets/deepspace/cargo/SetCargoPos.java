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
				Robot.cargo.setArmPosition(-165);
				break;
			case LOW:
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kReverse);
				Robot.cargo.setArmPosition(-172);
				break;
			case BACK:
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kForward);
				// Wait 1 second
				isCounting = true;
				timer.start();
				break;
			case CARGO:
				//TODO: GIVE ME REAL VALUES
				Robot.cargo.setSolenoid(DoubleSolenoid.Value.kForward);
				Robot.cargo.setArmPosition(-41);
				break;
		}
	}

	protected void execute() {
		if (isCounting) {

			switch (position) {
				case BACK:
					System.out.println(timer.get());
					if (timer.hasPeriodPassed(0.35)) {
						Robot.cargo.setArmPosition(0);
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