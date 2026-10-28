package beilagen;

import getraenke.Getraenk;
import java.math.BigDecimal;

public abstract class GetraenkDekorierer implements Getraenk {

    private final Getraenk getraenk;
    private final String name;
    private final BigDecimal aufpreis;

    public GetraenkDekorierer(Getraenk getraenk, String name, String aufpreis) {
        this.getraenk = getraenk;
        this.name = name;
        this.aufpreis = new BigDecimal(aufpreis);
    }

    @Override
    public BigDecimal getPreis() {
        // Preis des eingepackten Getränks plus Preis dieses Zusatzes.
        return getraenk.getPreis().add(aufpreis);
    }

    @Override
    public String getBeschreibung() {
        return getraenk.getBeschreibung() + ", " + name;
    }
}
