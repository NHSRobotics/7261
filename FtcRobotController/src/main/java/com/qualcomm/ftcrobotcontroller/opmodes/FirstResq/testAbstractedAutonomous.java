package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.hardware.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.LegacyModule;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by 7260 on 2/25/2016.
 */
public class testAbstractedAutonomous extends OpMode {

    MovementAuto Chassis;
    Servo climberArm;                       //Servo that holds and drops the climbers into the bucket
    Servo leftsideArm;                      //Servo that rotates on the left-side of the chassis to hit the climber levers on the mountain
    Servo rightsideArm;                     //Servo that rotates on the right-side of the chassis to hit the climber levers on the mountain
    Servo rightsideButton;
    Servo leftsideButton;
    Servo colorArm;
    ColorSensor RGBSensor;
    UltrasonicSensor eyes;
    ModernRoboticsI2cGyro gyro;

    public int state = 0;

    public void init(){
        Chassis = new MovementAuto(hardwareMap.dcMotor.get("left"), hardwareMap.dcMotor.get("right"));
        climberArm = hardwareMap.servo.get("climber");
        leftsideArm = hardwareMap.servo.get("leftFlipper");
        rightsideArm = hardwareMap.servo.get("rightFlipper");
        rightsideButton = hardwareMap.servo.get("rightButton");
        leftsideButton = hardwareMap.servo.get("leftButton");
        colorArm = hardwareMap.servo.get("colorArm");
        RGBSensor = hardwareMap.colorSensor.get("color");
        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("gyro");

        gyro.calibrate();
        Chassis.resetEncoders();

        LegacyModule legacy = hardwareMap.legacyModule.get("legacy");

        legacy.enable9v(5, true);

        eyes = hardwareMap.ultrasonicSensor.get("eyes");

        climberArm.setPosition(.5);
        leftsideArm.setPosition(.58);
        rightsideArm.setPosition(0);
        colorArm.setPosition(0);
        rightsideButton.setPosition(1);
        leftsideButton.setPosition(0);
    }

    public void loop(){
        switch (state) {
            case 0:
                Chassis.resetEncoders();
                if(!(gyro.isCalibrating()))
                    state++;
                break;
            case 1:
                if(Chassis.forwardDriveAuto(24)){
                    state++;
                }
                break;
            case 2:
                //if(Chassis.)
                break;

            default:
                break;

        }
    }
}
