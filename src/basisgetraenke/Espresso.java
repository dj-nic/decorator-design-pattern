package basisgetraenke;

import getraenke.Getraenk;
import java.math.BigDecimal;

public class Espresso implements Getraenk {

    @Override
    public BigDecimal getPreis() {
        return new BigDecimal("2.00");
    }

    @Override
    public String getBeschreibung() {
        return "Espresso";
    }
}
