package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by julian on 12/18/18.
 */

public class MecanumChassis {

    public DcMotor frontRightMotor;
    public DcMotor frontLeftMotor;
    public DcMotor backRightMotor;
    public DcMotor backLeftMotor;

    double frontLeftPower;
    double backLeftPower;
    double frontRightPower;
    double backRightPower;

    public void MecanumChassis(LinearOpMode context, DcMotor.ZeroPowerBehavior zeroPowerBehavior) { // creates the context in this class
        //region frontLeftMotor
        frontLeftMotor = context.hardwareMap.dcMotor.get("frontLeftMotor");
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setZeroPowerBehavior(zeroPowerBehavior);
        //endregion

        //region backLeftMotor
        backLeftMotor = context.hardwareMap.dcMotor.get("backLeftMotor");
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setZeroPowerBehavior(zeroPowerBehavior);
        //endregion

        //region frontRightMotor
        frontRightMotor = context.hardwareMap.dcMotor.get("frontRightMotor");
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setZeroPowerBehavior(zeroPowerBehavior);
        //endregion

        //region backRightMotor
        backRightMotor = context.hardwareMap.dcMotor.get("backRightMotor");
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setZeroPowerBehavior(zeroPowerBehavior);
        //endregion
    }

    public void localDrive(double drive, double rotate, double strafe){
        frontLeftPower = drive + strafe + rotate;
        backLeftPower = drive - strafe + rotate;
        frontRightPower = drive - strafe - rotate;
        backRightPower = drive + strafe - rotate;

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }

    public void globalDrive(double drive, double rotate, double strafe){

    }
}
