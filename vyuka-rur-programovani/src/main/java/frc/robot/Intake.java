package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid; //importuje tridu DoubleSolenoid z WPI knihovny
import edu.wpi.first.wpilibj.Timer; //importuje tridu Timer z WPI knihovny

public class Intake {

    RobotMap robotMap; //vytvori novy objekt typu RobotMap bez prirazene hodnoty
    boolean intakeIn; //vytvori novy objekt typu boolean bez prirazene hodnoty
    Timer buttonTimer; //vytvori novy objekt typu Timer bez prirazene hodnoty

    public Intake() {
        robotMap = new RobotMap(); //priradi hodnotu objektu robotMap
        intakeIn = true; //priradi objektu intakeIn hodnotu true - vzdy zaciname se slozenym intakem
        buttonTimer = new Timer(); //priradi objektu buttonTimer
        buttonTimer.reset(); //restartuje casovac buttonTimer abychom si byli jisti, ze zaciname od casu 0.0
    }

    /**
     * Funkce pro roztoceni intaku podle miry zmacknuti leveho triggeru.
     */
    public void spinIntake() {
        robotMap.intakeTalon.set(-robotMap.getTriggers()); //nastavi rychlost otaceni intaku podle toho, jak moc je zmackute tlacitko triggeru
    }

    /**
     * Funkce pro rychle roztoceni intaku opacnym smerem pro uvolneni zaseknuteho mice.
     */
    public void releaseIntake() {
        robotMap.intakeTalon.set(Constants.intakeReleaseSpeed); //nastavi rychlost otaceni intaku smerem ven velkou rychlosti, aby vypadl zaseknuty mic
    }

    /**
     * Funkce pro zastaveni veskere rotace na intaku.
     */
    public void stopIntake() {
        robotMap.intakeTalon.set(0);
    }

    /**
     * Funkce pro vysunuti (rozlozeni) intaku.
     */
    public void intakeOut() {
        robotMap.intakeShift.set(DoubleSolenoid.Value.kForward); //vysune pisty na intaku
    }

    /**
     * Funkce pro zasunuti (slozeni) intaku.
     */
    public void intakeIn() {
        robotMap.intakeShift.set(DoubleSolenoid.Value.kReverse); //zasune pisty na intaku
    }

    /**
     * Funkce pro spousteni periodickych funkci v ramci tridy Intake.
     */
    public void periodic() {
        if(robotMap.leftBumper.get()) {
            releaseIntake(); //bude se otacet tak dlouho, dokud bude zmacknuty levy bumper
        } else if(robotMap.getTriggers() < 0) {
            spinIntake(); //bude se otacet tak dlouho, dokud bude zmacknuty levy trigger - POZOR, z definice getTriggers() vyplyva, ze muze byt zmacknuty pouze jeden trigger, chceme-li umet zmacknout oba triggery najednou, musime zmenit definici teto funkce
        } else {
            stopIntake(); //pokud se intaku nenastavuje jina hodnota, zastavi se
        }

        if(intakeIn && robotMap.buttonX.get() && buttonTimer.get() > Constants.buttonRefreshTime) { //pokud jsou splneny vsechny podminky (intake je zasunuty, tlacitko X je zmacknute a od posledniho stisknuti tlacitka uplynulo vice jak 0.5 vteriny), intake se rozlozi
            intakeOut(); //vysune se intake
            intakeIn = false; //nastavime promennou intakeIn na false - intake je rozlozeny
            buttonTimer.reset(); //nastavime hodnotu casovace na 0.0, abychom zabranili opetovnemu zaregistrovani stisknuti tlacitka
        }

        if(!intakeIn && robotMap.buttonX.get() && buttonTimer.get() > Constants.buttonRefreshTime) { //pokud jsou spleneny vsechny podminky (intake je rozlozeny, tlactko x je zmacknute a od posledniho stisknuti tlacitka uplynulo vice jak 0.5 vteriny), intake se slozi
            intakeIn(); //zasune se intake
            intakeIn = true; //nastavime promennou intakeIn na true - intake je slozeny
            buttonTimer.reset(); //nastavime hodnotu casovace na 0.0, abychom zabranili opetovnemu zaregistrovani stisknuti tlacitka
        }
    }
}