package org.usfirst.frc.team486.robot.subsystems;

import org.usfirst.frc.team486.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchSubsystem extends Subsystem {
	
	private Talon winch = new Talon(RobotMap.winch_motor);
	private DigitalInput limit_switch = new DigitalInput(RobotMap.limit_switch);
	
	public void winch_set(double speed) {
		this.winch.set(speed);
	}
	public void winch_stop() {
		this.winch.set(0);
	}
	public boolean limit_switch_get() { 
		return this.limit_switch.get(); 
	}  
	
    public void initDefaultCommand() {
    }
}

