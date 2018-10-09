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

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Console { // parent class


    private Hardware hardware; // get the context of other classes to use
    private Robot robot;
    private LinearOpMode context;

    public Console(Hardware hardware, Robot robot, LinearOpMode context) { // creates the context in this class
        this.hardware = hardware;
        this.robot = robot;
        this.context = context;
    }

    public void displayAngles(){ // used to display the current angles.

        context.telemetry.addData("Current Angle:", robot.getAngle());
        context.telemetry.addData("Forward Angle:", hardware.oldAngle.firstAngle);
        context.telemetry.addData("Correction Angle:", hardware.correction);
        context.telemetry.addData("Current Global Angle:", hardware.globalAngle);

        context.telemetry.update();

    }

    public void displayColorData(){ // used to get the color sensor's color average and difference.

        context.telemetry.addLine();
        context.telemetry.addData("Color Sensor Status: ", "");
        context.telemetry.addData(" > RED", hardware.color_sensor_1.red());
        context.telemetry.addData(" > GREEN", hardware.color_sensor_1.green());
        context.telemetry.addData(" > BLUE", hardware.color_sensor_1.blue());

        context.telemetry.addLine();

        context.telemetry.addLine();
        if (hardware.color_sensor_1.red() + hardware.color_sensor_1.green() + hardware.color_sensor_1.blue()/3 > 70){
            context.telemetry.addData("Mineral is Silver.", "");

        } else if(hardware.color_sensor_1.red() + hardware.color_sensor_1.green() + hardware.color_sensor_1.blue()/3 < 70 && hardware.color_sensor_1.red() + hardware.color_sensor_1.green() + hardware.color_sensor_1.blue()/3 > 20) {
            context.telemetry.addData("Mineral is Gold.", "");
        } else {
            context.telemetry.addData("No Mineral seen.","");
        }

        context.telemetry.update();

    }

    public void displayStatistics(double versionName, String type){ // used to display the statistics.

        context.telemetry.addData("Action:", "waiting for start");
        context.telemetry.addData("IMU Status: ", hardware.imu.getCalibrationStatus().toString());
        context.telemetry.addData(type + " Version: ", "v" + versionName);

        context.telemetry.update();

    }

    public void Log(String caption, String text){ // a very important essential method that is necessary to the structural integrity of our code.
        context.telemetry.addData(caption, text);
        context.telemetry.update();
    }

}
