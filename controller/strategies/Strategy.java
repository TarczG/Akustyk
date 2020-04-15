package Akustyka.controller.strategies;

import Akustyka.gui.message.GUIMessage;

/**Interfejs obiektu strategi wykorzystywany przez obiekt kontrolera , udostepniajacy mu metode algorytmu z parametrem otrzymanej wiadomosci*/
public interface Strategy {
    public void algorytm(GUIMessage message);

}
