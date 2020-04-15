package Akustyka.gui.message;
/**
 * Klasa abstrakcyjna będąca wzorcem dla klas wiadomości przesyłanych z GUI obiektowi kontrolera
 */
public abstract class GUIMessage {
    /**Dana przechowujaca opis komunikatu */
    private String opis;
    /**Dana przechowujaca rodzaj strefy przy wysylaniu komunikatu */
    private int strefa = 0;
    /**Dana przechowujaca rodzaj pomieszczenia przy wysylaniu komunikatu */
    private int pomieszczenie = 1;
    /**Dana przechowujaca odpornosc akustyczna dla konkretnego przedzialu procentowego 0-25 */
    private int zakres0 = 0;
    /**Dana przechowujaca odpornosc akustyczna dla konkretnego przedzialu procentowego 25-50 */
    private int zakres25 = 0;
    /**Dana przechowujaca odpornosc akustyczna dla konkretnego przedzialu procentowego 50-75 */
    private int zakres50 = 0;
    /**Dana przechowujaca odpornosc akustyczna dla konkretnego przedzialu procentowego 75-100 */
    private int zakres75 = 0;
    /**Dane przechowujaca dane pwrowadzane przez uzytkownika */
    private double szerOkna, wysOkna, szerSciany;

    /**Konstruktor zamieniajacy daną opisu z przyjetego parametru */
    public GUIMessage(String opis) {
        this.opis = opis;
    }

    /**Metoda zwracajaca opis komunikatu */
    public String zwrocOpis() {
        return opis;
    }
    /**Metoda zmieniajaca rodzaj strefy */
    public void zmienStrefe(int strefa) {
        this.strefa = strefa;
    }
    /**Metoda zmieniajaca rodzaj pomieszczenia */
    public void zmienRodzajPomieszczenia(int pomieszczenie) {
        this.pomieszczenie = pomieszczenie;
    }
    /**Metoda zmieniajaca wysokosc okna */
    public void zmienWysokoscOkna(double wysOkna) {
        this.wysOkna = wysOkna;
    }
    /**Metoda zmieniajaca szerokosc okna */
    public void zmienSzerokoscOkna(double szerOkna) {
        this.szerOkna = szerOkna;
    }
    /**Metoda zmieniajaca szerokosc sciany */
    public void zmienSzerokoscSciany(double szerSciany) {
        this.szerSciany = szerSciany;
    }

    /**Metoda zwracajaca rodzaj strefy */
    public int zwrocStrefe() {
        return strefa;
    }
    /**Metoda zwracajaca rodzaj pomieszczenia */
    public int zwrocPomieszczenie() {
        return pomieszczenie;
    }
    /**Metoda zwracajaca szerokosc okna */
    public double zwrocSzerokoscOkna() {
        return szerOkna;
    }
    /**Metoda zwracajaca szerokosc sciany */
    public double zwrocSzerokoscSciany() {
        return szerSciany;
    }
    /**Metoda zwracajaca wysokosc okna*/
    public double zwrocWysokoscOkna() {
        return wysOkna;
    }

    /**Metoda ustawiajaca parametry dla konkretnych przedzialow procentowyych */
    public void pobierzparametrystref(int a, int b, int c, int d) {
        zakres0 = a;
        zakres25 = b;
        zakres50 = c;
        zakres75 = d;
    }

    /**Metoda zwracajaca wartosci do listyStref w obietkcie kontrolera w zakresie 0-25*/
    public int zwroczakres0() {
        return zakres0;
    }
    /**Metoda zwracajaca wartosci do listyStref w obietkcie kontrolera w zakresie 25-50*/
    public int zwroczakres25() {
        return zakres25;
    }
    /**Metoda zwracajaca wartosci do listyStref w obietkcie kontrolera w zakresie 50-75*/
    public int zwroczakres50() {
        return zakres50;
    }
    /**Metoda zwracajaca wartosci do listyStref w obietkcie kontrolera w zakresie 75-100*/
    public int zwroczakres75() {
        return zakres75;
    }
}
