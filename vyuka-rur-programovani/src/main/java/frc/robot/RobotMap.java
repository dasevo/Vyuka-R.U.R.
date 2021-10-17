package frc.robot;

import edu.wpi.first.wpilibj.XboxController; //importuje tridu XboxController z WPI knihovny
import edu.wpi.first.wpilibj.buttons.JoystickButton; //importuje tridu JoystickButton ze slozky buttons z WPI knihovny
import edu.wpi.first.wpilibj.buttons.Button; //importuje tridu Button ze slozky buttons z WPI knihovny
import edu.wpi.first.wpilibj.GenericHID; //importuje trigu GenericHid z WPI knihovny

public class RobotMap {
    
    public RobotMap() { //konstruktor pro tridu RobotMap

    }
    
    final XboxController controller = new XboxController(0); //vytvori novy objekt ovladace, na ktery se muzeme ovladat v nasledujicich funkcich
    final Button buttonA = new JoystickButton(controller, 0); //vytvori novy objekt tlacitka na vyse definovanem ovladaci, diky kteremu muzeme sledovat, zda je toto tlacitko zmacknute
    final Button buttonB = new JoystickButton(controller, 1); //vytvori novy objekt tlacitka na vyse definovanem ovladaci, diky kteremu muzeme sledovat, zda je toto tlacitko zmacknute
    final Button buttonX = new JoystickButton(controller, 2); //vytvori novy objekt tlacitka na vyse definovanem ovladaci, diky kteremu muzeme sledovat, zda je toto tlacitko zmacknute
    final Button buttonY = new JoystickButton(controller, 3); //vytvori novy objekt tlacitka na vyse definovanem ovladaci, diky kteremu muzeme sledovat, zda je toto tlacitko zmacknute

    /**
     * Funkce pro filtrovani malych hodnot (< 0.2)
     * @param input double ktery by mel byt porovnan s hranicni hodnotou.
     * @return dobule input pokud je vetsi nez hranicni hodnota, jinak 0.
     */
    public double deadzone (double input) {
        if(Math.abs(input) > 0.2){ return input; } //jednoradkova if struktura, pokud je hodnota promenne input vetsi nez 0.2, je vracena
        else { return 0; } //jednoradkova else struktura, pokud neplati podminka v if-strukture, vrati 0
    }

    /**
     * Funkce pro zjistovani hodnoty y osy na levem joysticku.
     * @return hodnota y leveho joysticku oriznuta o male hodnoty.
     */
    public double getLeftY() { return -deadzone(controller.getY(GenericHID.Hand.kLeft)); } //jednoradkova funkce, ktera vraci soucasnou hodnotu leveho joysticku na ose Y

    /**
     * Funkce pro zjistovani hodnoty x osy na levem joysticku.
     * @return hodnota x leveho joysticku oriznuta o male hodnoty.
     */
    public double getLeftX() { return deadzone(controller.getX(GenericHID.Hand.kLeft)); } //jednoradkova funkce, ktera vraci soucasnou hodnotu leveho joysticku na ose X

    /**
     * Funkce pro zjistovani hodnoty y osy na pravem joysticku.
     * @return hodnota y praveho joysticku oriznuta o male hodnoty.
     */
    public double getRightY() { return -deadzone(controller.getY(GenericHID.Hand.kRight)); } //jednoradkova funkce, ktera vraci soucasnou hodnotu praveho joysticku na ose Y

    /**
     * Funkce pro zjistovani hodnoty x osy na pravem joysticku.
     * @return hodnota x praveho joysticku oriznuta o male hodnoty.
     */
    public double getRightX() { return deadzone(controller.getX(GenericHID.Hand.kRight)); } //jednoradkova funkce, ktera vraci soucasnou hodnotu praveho joysticku na ose X

}