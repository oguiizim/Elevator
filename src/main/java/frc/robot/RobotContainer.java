// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.RunUsingMotor;
import frc.robot.commands.RunUsingThroughBore;
import frc.robot.subsystems.Elevator;

public class RobotContainer {

  public static final Elevator elevator = new Elevator();
  public CommandXboxController control = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    Trigger aButton = control.a();
    Trigger bButton = control.b();

    new Trigger(aButton).onTrue(new RunUsingMotor(elevator, 500));
    new Trigger(bButton).onTrue(new RunUsingThroughBore(elevator, 500));
  }

}
