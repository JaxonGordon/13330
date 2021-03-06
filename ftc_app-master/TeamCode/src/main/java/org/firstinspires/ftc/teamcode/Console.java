/*
 * Copyright (c) 2018. RED SHIFT ROBOTICS. All rights reserved.
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

/**
 * A class for debugging that organizes Telemetry messages.
 */

public class Console { // parent class


    private Hardware hardware; // get the context of other classes to use
    private Robot robot;
    private LinearOpMode context;

    public Console(Hardware hardware, Robot robot, LinearOpMode context) { // creates the context in this class
        this.hardware = hardware;
        this.robot = robot;
        this.context = context;
    }

    public Console(LinearOpMode context) {
        this.context = context;
    }


    public void Update() { //updates telemetry so this class can be used anywhere.
        context.telemetry.update();
    }

    public void Log(String caption, Object value) { // a very important essential method that is necessary to the structural integrity of our code.
        context.telemetry.addData(caption, value);
    }

    public void Display(String caption, long time) { //A method used to display your desired message as in progress.
        context.telemetry.addData("Currently", caption);
        context.telemetry.update();
        context.sleep(time);
    }

    public void Status(String status) { //A method used to display your desired message as a 'Status.'
        context.telemetry.addData("status", status);
        context.telemetry.update();
    }

}
