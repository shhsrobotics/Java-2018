package org.usfirst.frc.team486.robot.commands;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Delay extends Command {
	
	private Timer timer = new Timer();
	double seconds;

    public Delay(double seconds_in) {
        requires(Robot.chassis);
        this.seconds = seconds_in;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.timer.reset();
    	this.timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.tank_drive(0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (this.timer.get()>=this.seconds);
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
