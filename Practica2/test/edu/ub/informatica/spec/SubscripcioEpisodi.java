package edu.ub.informatica.spec;

import controller.Controlador;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(ConcordionRunner.class)
public class SubscripcioEpisodi {
    private Controlador c;

    @BeforeExample
    public void init(){
        c = new Controlador();
    }

    @Test
    public void subscripcioEpisodi(String title, String duration, String idioma, String description, String data, String idSerie, String numTemporada){
        c.subscripcioEpisodi(title, duration, idioma, description, data, idSerie, numTemporada);
    }
}
