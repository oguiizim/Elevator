package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    
    private CANSparkMax motor1, motor2;
    private RelativeEncoder motorEncoder;
    private Encoder throughBore;

    public Elevator(){
        motor1 = new CANSparkMax(1, MotorType.kBrushless);
        motor2 = new CANSparkMax(2, MotorType.kBrushless);

        // Declaração para o encoder do NEO
        motorEncoder = motor1.getEncoder();

        // Declaração do ThroughBore no modo Relative
        throughBore = new Encoder(0, 1, false, EncodingType.k4X);
    }

    public double getMotorEncoder(){
        return motorEncoder.getPosition();
    }

    public double getThroughBore(){
        return throughBore.getDistance();
    }

    public void setMotorSpeed(double output){
        motor1.set(output);
        motor2.set(output);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("NEO Ticks", getMotorEncoder());
        SmartDashboard.putNumber("ThroughBore Ticks", getThroughBore());
    }

}
