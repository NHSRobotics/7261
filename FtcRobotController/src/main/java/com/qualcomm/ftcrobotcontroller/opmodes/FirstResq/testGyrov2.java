package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by 7260 on 1/30/2016.
 */

import com.qualcomm.robotcore.hardware.GyroSensor;

//package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.hardware.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;

/**
 * Created by 7260 on 1/15/2016.
 */
/*public class testGyro2 extends OpMode{
    Movement Chassis;
    GyroSensor gyro;
    int first = 0;



    public void runOpMode() throws InterruptedException {

        GyroSensor sensorGyro;
        int heading = 0;

        Chassis = new Movement(hardwareMap.dcMotor.get("left"), hardwareMap.dcMotor.get("right"));
        sensorGyro = hardwareMap.gyroSensor.get("gyro");

        // write some device information (connection info, name and type)
        // to the log file.
        hardwareMap.logDevices();

        // get a reference to our GyroSensor object.

        // calibrate the gyro.
        sensorGyro.calibrate();

        // wait for the start button to be pressed.
        waitForStart();

        // make sure the gyro is calibrated.
        while (sensorGyro.isCalibrating())  {
            Thread.sleep(50);
        }


        // get the heading info.
        // the Modern Robotics' gyro sensor keeps
        // track of the current heading for the Z axis only.
        heading = sensorGyro.getHeading();

        telemetry.addData("4. h", String.format("%03d", heading));



        telemetry.addData("Head:", gyro.getHeading());


        if (sensorGyro.getHeading() )
            Chassis.rightSpin(.5 * Math.pow(gamepad1.right_stick_x, 2));
        } else if (gamepad1.right_stick_x < 0) {
            Chassis.leftSpin(.5 * Math.pow(gamepad1.right_stick_x, 2));
        } else {
            Chassis.stopDrive();
        }

        if(gamepad1.a) {
            gyro.resetZAxisIntegrator();
        }
    }
}}*/

