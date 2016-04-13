package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 7260 on 4/12/2016.
 */
public class nelsonMovements extends OpMode {

    DcMotor right;
    DcMotor left;

    public void init() {

        right = hardwareMap.dcMotor.get("right");
        left = hardwareMap.dcMotor.get("left");
    }

    public void loop(){
        if (gamepad1.left_stick_y>0) {
            left.setPower(0.5);
        }else if(gamepad1.left_stick_y<0) {
            left.setPower(-0.5);
        } else if(gamepad1.left_stick_y==0)
            left.setPower(0);


        if (gamepad1.right_stick_y>0) {
            right.setPower(0.5);
        }else if(gamepad1.right_stick_y<0) {
            right.setPower(-0.5);
        } else if (gamepad1.right_stick_y==0)
            right.setPower(0);

    }

    }
