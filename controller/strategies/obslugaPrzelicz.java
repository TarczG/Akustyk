package Akustyka.controller.strategies;

import Akustyka.controller.Controller;
import Akustyka.gui.message.GUIMessage;
import java.text.DecimalFormat;

/**Szablon obiektu strategi obslugujacej wcisniecie przycisku przelicz*/

public class obslugaPrzelicz implements Strategy {
    private Controller controller;

    public obslugaPrzelicz(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void algorytm(GUIMessage message) {
        double powierzchniaszklenia = 0;
        double powierzchniaSciany = 0;
        double procentszklenia = 0;
        int kategoria = 0;
        int wynik = 0;
        DecimalFormat formatdf = new DecimalFormat("0.00");

        powierzchniaszklenia = controller.getProcessor().pomnoz((double) message.zwrocSzerokoscOkna(), (double) message.zwrocWysokoscOkna());
        powierzchniaSciany = controller.getProcessor().pomnoz((double) message.zwrocSzerokoscSciany(), (double) controller.getWysokoscPomieszczenia());
        procentszklenia = controller.getProcessor().pomnoz(100, controller.getProcessor().podziel(powierzchniaszklenia, powierzchniaSciany));

        if (procentszklenia < 25)
            kategoria = 0;
        else if (procentszklenia < 50)
            kategoria = 1;
        else if (procentszklenia < 75)
            kategoria = 2;
        else
            kategoria = 3;

        wynik = controller.listastref[message.zwrocStrefe()][kategoria];

        if (message.zwrocPomieszczenie() == 2)
            wynik = wynik + 5;
        controller.getGUI().setDisplay(Integer.toString((int) powierzchniaszklenia), formatdf.format(procentszklenia), Integer.toString(wynik));
    }
}
