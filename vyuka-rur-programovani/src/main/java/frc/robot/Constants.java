package frc.robot;

public class Constants { //trida, do ktere se ukladaji konstantni hodnoty, abychom je mohli snadno upravovat

    //buttons
    public static final double buttonRefreshTime = 0.5; //ve vterinach

    //drive
    public static final double slowDriveRatio = 0.75;

    //intake
    public static final double intakeReleaseSpeed = -0.75;

    //motor controllers
    public static final int frontLeftTalon = 1;
    public static final int frontRightTalon = 1;
    public static final int rearLeftTalon = 1;
    public static final int rearRightTalon = 1;
    public static final int intakeTalon = 0;

    //pneumatics
    public static final int intakeSolenoidIn = 0;
    public static final int intakeSolenoidOut = 1;
    public static final int compressor = 0;

    //setup
    public static final double deadzone = 0.2;
    public static final int timeoutMs = 10;

}