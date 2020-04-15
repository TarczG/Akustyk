package Akustyka.controller;

import Akustyka.gui.message.*;

/**Interfejs obiektu kontrolera wykorzystywany przez obiekt GUI i Obiekty implemetujace interfejs Strategy*/
public interface InterfaceController {
    /**Metoda umozliwiajaca wysylania informacji wiadomosci do kontrolera */
    public void sendInfo(GUIMessage message);
    /**Metoda umozliwiajaca pobranie wartosci listaStref z obiektu kontrolera */
    public int[][] zwrocTabliceStref();
}
