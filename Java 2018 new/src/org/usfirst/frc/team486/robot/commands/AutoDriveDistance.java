package org.usfirst.frc.team486.robot.commands;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveDistance extends Command {
	
	private double inch, speed;
	double ratio = 13.2629119243;
	double conversion;

    public AutoDriveDistance(double inch_in, double speed_in) {
        requires(Robot.chassis);
        this.inch = inch_in;
        this.speed = speed_in;
        this.conversion = (-1*(inch/Math.abs(inch)));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.encoders_reset();
    	Robot.chassis.gyro_reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.straight_drive(conversion*speed, 0.1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(Robot.chassis.left_encoder_distance())>=Math.abs((ratio*inch)) && (-1*(Math.abs(Robot.chassis.right_encoder_distance())))<=(-1*(Math.abs(inch*ratio)))) {
    		return true;
    	}
    	else {
        	return false;	
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.tank_drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.tank_drive(0, 0);
    }
}
