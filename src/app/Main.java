package app;

import basisgetraenke.Espresso;
import basisgetraenke.Filterkaffee;
import beilagen.Milch;
import beilagen.Sahne;
import beilagen.Sirup;
import getraenke.Getraenk;

public class Main {

    @SuppressWarnings("java:S1172") // args gehört zum JVM-Einstiegspunkt, wird hier aber nicht benötigt.
    public static void main(String[] args) {
        Getraenk espresso = new Espresso();

        Getraenk espressoMitZusaetzen =
                new Sirup(new Milch(new Espresso()));

        Getraenk filterkaffeeMitSahne =
                new Sahne(new Filterkaffee());

        ausgeben(espresso);
        ausgeben(espressoMitZusaetzen);
        ausgeben(filterkaffeeMitSahne);
    }

    private static void ausgeben(Getraenk getraenk) {
        System.out.println(getraenk.getBeschreibung() + ": " + getraenk.getPreis() + " Euro");
    }
}
