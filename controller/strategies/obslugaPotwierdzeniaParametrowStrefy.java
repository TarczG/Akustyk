package Akustyka.controller.strategies;

import Akustyka.controller.Controller;
import Akustyka.gui.message.GUIMessage;

/**Szablon obiektu strategi obslugujacej wcisniecie przycisku potwierdzenia Parametrów edytowanej strefy*/
public class obslugaPotwierdzeniaParametrowStrefy implements Strategy {
    private Controller controller;

    public obslugaPotwierdzeniaParametrowStrefy(Controller controller) {
        this.controller = controller;
    }
    @Override
    public void algorytm(GUIMessage message) {
        controller.zwrocTabliceStref()[message.zwrocStrefe()][0] = message.zwroczakres0();
        controller.zwrocTabliceStref()[message.zwrocStrefe()][1] = message.zwroczakres25();
        controller.zwrocTabliceStref()[message.zwrocStrefe()][2] = message.zwroczakres50();
        controller.zwrocTabliceStref()[message.zwrocStrefe()][3] = message.zwroczakres75();
    }
}