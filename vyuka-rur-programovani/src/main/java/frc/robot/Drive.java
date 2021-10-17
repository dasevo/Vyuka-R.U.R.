package frc.robot;

public class Drive {

    RobotMap robotMap; //novy objekt typu RobotMap bez prirazene hodnoty

    public Drive() { //konstruktor tridy Drive
        robotMap = new RobotMap(); //prirazeni hodnoty k promenne typu RobotMap, abychom meli pristup ke vsem funkcim a promennym uvnicr teto funcke
    }

    /**
     * Funkce pro rizeni robota
     */
    public void drive() {
        robotMap.drive.arcadeDrive(robotMap.getLeftY(), robotMap.getRightX()); 
        //vyuziti funkce drive (patrici ke tride DifferentialDrive), do ktere dosadime funkce z objektu robotMap
        //nyni by se robot mel pohybovat pomoci Y osy leveho joysticku (dopredu/dozadu) a X osy praveho joysticku (otaceni)
    }

    /**
     * Funkce pro shromazdovani periodickych funkci v ramci tridy Drive
     */
    public void periodic() { //v tuto chvili ma tato funkce maly vyznam, jakmile se v teto tride objevi vice funkci, ktere se maji odehravat periodicky, nabyde tato funkce vetsiho vyznamu
        drive();
    }

}