package Akustyka.controller.strategies;

import Akustyka.controller.Controller;
import Akustyka.gui.message.GUIMessage;

/**Szablon obiektu strategi obslugujacej wcisniecie przycisku dodaj strefe*/
public class obslugaDodajStrefe implements Strategy {
    private Controller controller;
    public obslugaDodajStrefe(Controller controller) {
        this.controller = controller;
    }
    @Override
    public void algorytm(GUIMessage message) {
        controller.getGUI().dodajStrefe(controller.getPomIloscStref());
        controller.zwieksziloscStref();
    }
}
