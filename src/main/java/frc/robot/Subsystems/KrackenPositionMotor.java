package frc.robot.Subsystems;

import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class KrackenPositionMotor extends SubsystemBase {
    
    private final TalonFX KrackenMotor = new TalonFX(Constants.KrackenPositionMotor.CANID);

    private final PositionVoltage KrackenMotorPositionVoltage = new PositionVoltage(0);
    private final VelocityVoltage KrackenMotorVelocityVoltage = new VelocityVoltage(0);

    public KrackenPositionMotor() {
        KrackenMotor.getConfigurator().apply(new TalonFXConfiguration());
        TalonFXConfiguration KrackenMotorConfig = new TalonFXConfiguration();

        KrackenMotorConfig.Slot0.kP = Constants.KrackenPositionMotor.kP;
        KrackenMotorConfig.Slot0.kI = Constants.KrackenPositionMotor.kI;
        KrackenMotorConfig.Slot0.kD = Constants.KrackenPositionMotor.kD;

        KrackenMotorConfig.CurrentLimits.SupplyCurrentLimit = 40; //Amps from PDH
        KrackenMotorConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
        KrackenMotorConfig.CurrentLimits.StatorCurrentLimit = Constants.KrackenPositionMotor.MAXCURRENT ; //Amps to Motor
        KrackenMotorConfig.CurrentLimits.StatorCurrentLimitEnable = true;

        KrackenMotorConfig.Voltage
            .withPeakForwardVoltage(6)
            .withPeakReverseVoltage(-6);
        KrackenMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    
    }

    public void setKrackenPosition(double rotations) {
        KrackenMotor.setControl(KrackenMotorPositionVoltage.withPosition(rotations));
    }

    public void setKrackenVelocity(double velocity) {
        KrackenMotor.setControl(KrackenMotorVelocityVoltage.withVelocity(velocity));
    }

    public double EncoderValue() {
        return KrackenMotor.getPosition().getValueAsDouble();
    }


}