package Akustyka.gui;

import Akustyka.controller.*;
import Akustyka.gui.message.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
/**
 * Szablon obiektu interfejsu graficznego GUI wykorzystujacego SWING.
 */
public class GUI implements ItemListener, InterfaceGUI {

    /**Referencja do obiektu kontrolera*/
    private InterfaceController interfacecontroller;

    /**Referencja listy dla dodawanych stref. Pierwsze 2 strefy są istniejące i wynikają z założeń programu*/
    List<JRadioButton> listaStref = new ArrayList<>();

    /**Referencja do głównego kontenera aplikacji*/
    JFrame frame = new JFrame("Decybel");

    /**Referencja do kontenera umożliwiajaącego zmianę parametrów stref*/
    JFrame parametryStrefy = new JFrame("Parametry Strefy");

    /**Referencja do komunikatów o wcisnieciu konkretnych przyciskow */
    GUIMessage wcisnietoPrzelicz = new wcisnietoPrzelicz();
    GUIMessage wcisnietoDodajStrefe = new wcisnietoDodajStrefe();
    GUIMessage wcisnietoPotwierdzenieParametrowStrefy = new wcisnietoPotwierdzenieParametrowStrefy();
    GUIMessage wcisnietoOdejmijStrefe = new wcisnietoOdejmijStrefe();
    GUIMessage wcisnietoEdytujStrefe = new wcisnietoEdytujStrefe();

    /**Obiekt klasy wewnętrznej będący szablonem obsługi wcisnięcia przycisku */
    ButoonListenerImplementation buttonlistener = new ButoonListenerImplementation();

    /**Lista Stringów do uzytych do konstruowania etykiet */
    String[] listJlabelPanel1 = {"Wysokosc okna [cm]: ", "Szerokosc okna [cm]: ", "Szerokosc sciany [cm]: ",};
    String[] listJlabelPanel3 = {"Powierzchnia szklenia: ", "% Szklenia: ", "Odpornosc [dB]: "};

    /**Zbiór JButtonów zawartych w kontenerze głównym oraz pomocniczym */
    JButton przelicz = new JButton("Przelicz");
    JButton dodajStrefe = new JButton("Dodaj strefe");
    JButton odejmijStrefe = new JButton("Odejmij strefe");
    JButton edytujStrefe = new JButton("Edytuj strefe");
    JButton dodaj = new JButton("OK");

    /**Zbiór kontenerów pomocniczych dla konteneru frame */
    JPanel jpanel1 = new JPanel();
    JPanel jpanel2 = new JPanel();
    JPanel jpanel3 = new JPanel();

    /**Zbiór pól tekstowych użytych w kontenrach frame */
    JTextField textHO = new JTextField();
    JTextField textSO = new JTextField();
    JTextField textSciany = new JTextField();
    JTextField[] listJTextField1 = {textHO, textSO, textSciany};

    /**Grupa JRadioButtonow do wyboru strefy */
    ButtonGroup bg1 = new ButtonGroup();
    JRadioButton j1 = new JRadioButton("Strefa 0", true);
    JRadioButton j2 = new JRadioButton("Strefa 1", false);

    /**Grupa JRadioButtonow do wyboru rodzaju pomieszczenia */
    ButtonGroup bg2 = new ButtonGroup();
    JRadioButton r1 = new JRadioButton("Kuchnia", true);
    JRadioButton r2 = new JRadioButton("Pokój", false);

    /**Grupa JLabel udostepniona w metodzie display obiektowi kontrolera */
    JLabel textSzklenie = new JLabel();
    JLabel textProcentSzklenia = new JLabel();
    JLabel textOdpAkustyczna = new JLabel();
    JLabel[] listJTextField2 = {textSzklenie, textProcentSzklenia, textOdpAkustyczna};

    /**Grupa JLabel i JTextField uzyta w kontenerze pomocniczym do ustawiania parametrów stref*/
    JLabel labe0 = new JLabel("0-25%: ");
    JLabel labe25 = new JLabel("25-50%: ");
    JLabel labe50 = new JLabel("50-75%: ");
    JLabel labe75 = new JLabel("75-100%: ");
    JTextField text0 = new JTextField();
    JTextField text25 = new JTextField();
    JTextField text50 = new JTextField();
    JTextField text75 = new JTextField();

