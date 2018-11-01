/* Copyright (c) 2017 FIRST. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification,
* are permitted (subject to the limitations in the disclaimer below) provided that
* the following conditions are met:
*
* Redistributions of source code must retain the above copyright notice, this list
* of conditions and the following disclaimer.
*
* Redistributions in binary form must reproduce the above copyright notice, this
* list of conditions and the following disclaimer in the documentation and/or
* other materials provided with the distribution.
*
* Neither the name of FIRST nor the names of its contributors may be used to endorse or
* promote products derived from this software without specific prior written permission.
*
* NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
* LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
* "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
* THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
* ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
* FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
* DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
* CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
* OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
* OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


public class Hardware { // Here we get the DcMotors from the REV hub and assign their names.


    public DcMotor front_right_motor; // motor initialization
    public DcMotor front_left_motor;
    public DcMotor back_right_motor;
    public DcMotor back_left_motor;

    public DcMotor lifter;
    public DcMotor arm;
    public Servo mineralKicker;

    public DcMotor.ZeroPowerBehavior zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT;

    public ColorSensor color_sensor_1;

    public BNO055IMU imu; // imu initialization.
    public Orientation oldAngle = new Orientation();
    public Orientation angles = new Orientation();


    public double globalAngle;
    public double correction;
    public int[] armValues = {0,1,2};
    public int currentArmValue = armValues[0];


    public boolean topSpeed = false;
    public double maxSpeed = 1;
    public double minSpeed = 0.3;
    public double speed = minSpeed;

    //encoders!

    public double GEAR_RATIO = 1;
    public double WHEEL_DIAMETER = 4;
    public double COLOR_SENSOR_DISTANCE = 3.5;
    double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;

    public Hardware(OpMode context) { // this class gets all the motors, sensors, and imu and hooks it up to the hardware map.



        imu = context.hardwareMap.get(BNO055IMU.class, "imu");

        BNO055IMU.Parameters imuParameters = new BNO055IMU.Parameters();

        imuParameters.mode                = BNO055IMU.SensorMode.IMU;
        imuParameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        imuParameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        imuParameters.loggingEnabled      = false;

        imu.initialize(imuParameters);


        front_left_motor = context.hardwareMap.dcMotor.get("front_left_motor");
        back_left_motor = context.hardwareMap.dcMotor.get("back_left_motor");

        front_right_motor = context.hardwareMap.dcMotor.get("front_right_motor");
        back_right_motor = context.hardwareMap.dcMotor.get("back_right_motor");

        lifter = context.hardwareMap.dcMotor.get("lifter");
        mineralKicker = context.hardwareMap.servo.get("mineralKicker");

        color_sensor_1 = context.hardwareMap.colorSensor.get("color_sensor_1");

        front_right_motor.setDirection(DcMotor.Direction.FORWARD);
        back_right_motor.setDirection(DcMotor.Direction.FORWARD);

        front_left_motor.setDirection(DcMotor.Direction.REVERSE);
        back_left_motor.setDirection(DcMotor.Direction.REVERSE);

        back_left_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_left_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        back_right_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_right_motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        front_left_motor.setZeroPowerBehavior(zeroPowerBehavior);
        back_left_motor.setZeroPowerBehavior(zeroPowerBehavior);

        front_right_motor.setZeroPowerBehavior(zeroPowerBehavior);
        back_right_motor.setZeroPowerBehavior(zeroPowerBehavior);


        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);


    }

// this blank space was added to allow its github commit count to reach 100. Cheers.

}
