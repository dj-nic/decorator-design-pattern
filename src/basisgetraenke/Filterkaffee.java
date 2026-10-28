package basisgetraenke;

import getraenke.Getraenk;
import java.math.BigDecimal;

public class Filterkaffee implements Getraenk {

    @Override
    public BigDecimal getPreis() {
        return new BigDecimal("1.50");
    }

    @Override
    public String getBeschreibung() {
        return "Filterkaffee";
    }
}
