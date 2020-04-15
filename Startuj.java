package Akustyka;

import Akustyka.gui.*;
import Akustyka.controller.*;
import Akustyka.processor.*;

import javax.swing.*;

/**
*Klasa glowna zawierajaca metode main() wywolywana przez system operacyjnyy
*/
public class Startuj {
    public static void main(String[] args) {
        /**
         *metoda określająca wyglad graficzny aplikacji jako domyslny wyglad systemu
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        Controller controller = new Controller();
        Processor processor = new Processor();
        GUI gui = new GUI(controller);
        controller.setProcessor(processor);
        controller.setGUI(gui);
    }
}
