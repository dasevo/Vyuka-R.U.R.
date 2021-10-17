package frc.robot;

public class Drive {

    RobotMap robotMap; //novy objekt typu RobotMap bez prirazene hodnoty

    public Drive() { //konstruktor tridy Drive
        robotMap = new RobotMap(); //prirazeni hodnoty k promenne typu RobotMap, abychom meli pristup ke vsem funkcim a promennym uvnicr teto funcke
    }

}