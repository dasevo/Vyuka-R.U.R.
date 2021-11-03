package frc.robot;

public class Intake {

    RobotMap robotMap; //vytvori novy objekt typu RobotMap bez prirazene hodnoty

    public Intake() {
        robotMap = new RobotMap(); //priradi hodnotu objektu robotMap
    }

    public void spinIntake() {
        robotMap.intakeTalon.set(-robotMap.getTriggers()); //nastavi rychlost otaceni intaku podle toho, jak moc je zmackute tlacitko triggeru
    }

    public void releaseIntake() {
        robotMap.intakeTalon.set(-0.75); //nastavi rychlost otaceni intaku smerem ven velkou rychlosti, aby vypadl zaseknuty mic
    }

    public void stopIntake() {
        robotMap.intakeTalon.set(0);
    }

    public void periodic() {
        if(robotMap.leftBumper.get()) {
            releaseIntake(); //bude se otacet tak dlouho, dokud bude zmacknuty levy bumper
        } else if(robotMap.getTriggers() < 0) {
            spinIntake(); //bude se otacet tak dlouho, dokud bude zmacknuty levy trigger - POZOR, z definice getTriggers() vyplyva, ze muze byt zmacknuty pouze jeden trigger, chceme-li umet zmacknout oba triggery najednou, musime zmenit definici teto funkce
        } else {
            stopIntake(); //pokud se intaku nenastavuje jina hodnota, zastavi se
        }
    }
}