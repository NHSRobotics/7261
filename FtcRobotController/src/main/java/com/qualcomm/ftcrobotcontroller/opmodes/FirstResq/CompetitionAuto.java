package com.qualcomm.ftcrobotcontroller.opmodes.FirstResq;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by 7260 on 11/21/2015.
 */
public class CompetitionAuto extends LinearOpMode {

    public void runOpMode() throws InterruptedException {

        Movement Chassis = new Movement(hardwareMap.dcMotor.get("left"), hardwareMap.dcMotor.get("right"));

        Chassis.leftMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        Chassis.rightMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);


        Chassis.forwardDrive(.25);
        sleep(1000);

        Chassis.leftSpin(.25);
        sleep(1000);

        Chassis.rightSpin(.25);
        sleep(1000);

        Chassis.reverseDrive(.25);
        sleep(1000);

        Chassis.stopDrive();

    }
}
