package Akustyka.controller;

import Akustyka.gui.InterfaceGUI;
import Akustyka.gui.message.GUIMessage;
import Akustyka.processor.InterfaceProcessor;
import Akustyka.controller.strategies.*;

/**Szablon obiektu kontrolera dla wzorca MVC*/
public class Controller implements InterfaceController {
    /**Referencja do procesora*/
    private InterfaceProcessor interfaceProcessor;
    /**Referencja do GUI*/
    public InterfaceGUI interfaceGUI;

    /**Obiekt strategy dla wzrorca Strategy*/
    private Strategy strategy;
    /**Obiekt oblugaOdejmijStrefe implementujacy interfejs Strategy*/
    private oblugaOdejmijStrefe oblugaOdejmijStrefe;
    /**Obiekt obslugaDodajStrefe implementujacy interfejs Strategy*/
    private obslugaDodajStrefe obslugaDodajStrefe;
    /**Obiekt obslugaPrzelicz implementujacy interfejs Strategy*/
    private obslugaPrzelicz obslugaPrzelicz;
    /**Obiekt obslugaPotwierdzeniaParametrowStrefy implementujacy interfejs Strategy*/
    private obslugaPotwierdzeniaParametrowStrefy obslugaPotwierdzeniaParametrowStrefy;
    /**Obiekt obslugaEdytujStrefe implementujacy interfejs Strategy*/
    private obslugaEdytujStrefe obslugaEdytujStrefe;

    /**Zmienna przechowujaca ilosc dodanych stref */
    int pomIloscStref = 0;
    /**Zmienna przechowujaca wysokosc pomieszczenia */
    double wysPomieszczenia = 300;
    /**Zmienna przechowujaca parametry dla konkretnych stref w zaleznosci od %przeszklenia */
    public int listastref[][] = new int[5][4];

    /**Konstruktor kontrolera tworzący obiekty strategi oraz wypelniajace podstawowe 2 strefy - wiersze i ich dane w zaleznosci od zakresu % - kolumny*/
    public Controller() {
        obslugaPotwierdzeniaParametrowStrefy = new obslugaPotwierdzeniaParametrowStrefy(this);
        oblugaOdejmijStrefe = new oblugaOdejmijStrefe(this);
        obslugaDodajStrefe = new obslugaDodajStrefe(this);
        obslugaPrzelicz = new obslugaPrzelicz(this);
        obslugaEdytujStrefe = new obslugaEdytujStrefe(this);
        strategy = obslugaPrzelicz;

        listastref[0][0] = 30;
        listastref[0][1] = 32;
        listastref[0][2] = 33;
        listastref[0][3] = 35;

        listastref[1][0] = 21;
        listastref[1][1] = 23;
        listastref[1][2] = 27;
        listastref[1][3] = 29;
    }
    /**Metoda zwiekszajaca ilosc dodanych stref o 1*/
    public void zwieksziloscStref() {
        if (pomIloscStref < 3)
            pomIloscStref++;
    }

    /**Metoda zmniejszajaca ilosc dodanych stref o 1*/
    public void zmniejsziloscStref() {
        if (pomIloscStref > 0)
            pomIloscStref--;
    }

    /**Metoda zwracajaca listestref*/
    public int[][] zwrocTabliceStref() {
        return listastref;
    }

    /**Metoda zwracajaca obiekt GUI*/
    public InterfaceGUI getGUI() {
        return interfaceGUI;
    }

    /**Metoda zwracajaca zmienna pomIloscStref*/
    public int getPomIloscStref() {
        return pomIloscStref;
    }

    /**Metoda ustawiajaca obiekt GUI*/
    public void setGUI(InterfaceGUI interfaceGUI) {
        this.interfaceGUI = interfaceGUI;
    }

    /**Metoda ustawiajaca obiekt Procesora*/
    public void setProcessor(InterfaceProcessor interfaceProcessor) {
        this.interfaceProcessor = interfaceProcessor;
    }

    /**Metoda zwracajaca obiekt Procesora*/
    public InterfaceProcessor getProcessor() {
        return interfaceProcessor;
    }

    /**Metoda zwracajaca zmienna wysPomieszczenia*/
    public double getWysokoscPomieszczenia() {
        return wysPomieszczenia;
    }

    /**Metoda ustawiajaca odpowiednie strategie w zależności od otrzymanej wiadomosci z obiektu GUI*/
    @Override
    public void sendInfo(GUIMessage message) {
        if (message.zwrocOpis() == "Wcisnieto odejmij strefe") {
            strategy = oblugaOdejmijStrefe;
        }
        if (message.zwrocOpis() == "Wcisnieto dodaj strefe") {
            strategy = obslugaDodajStrefe;
        }
        if (message.zwrocOpis() == "Wcisnieto przelicz") {
            strategy = obslugaPrzelicz;
        }
        if (message.zwrocOpis() == "Wcisnieto edytuj strefe") {
            strategy = obslugaEdytujStrefe;
        }
        if (message.zwrocOpis() == "Wcisnieto potwierdzenie parametrow strefy") {
            strategy = obslugaPotwierdzeniaParametrowStrefy;
        }
        strategy.algorytm(message);
    }
}
