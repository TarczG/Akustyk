package Akustyka.gui;
/**
 * Interfejs GUI wykorzystywany przez obiekt kontrolera i udostepniajacy mu metody wyswietlania, oraz obslugi zdarzen
 */
public interface InterfaceGUI {
    /**Metoda umozliwiajaca zmiane napisow na wyswietlaczu aplikacji*/
    public void setDisplay(String number1, String number2, String number3);
    /**Metoda umozliwiajaca zmiane gui przez odjecie komponentu JRadioButton udostepniana dla obiektu kontrolera*/
    public void odejmijStrefe(int nrpomieszczenia);
    /**Metoda umozliwiajaca zmiane gui przez dodanie komponentu JRadioButton udostepniana dla obiektu kontrolera*/
    public void dodajStrefe(int nrStrefy);
    /**Metoda umozliwiajaca pobranie z gui parametrow zaktualizowanych stref udostepniana dla obiektu kontrolera*/
    public void edytujStrefe(int nrStrefy);
}
