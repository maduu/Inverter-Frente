package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.SubsystemIntakeCargo;
import frc.robot.subsystems.SubsystemIntakeHatch;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.SubsystemJoystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.SubsystemDriver;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  public static SubsystemDriver driver = new SubsystemDriver();
  public static SubsystemJoystick joystick = new SubsystemJoystick();
  public static SubsystemIntakeHatch intakeHatch = new SubsystemIntakeHatch();
  public static SubsystemIntakeCargo intakeCargo = new SubsystemIntakeCargo();
  
  public static OI m_oi;
  
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    m_oi = new OI();
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
