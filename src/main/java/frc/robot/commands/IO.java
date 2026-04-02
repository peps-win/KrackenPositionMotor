package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class IO {
    
    public static XboxController driverXbox = new XboxController(0);

    JoystickButton pos1Button = new JoystickButton(driverXbox, 1);
    JoystickButton pos2Button = new JoystickButton(driverXbox, 4);

    public IO() {
        pos1Button.onTrue(RobotCommands.pos1);
        pos2Button.onTrue(RobotCommands.pos2);
    }
}
