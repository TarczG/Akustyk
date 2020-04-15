package Akustyka.processor;
/**
 *Klasa procesora dla wzorca MVC
 */

public class Processor implements InterfaceProcessor {

    @Override
    /**
     *Implementacja metod mnozenia i dzielenia
     */
    public double pomnoz(double a, double b) {
        return a * b;
    }

    public double podziel(double a, double b) {
        if (b == 0)
            return 0;
        else
            return a / b;
    }
}
