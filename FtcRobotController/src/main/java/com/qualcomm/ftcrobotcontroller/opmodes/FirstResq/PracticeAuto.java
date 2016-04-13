package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by 7260 on 11/9/2015.
 */
public class PracticeAuto extends LinearOpMode {

    MovementAuto Chassis;

    @Override
    public void runOpMode() throws InterruptedException {
        Chassis = new MovementAuto(hardwareMap.dcMotor.get("left"), hardwareMap.dcMotor.get("right"));

        Chassis.forwardDriveAuto(10.0);


        //telemetry.addData("Counts:", Chasis.counts);
    }

}
