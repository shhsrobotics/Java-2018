package org.usfirst.frc.team486.robot.commands;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTurn extends Command {
	double angle, speed;
	double threshold = 3;

    public GyroTurn(double angle_in, double speed_in) {
    	this.angle = (((angle_in%360)/360)*355);
    	this.speed = speed_in;
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.gyro_reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (this.angle<0) {
    		//Right
    		Robot.chassis.tank_drive(-this.speed, this.speed);
    	}
    	else {
    		Robot.chassis.tank_drive(this.speed, -this.speed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double offset = Math.abs(this.angle - Robot.chassis.gyro_angle());
    	return (offset<threshold);
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
