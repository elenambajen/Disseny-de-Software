package edu.ub.informatica.spec;

import controller.Controlador;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class VeureEpisodi {
    private Controlador c;

    @BeforeExample
    public void init(){
        c = new Controlador();
    }

    @Test
    public void visualitzacioEpisodi(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada){
        c.visualitzacioEpisodi(title, duration, idioma, description, data, idSerie, numTemporada);
    }
}
