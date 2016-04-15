package com.qualcomm.ftcrobotcontroller.opmodes.FirstResq;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by 7260 on 12/12/2015.
 */
public class SimpleMovement extends OpMode {
    public Movement Chassis;

    @Override
    public void init() {
        Chassis = new Movement(hardwareMap.dcMotor.get("left"), hardwareMap.dcMotor.get("right"));
    }

    @Override
    public void loop() {
        if (gamepad1.left_stick_y > 0) {
            Chassis.reverseDrive(Math.pow(gamepad1.left_stick_y, 2));
        } else if (gamepad1.left_stick_y < 0) {
            Chassis.forwardDrive(Math.pow(gamepad1.left_stick_y, 2));
        } else if (gamepad1.right_stick_x > 0) {
            Chassis.rightSpin(.5 * Math.pow(gamepad1.right_stick_x, 2));
        } else if (gamepad1.right_stick_x < 0) {
            Chassis.leftSpin(.5 * Math.pow(gamepad1.right_stick_x, 2));
        } else {
            Chassis.stopDrive();
        }
    }
}
