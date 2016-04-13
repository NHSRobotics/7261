package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by phama21 on 9/12/2015.
 */

/*
    MovementAuto class that creates common methods used for movement in autonoumous files
 */
public class MovementAuto extends Movement {

    //private DcMotor leftMotor;              //Declares DcMotor object
    //private DcMotor rightMotor;             //Declares DcMotor object

    final static int ENCODER_CPR = 1120;    //Constant of how many counts/rotation the encoder counts
    private double gearRatio = 1;               //Declares double variable which holds the gear ratio
    private double wheelDiameter = 4;              //Declares int variable which holds the wheel's diameter
    public double counts;

    /*
        Constructor method that initializes most of the variables and objects
        @param  left            the left side motors
        @param  right           the right side motors
        @param  WheelDiameter   the diameter of the wheel
        @param  GearRatio       the gear ratio
     */
    public MovementAuto(DcMotor left, DcMotor right) {
        super(left, right);

        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);

    }

    public boolean checkEncoderReset(){
        return true;
    }

    public boolean forwardDriveAuto(double distance) {
        runUsingEncoders();

        //
        //Moves the chassis forward at half speed
        //
        leftMotor.setPower(.3);
        rightMotor.setPower(.3);

        //
        //Calculates the number of counts the encoders have to reach in order to go 2ft
        //
        counts = ENCODER_CPR * (24 / (Math.PI * wheelDiameter)) * gearRatio;

        //
        //Checks if the motors have ran to 2ft
        //
        //After reaching 2ft, stops the motors and resets the encoders
        //
        if (Math.abs(leftMotor.getCurrentPosition()) >= counts && Math.abs(rightMotor.getCurrentPosition()) >= counts) {
            leftMotor.setPower(0);
            rightMotor.setPower(0);

            resetEncoders();

            return true;
        } else {
            return false;
        }
    }

    public void resetEncoders() {
        leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

    public void runUsingEncoders() {
        leftMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        rightMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
    }
}
