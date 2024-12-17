package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;

public class RunUsingThroughBore extends Command {

    private double kP = 0.1;
    private double kI = 0.0;
    private double kD = 0.0;
    double setpoint;

    private Elevator elevator;
    private PIDController pidControl = new PIDController(kP, kI, kD);

    public RunUsingThroughBore(Elevator elevator, double setpoint){
        this.elevator = elevator;
        this.setpoint = setpoint;
    }

    @Override
    public void execute() {
        double output = MathUtil.clamp(pidControl.calculate(elevator.getThroughBore(), setpoint), -.8, .8);
        elevator.setMotorSpeed(output);
    }
}
