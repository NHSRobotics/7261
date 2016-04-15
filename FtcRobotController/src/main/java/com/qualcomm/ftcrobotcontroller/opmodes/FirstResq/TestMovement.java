package com.qualcomm.ftcrobotcontroller.opmodes.FirstResq;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Robotics on 4/13/2016.
 */
public class TestMovement extends OpMode {

    DcMotor RightMotorOne;
    DcMotor RightMotorTwo;
    DcMotor LeftMotorOne;
    DcMotor LeftMotorTwo;

    public void init (){

        RightMotorOne = hardwareMap.dcMotor.get("RightMotorOne");
        RightMotorTwo = hardwareMap.dcMotor.get("RightMotorTwo");
        LeftMotorOne = hardwareMap.dcMotor.get("LeftMotorOne");
        LeftMotorTwo = hardwareMap.dcMotor.get("LeftMotorTwo");

    }

    @Override
    public void loop() {

        if(gamepad1.left_stick_y > 0){

            LeftMotorOne.setPower(-1);
            LeftMotorTwo.setPower(-1);

        }else if (gamepad1.left_stick_y < 0 ){

            LeftMotorOne.setPower(1);
            LeftMotorTwo.setPower(1);

        }else {

            LeftMotorOne.setPower(0);
            LeftMotorTwo.setPower(0);

        }

        if(gamepad1.right_stick_y > 0){

            RightMotorOne.setPower(1);
            RightMotorTwo.setPower(1);

        }else if (gamepad1.right_stick_y < 0){

            RightMotorOne.setPower(-1);
            RightMotorTwo.setPower(-1);

        }else {

            RightMotorOne.setPower(0);
            RightMotorTwo.setPower(0);

        }

    }
}
