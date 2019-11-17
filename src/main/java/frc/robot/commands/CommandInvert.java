package main.java.frc.robot.commands;

import frc.robot.subsystems.SubsystemJoystick;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.commands.CommandDrive;
import frc.robot.Robot;

public class CommandInvert extends Command {
    
    public CommandInvert() {
		super(Robot.driver);
    }
    
	@Override
	protected void execute() {
    Robot.driver.inverter = !Robot.driver.inverter; 
    }

	@Override
	protected boolean isFinished() {
		return false;
    }
    
	@Override
	protected void end() {
    }
    
    @Override
    protected void interrupted() {
    }
}