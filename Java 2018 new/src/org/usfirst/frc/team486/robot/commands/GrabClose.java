package org.usfirst.frc.team486.robot.commands;

import org.usfirst.frc.team486.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabClose extends Command {

    public GrabClose() {
    	requires(Robot.compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.compressor.grab_close();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