    /**Konstruktor GUI zapamietujący referencje do kontrolera */
    public GUI(Controller controller) {
        this.interfacecontroller = controller;

        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    createAndShowGUI();
                }
            });
        } catch (Exception e) {
            System.out.println("Exception e");
        }
    }

    /**Metoda budująca interfejs graficzny */
    private void createAndShowGUI() {
        ustawParametryStrefy();
        jpanel1.setLayout(new GridLayout(6, 1, 5, 5));
        jpanel2.setLayout(new GridLayout(6, 1, 5, 5));
        jpanel3.setLayout(new GridLayout(6, 1, 5, 5));
        bg1.add(j1);
        bg1.add(j2);
        bg2.add(r1);
        bg2.add(r2);
        for (int i = 0; i < listJlabelPanel1.length; i++) {
            JLabel etykieta = new JLabel(listJlabelPanel1[i]);
            jpanel1.add(etykieta);
            jpanel1.add(listJTextField1[i]);
        }
        JLabel strefa1 = new JLabel("Strefa Hałasu: ");
        jpanel2.add(strefa1);
        jpanel2.add(j1);
        j1.addItemListener(this);
        jpanel2.add(j2);
        j2.addItemListener((ItemListener) this);
        for (int i = 0; i < listJlabelPanel1.length; i++) {
            JLabel etykieta = new JLabel(listJlabelPanel3[i]);
            jpanel3.add(etykieta);
            jpanel3.add(listJTextField2[i]);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        przelicz.addActionListener(buttonlistener);
        odejmijStrefe.addActionListener(buttonlistener);
        dodajStrefe.addActionListener(buttonlistener);
        edytujStrefe.addActionListener(buttonlistener);
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(1, 3, 5, 5));
        middle.add(jpanel2);
        middle.add(jpanel1);
        middle.add(jpanel3);
        frame.getContentPane().add(middle, "Center");
        JPanel south = new JPanel();
        south.add(dodajStrefe);
        south.add(odejmijStrefe);
        south.add(edytujStrefe);
        south.add(przelicz);
        frame.getContentPane().add(south, "South");
        JPanel north = new JPanel();
        JLabel Rodzaj = new JLabel("Rodzaj Pomieszczenia: ");
        north.add(Rodzaj);
        north.add(r1);
        r1.addItemListener((ItemListener) this);
        north.add(r2);
        r2.addItemListener((ItemListener) this);
        frame.getContentPane().add(north, "North");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    /**metoda udostępniana przez Interfejs GUI w celu umieszczania na wyświetlaczu ekranu wyników */
    public void setDisplay(String number1, String number2, String number3) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI.this.textSzklenie.setText(number1);
                GUI.this.textProcentSzklenia.setText(number2);
                GUI.this.textOdpAkustyczna.setText(number3);
            }
        });
    }

    /**Metoda udostepniana przez interfejs GUI w celu umozliwienia zmian w wygladzie GUI na skutek wprowadzanych operacji odjecia strefy */
    public void odejmijStrefe(int nrStrefy) {
        if (nrStrefy > 0) {
            bg1.remove(listaStref.get(listaStref.size() - 1));
            jpanel2.remove(listaStref.get(listaStref.size() - 1));
            listaStref.get(listaStref.size() - 1).removeItemListener((ItemListener) this);
            listaStref.remove(listaStref.size() - 1);
            frame.pack();
            frame.setResizable(true);
        } else {
            JOptionPane.showMessageDialog(null, "Trzeba pozostawic minimum 2 strefy !!");
        }

    }

    /**Metoda udostepniana przez interfejs GUI w celu umozliwienia zmian w wygladzie GUI na skutek wprowadzanych operacji dodania strefy */
    public void dodajStrefe(int nrStrefy) {
        if (nrStrefy < 3) {
            listaStref.add(new JRadioButton("Strefa " + (nrStrefy + 2), false));
            bg1.add(listaStref.get(listaStref.size() - 1));
            listaStref.get(listaStref.size() - 1).addItemListener((ItemListener) this);
            jpanel2.add(listaStref.get(listaStref.size() - 1));
            frame.pack();
        } else {
            JOptionPane.showMessageDialog(null, "Można dodać maksymalnie 3 strefy !!");
        }
    }

    /**Metoda budujaca interfejs pomocniczy do edycji danych stref */
    public void ustawParametryStrefy() {
        dodaj.addActionListener(buttonlistener);
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(4, 2, 5, 5));
        parametryStrefy.setLocation(100, 100);
        parametryStrefy.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        middle.add(labe0);
        middle.add(text0);
        middle.add(labe25);
        middle.add(text25);
        middle.add(labe50);
        middle.add(text50);
        middle.add(labe75);
        middle.add(text75);
        parametryStrefy.getContentPane().add(middle, "Center");
        parametryStrefy.getContentPane().add(dodaj, "South");
        parametryStrefy.pack();
        parametryStrefy.setSize(300, 200);
        parametryStrefy.setLocationRelativeTo(null);
        parametryStrefy.setResizable(true);
        parametryStrefy.setVisible(false);
    }

    /**Metoda udostepniana przez interfejs GUI w celu umozliwienia zmian w wygladzie GUI na skutek wprowadzanych operacji edycji strefy */
    public void edytujStrefe(int nrStrefy) {
        parametryStrefy.setTitle("Ustaw strefe nr: " + nrStrefy);
        parametryStrefy.setVisible(true);
        text0.setText(Integer.toString(interfacecontroller.zwrocTabliceStref()[nrStrefy][0]));
        text25.setText(Integer.toString(interfacecontroller.zwrocTabliceStref()[nrStrefy][1]));
        text50.setText(Integer.toString(interfacecontroller.zwrocTabliceStref()[nrStrefy][2]));
        text75.setText(Integer.toString(interfacecontroller.zwrocTabliceStref()[nrStrefy][3]));
        wcisnietoPotwierdzenieParametrowStrefy.zmienStrefe(nrStrefy);
    }

    /**
     * Metoda oblugujaca zmiany stanow JRadioButtonow
     * Metoda moze byc zoptymalizowana poprzez uzycie ARRAYList zamiast tablic w miejscach gdzie tablice wystepuja
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == j1) {
            wcisnietoPrzelicz.zmienStrefe(0);
            wcisnietoEdytujStrefe.zmienStrefe(0);
            return;
        }
        if (e.getSource() == j2) {
            wcisnietoPrzelicz.zmienStrefe(1);
            wcisnietoEdytujStrefe.zmienStrefe(1);
            return;
        }
        if (e.getSource() == r1) {
            wcisnietoPrzelicz.zmienRodzajPomieszczenia(1);
        }
        if (e.getSource() == r2) {
            wcisnietoPrzelicz.zmienRodzajPomieszczenia(2);
        }
        try {
            if (e.getSource() == listaStref.get(0)) {
                wcisnietoPrzelicz.zmienStrefe(3);
                wcisnietoEdytujStrefe.zmienStrefe(2);
                return;
            }
        } catch (Exception e2) {
        }
        try {
            if (e.getSource() == listaStref.get(1)) {
                wcisnietoPrzelicz.zmienStrefe(3);
                wcisnietoEdytujStrefe.zmienStrefe(3);
                return;
            }
        } catch (Exception e2) {
        }
        try {
            if (e.getSource() == listaStref.get(2)) {
                wcisnietoPrzelicz.zmienStrefe(4);
                wcisnietoEdytujStrefe.zmienStrefe(4);
                return;
            }
        } catch (Exception e2) {
        }
    }

    /**Klasa wewnetrzna slużąca obsłudze wciskanych przycisków*/
    public class ButoonListenerImplementation implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == odejmijStrefe) {
                interfacecontroller.sendInfo(wcisnietoOdejmijStrefe);
            }
            if (e.getSource() == dodajStrefe) {
                interfacecontroller.sendInfo(wcisnietoDodajStrefe);
            }
            if (e.getSource() == edytujStrefe) {
                interfacecontroller.sendInfo(wcisnietoEdytujStrefe);
            }
            if (e.getSource() == dodaj) {
                try {
                    wcisnietoPotwierdzenieParametrowStrefy.pobierzparametrystref(Integer.valueOf(text0.getText()), Integer.valueOf(text25.getText()), Integer.valueOf(text50.getText()), Integer.valueOf(text75.getText()));
                } catch (Exception e2) {
                }
                interfacecontroller.sendInfo(wcisnietoPotwierdzenieParametrowStrefy);
                parametryStrefy.setVisible(false);
                return;
            }
            if (e.getSource() == przelicz) {
                try {
                    wcisnietoPrzelicz.zmienWysokoscOkna(Double.parseDouble(textHO.getText()));
                } catch (Exception ie) {
                    textHO.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Podaj wysokosc okna w cm !", "Blad danych", 2);
                    textHO.setBackground(Color.white);
                }
                try {
                    wcisnietoPrzelicz.zmienSzerokoscOkna(Double.parseDouble(textSO.getText()));
                } catch (Exception ie) {
                    textSO.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Podaj szerokosc okna w cm !", "Blad danych", 2);
                    textSO.setBackground(Color.white);
                }
                try {
                    wcisnietoPrzelicz.zmienSzerokoscSciany(Double.parseDouble(textSciany.getText()));
                } catch (Exception ie) {
                    textSciany.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Podaj szerokosc sciany w cm !", "Blad danych", 2);
                    textSciany.setBackground(Color.white);
                }
                interfacecontroller.sendInfo(wcisnietoPrzelicz);
            }
        }
    }
}