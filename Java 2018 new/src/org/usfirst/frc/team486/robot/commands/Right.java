package org.usfirst.frc.team486.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Right extends CommandGroup {

    public Right() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if (gameData.length()>0) {
    		if(gameData.charAt(0) == 'L') {
        		if(gameData.charAt(1) == 'R') {
        			addParallel(new AutoLiftSwitch(850));
        			addParallel(new GrabTimer(9.75));
        			addSequential(new AutoDriveDistance(309, 0.7));
        			addSequential(new GyroTurn(90,0.65));
        			addSequential(new AutoDriveDistance(36, 0.5));
        		}
        		else {
        			addParallel(new AutoDriveDistance(101, 0.6));
                	addParallel(new AutoLiftSwitch(400));
                	addSequential(new GrabClose());
        		}
        	}
    		else {
        		addParallel(new GrabTimer(7));
            	addParallel(new AutoLiftSwitch(450));
            	addSequential(new AutoDriveDistance(140, 0.6));
            	addSequential(new GyroTurn(90, 0.65));
            	addSequential(new AutoDriveDistance(18, 0.5));
        	}
    	}
    }
}
