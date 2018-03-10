package org.usfirst.frc.team486.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Middle extends CommandGroup {

	public Middle() {
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
		System.out.println("Running Middle, GameData says: " + gameData);
    	if(gameData.length()>0) {
    		System.out.println("GameData length good");
    		if(gameData.charAt(0) == 'L') {
        		addParallel(new GrabTimer(6));
        		addParallel(new AutoLiftSwitch(525));
        		addSequential(new GyroTurn(35,0.65));
        		addSequential(new AutoDriveDistance(120, 0.7));
        	}
        	else {
        		addParallel(new GrabTimer(4));
        		addParallel(new AutoLiftSwitch(525));
        		addSequential(new GyroTurn(-15,0.65));
        		addSequential(new AutoDriveDistance(102, 0.7));
        	}
    	}
    }
}
