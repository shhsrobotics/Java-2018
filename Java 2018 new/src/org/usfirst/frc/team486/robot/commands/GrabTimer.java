package org.usfirst.frc.team486.robot.commands;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabTimer extends Command {
	private Timer timer = new Timer();
	double seconds;

    public GrabTimer(double seconds_in) {
    	this.seconds = seconds_in;
    	requires(Robot.compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.compressor.grab_close();
    	this.timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (this.timer.get() >= seconds) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.compressor.grab_open();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.compressor.grab_open();
    }
}
