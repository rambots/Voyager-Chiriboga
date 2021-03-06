package com.rambots4571.deepspace.robot.command;

import com.rambots4571.deepspace.robot.Robot;
import com.rambots4571.deepspace.robot.subsystem.Drivetrain;
import edu.wpi.first.wpilibj.command.Command;

public class TeleOpDrive extends Command {
    private Drivetrain drivetrain = Drivetrain.getInstance();

    public TeleOpDrive() {
        requires(drivetrain);
    }

    @Override
    protected void execute() {
        drivetrain.drive(
                Robot.leftStick.getYAxis(), Robot.rightStick.getYAxis());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        drivetrain.stop();
        drivetrain.resetEncoders();
    }
}