package org.usfirst.frc.team486.robot.subsystems;

import org.usfirst.frc.team486.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CompressorSubsystem extends Subsystem {
	
	//Compressor
	private Compressor compressor = new Compressor(RobotMap.compressor);
	//Solenoids
	private Solenoid grab = new Solenoid(RobotMap.grab_solenoid);
	private Solenoid arm = new Solenoid(RobotMap.extend_solenoid);
	
	//Compressor
	public void compressor_start () {
		this.compressor.start();
	}
	//Grab
	public void grab_open() {
		this.grab.set(false);
	}
	public void grab_close() {
		this.grab.set(true);
	}
	//Arm
	public void arm_extend() {
		this.arm.set(true);
	}
	public void arm_decline() {
		this.arm.set(false);
	}

    public void initDefaultCommand() {
    }
}

