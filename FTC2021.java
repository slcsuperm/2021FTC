package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@TeleOp(name="test program", group="Iterative OpMode")

public class Test2021 extends OpMode{
    
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor rearLeft;
    private DcMotor rearRight;
    
    private DcMotor intake;
    
    private DcMotor spinner;

    @Override
    public void init(){
        
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        rearRight = hardwareMap.get(DcMotor.class, "rearRight");
        
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        rearLeft.setDirection(DcMotor.Direction.REVERSE);
        rearRight.setDirection(DcMotor.Direction.FORWARD);
        
        intake = hardwareMap.get(DcMotor.class, "intake");
        intake.setDirection(DcMotor.Direction.REVERSE);
        
        spinner = hardwareMap.get(DcMotor.class, "spinner");
        spinner.setDirection(DcMotor.Direction.FORWARD);
        
    }
    
    @Override
    public void start(){
    }
    
    @Override
    public void loop(){
        
        double drive = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;
        
        frontLeft.setPower(drive + strafe + turn);
        frontRight.setPower(drive - strafe - turn);
        rearLeft.setPower(drive - strafe + turn);
        rearRight.setPower(drive + strafe - turn);
        
        
        if(gamepad1.a){
            intake.setPower(1);
        } else {
            intake.setPower(0);
        }
        
        if(gamepad1.b){
            spinner.setPower(1);
        } else {
            spinner.setPower(0);
        }
        
    }
    // todo: write your code here
}