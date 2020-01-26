package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

// Konstruktorien testit

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaTyhjllaVarastollaOikeaTilavuus() {
        Varasto varasto2 = new Varasto(0);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void uudellaNegVarastollaOikeaTilavuus() {
        Varasto varasto2 = new Varasto(-10);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }



// Omat lisäykset
    @Test
    public void uudellaVarastollaEiTyhjallaTilavuus() {
        Varasto varasto2 = new Varasto(10, 5);
        assertEquals(10, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaEiTyhjallaSaldo() {
        Varasto varasto2 = new Varasto(10, 5);
        assertEquals(5, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaNegTilavuus() {
        Varasto varasto2 = new Varasto(-5, 5);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaNegSaldo() {
        Varasto varasto2 = new Varasto(5, -5);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }


// Metodien testit



    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }


// Omat metodien testit
    @Test
    public void lisaysLisaaNegSaldoa() {
        varasto.lisaaVarastoon(-5);

        // saldon pitäisi olla edelleen 0
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaLiianPaljonSaldoa() {
        varasto.lisaaVarastoon(100);

        // saldon pitäisi olla edelleen max määrä eli 10
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenNegat() {
        varasto.otaVarastosta(-5);

        // varastossa pitäisi olla tilaa edelleen 10
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenLiikaa() {
        varasto.otaVarastosta(100);

        // varastossa pitäisi olla tilaa 10 eli kokonaan
        assertEquals(20, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void stringgaus() {
        varasto.lisaaVarastoon(8);

        // varastossa pitäisi olla tilaa 10 eli kokonaan
        assertEquals("saldo = 8.0, vielä tilaa 2.0", varasto.toString());
    }


/*
    @Test
    public void oikeaSaldo() {
        varasto.lisaaVarastoon(8);

        // Saldon pitäisi olla tyhjään varastoon lisätty saldo eli 8
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void oikeaJaljellaJaava() {
        varasto.lisaaVarastoon(8);

        // Saldon pitäisi olla 10 - 8 = 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
*/








}
