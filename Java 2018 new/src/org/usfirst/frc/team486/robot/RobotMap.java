/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team486.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Joystick ports
	public static int opstick = 2;
	public static int left_stick = 1;
	public static int right_stick = 0;
	public static int station_stick = 4;
	//Opstick buttons
	public static int grab_open = 3;
	public static int grab_close = 2;
	public static int arm_extend = 6;
	public static int arm_decline = 7;
	//Station buttons
	public static int winch_up = 6;
	public static int winch_down = 5;
	//PWM
	public static int right_motor = 0;
	public static int left_motor = 1;
	public static int arm_motor = 2;
	public static int winch_motor = 3;
	//DIO
	public static int left_motor_encoder = 0;
	public static int left_motor_encoder1 = 1;
	public static int right_motor_encoder = 2;
	public static int right_motor_encoder1 = 3;
	public static int arm_encoder = 4;
	public static int arm_encoder1 = 5;
	public static int limit_switch = 6;
	//Compressor
	public static int compressor = 0;
	//Solenoid
	public static int grab_solenoid = 0;
	public static int extend_solenoid = 1;
	
}
