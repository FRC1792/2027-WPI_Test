// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.subsystems.Example;

import org.wpilib.command2.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {

  private ExampleState currentState = ExampleState.UNO;

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {}

  public void setGoal(ExampleState desiredState) {
    currentState = desiredState;
    switch (desiredState) {
      case UNO:
        break;
      case DOS:
        break;
      case TRES:
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
