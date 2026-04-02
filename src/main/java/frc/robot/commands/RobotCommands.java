package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;
import frc.robot.Subsystems.KrackenPositionMotor;

public class RobotCommands {
    public static final Command pos1 = new InstantCommand(
        ()-> KrackenPositionMotor.setKrackenPosition(Constants.KrackenPositionMotor.pos1)
    );
    public static final Command pos2 = new InstantCommand(
        ()-> KrackenPositionMotor.setKrackenPosition(Constants.KrackenPositionMotor.pos2)
    );
}