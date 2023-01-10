// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.Motortype;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxAlternateEncoder.Type;

public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final int = 1000

  public DriveBase() {

  }
  CANSparkMax m_leftMotor = new CANSparkMax(0, Motortype.kBrushless);
  CANSparkMax m_rightMotor = new CANSparkMax(1, Motortype.kBrushless);

  DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  public void arcadeDrive(double xSpeed, double zRotation){
    m_drive.arcadeDrive(xSpeed, zRotation);
  }
  SparkMaxAlternateEncoder m_leftEncoder = m_leftMotor.getAlternateEncoder(Type.kQuadrature, 5000);
  SparkMaxAlternateEncoder m_rightEncoder = m_rightMotor.getAlternateEncoder(Type.kQuadrature, 5000);

  public void resetEncoders(){
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0); 
  }

  public double getLeftDistane(){
    return m_leftMotor.getPosition() * diameter * Math.PI();
  }
  public double getrightDistane(){
    return m_rightMotor.getPosition() * diameter * Math.PI();
  }
  public double getAverageDistance(){
    return ((m_leftEncoder.getDistance() + m_rightEncoder.getDistance()) / 2.0) 
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
