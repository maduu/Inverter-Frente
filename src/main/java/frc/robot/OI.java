package frc.robot;

import frc.robot.Robot;
import frc.robot.commands.*;
import frc.robot.subsystems.SubsystemJoystick;
import main.java.frc.robot.commands.CommandInvert;

public class OI {
    public OI(){
        Robot.joystick.whenPressed(SubsystemJoystick.d_X, new CommandInvert());
    }
}