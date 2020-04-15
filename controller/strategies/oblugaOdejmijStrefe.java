package Akustyka.controller.strategies;

import Akustyka.controller.Controller;
import Akustyka.gui.message.GUIMessage;

/**Szablon obiektu strategi obslugujacej wcisniecie odejmij strefe przelicz*/
public class oblugaOdejmijStrefe implements Strategy {
    private Controller controller;

    public oblugaOdejmijStrefe(Controller controller) {
        this.controller = controller;
    }
    public void algorytm(GUIMessage message) {
        controller.getGUI().odejmijStrefe(controller.getPomIloscStref());
        controller.zmniejsziloscStref();
    }
}
