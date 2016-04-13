package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 7260 on 2/22/2016.
 */
public class TestingMovement extends OpMode {

    DcMotor RightDcMotor;
    DcMotor LeftDcMotor;
    DcMotor UpperDcMotor;
    DcMotor LowerDcMotor;
    Servo MantisLeft;
    Servo MantisRight;

    public void init(){
        RightDcMotor = hardwareMap.dcMotor.get("RightMotor");
        LeftDcMotor = hardwareMap.dcMotor.get("LeftMotor");
        UpperDcMotor = hardwareMap.dcMotor.get("UpperMotor");
        LowerDcMotor = hardwareMap.dcMotor.get("LowerMotor");
        MantisLeft = hardwareMap.servo.get("LeftMantisServo");
        MantisRight = hardwareMap.servo.get("RightMantisServo");

        MantisLeft.setPosition(1);
        MantisRight.setPosition(0);
    }

    public void loop(){

        //
        //Tank Drive Section
        //
        if (gamepad1.left_stick_y>0){
            LeftDcMotor.setPower(0.5);

        }else if (gamepad1.left_stick_y<0){
            LeftDcMotor.setPower(-0.5);

        }else if (gamepad1.left_stick_y==0){
            LeftDcMotor.setPower(0.0);
        }

        if (gamepad1.right_stick_y>0){
            RightDcMotor.setPower(-0.5);

        }else if (gamepad1.right_stick_y<0){
            RightDcMotor.setPower(0.5);

        }else if (gamepad1.right_stick_y==0){
            RightDcMotor.setPower(0.0);
        }

        //
        //Grappling controls
        //
        if (gamepad2.right_stick_y>0){
            UpperDcMotor.setPower(-0.5);
        }else if (gamepad2.right_stick_y<0){
            UpperDcMotor.setPower(0.5);
        }else if(gamepad2.right_stick_y==0){
            UpperDcMotor.setPower(0);
        }

        if (gamepad2.left_stick_y>0){
            LowerDcMotor.setPower(0.2);
        }else if (gamepad2.left_stick_y<0){
            LowerDcMotor.setPower(-0.3);
        }else if (gamepad2.left_stick_y==0){
            LowerDcMotor.setPower(0);
        }

        if (gamepad2.left_bumper == true){
            MantisLeft.setPosition(0);
        }else if (gamepad2.right_bumper == true) {
            MantisRight.setPosition(1);
        }

        if (gamepad2.left_trigger == 1.0){
            MantisLeft.setPosition(1);
        }else if (gamepad2.right_trigger == 1.0){
            MantisRight.setPosition(0);
        }



    }

}
