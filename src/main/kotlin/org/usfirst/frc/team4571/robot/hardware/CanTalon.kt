package org.usfirst.frc.team4571.robot.hardware

import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import org.usfirst.frc.team4571.robot.Constants

class CanTalon(deviceNumber: Int) : WPI_TalonSRX(deviceNumber) {
    init {
        expiration = Constants.ROBOT_PERIOD
        isSafetyEnabled = false
        setNeutralMode(NeutralMode.Brake)
    }
}