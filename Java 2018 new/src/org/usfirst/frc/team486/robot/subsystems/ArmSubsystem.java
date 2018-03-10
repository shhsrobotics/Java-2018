package org.usfirst.frc.team486.robot.subsystems;

import org.usfirst.frc.team486.robot.RobotMap;
import org.usfirst.frc.team486.robot.commands.ArmCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
	
	private Talon arm = new Talon(RobotMap.arm_motor);
	private Encoder arm_encoder = new Encoder(RobotMap.arm_encoder, RobotMap.arm_encoder1);
	
	public void arm_set(double speed_in) {
		this.arm.set(speed_in);
	}
	public double arm_get() {
		return arm.get();
	}
	public void encoder_reset() {
		this.arm_encoder.reset();
	}
	public double encoder_distance() {
		return this.arm_encoder.getDistance();
	}
	public void encoder_dashboard() {
		SmartDashboard.putNumber("Arm Encoder", this.encoder_distance());
	}
	public double pwr_get(double x_in, double max_in, double mask_in) {
		double x = x_in;
		double max = max_in;
		double mask = mask_in;
		double pwr = 0;
		pwr = ((((((((this.arm_encoder.getDistance()-x)/Math.abs(this.arm_encoder.getDistance()-x))*max)/(x-mask))*this.arm_encoder.getDistance())+(((x-this.arm_encoder.getDistance())/Math.abs(x-this.arm_encoder.getDistance()))*max)))*((x-this.arm_encoder.getDistance())/Math.abs(x-this.arm_encoder.getDistance())));
		if (Math.abs(pwr)>Math.abs(max)) {
			pwr = (((x-this.arm_encoder.getDistance())/Math.abs(x-this.arm_encoder.getDistance()))*max);
		}
		return pwr;
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ArmCommand());
    }
}

