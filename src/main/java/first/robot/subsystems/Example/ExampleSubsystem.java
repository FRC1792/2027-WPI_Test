// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.subsystems.Example;

import org.wpilib.command2.SubsystemBase;
import org.wpilib.drivers.motor.Talon;
import org.wpilib.hardware.hal.CANAPITypes.CANManufacturer;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class ExampleSubsystem extends SubsystemBase {

  private ExampleState currentState = ExampleState.UNO;
  private CANBus apple;
  private TalonFX exampleMotor;
  private TalonFXConfiguration exampleConfig;
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    exampleMotor = new TalonFX(19, apple);

    exampleConfig = new TalonFXConfiguration()
                        .withMotorOutput(new MotorOutputConfigs()
                                              .withInverted(InvertedValue.Clockwise_Positive)
                                              .withNeutralMode(NeutralModeValue.Brake))
                        .withCurrentLimits(new CurrentLimitsConfigs()
                                                .withSupplyCurrentLimit(35)); 
  }

  public void setGoal(ExampleState desiredState) {
    currentState = desiredState;
    switch (desiredState) {
      case UNO:
        exampleMotor.stopMotor();
        break;
      case DOS:
        exampleMotor.setThrottle(.5);
        break;
      case TRES:
        exampleMotor.setThrottle(-.5);
        break;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
