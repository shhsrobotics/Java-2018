package org.usfirst.frc.team486.robot.subsystems;

import org.usfirst.frc.team486.robot.RobotMap;
import org.usfirst.frc.team486.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class ChassisSubsystem extends Subsystem {
	
	//Talon
	private Talon right_motor = new Talon(RobotMap.right_motor);
	private Talon left_motor = new Talon(RobotMap.left_motor);
	private DifferentialDrive drive = new DifferentialDrive(left_motor, right_motor);
	//Encoders
	private Encoder right_encoder = new Encoder(RobotMap.left_motor_encoder, RobotMap.left_motor_encoder1);
	private Encoder left_encoder = new Encoder(RobotMap.right_motor_encoder, RobotMap.right_motor_encoder1);
	//Gyro
	private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	//Drive
	public void tank_drive (double lspeed_in, double rspeed_in) {
		this.drive.tankDrive(-1*lspeed_in, -1*rspeed_in);
	}
	public void straight_drive(double speed, double kP) {
		this.drive.arcadeDrive(-speed, this.gyro_angle()*kP);
	}
	//Encoders
	public void encoders_reset() {
		this.right_encoder.reset();
		this.left_encoder.reset();
	}
	public double left_encoder_distance() {
		return this.left_encoder.getDistance();
	}
	public double right_encoder_distance() {
		return this.right_encoder.getDistance();
	}
	//Gyro
	public double gyro_angle() {
		return this.gyro.getAngle()*-1;
	}
	public void gyro_reset() {
		this.gyro.reset();
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    } 
    
}

