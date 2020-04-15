package Akustyka.controller.strategies;

import Akustyka.controller.Controller;
import Akustyka.gui.message.GUIMessage;

/**Szablon obiektu strategi obslugujacej wcisniecie przycisku Edytuj Strefe*/
public class obslugaEdytujStrefe implements Strategy {
    private Controller controller;
    public obslugaEdytujStrefe(Controller controller) {
        this.controller = controller;
    }
    public void algorytm(GUIMessage message) {
        controller.getGUI().edytujStrefe(message.zwrocStrefe());
    }
}
