package com.rambots4571.rampage.ctre.motionprofile

import com.ctre.phoenix.motion.TrajectoryPoint
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import com.rambots4571.rampage.ctre.Constants
import com.rambots4571.rampage.structure.Sequence
import edu.wpi.first.wpilibj.DriverStation

class Profile(
    val leftProfile: Sequence<TrajectoryPoint>,
    val rightProfile: Sequence<TrajectoryPoint>, leftTalon: TalonSRX,
    rightTalon: TalonSRX) {
    val length: Int = leftProfile.size
    private val handler: Handler =
        Handler(this, leftTalon, rightTalon)
    var timeoutMs = Constants.Talon.timeoutMs
    var trajectoryPointPeriod = Constants.Talon.trajectoryPointPeriod
    var motionControlFramePeriod = timeoutMs / 2
    val isFinished = handler.isFinished

    fun execute() {
        if (leftProfile.size != 0 && rightProfile.size != 0) {
            handler.execute()
        } else {
            DriverStation.getInstance()
            DriverStation.reportError("Tried to run empty profile!", false)
        }
    }

    fun onInterrupt() = handler.onInterrupt()
}
