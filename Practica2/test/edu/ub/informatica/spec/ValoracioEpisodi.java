package edu.ub.informatica.spec;

import controller.Controlador;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class ValoracioEpisodi {
    private Controlador c;

    @BeforeExample
    public void init(){
        c = new Controlador();
    }

    @Test
    public void valoracioEpisodi(String id, String client, String idSerie, String numTemporada, String episodi, String puntuacio, String data){
        c.valoracio(id, client, idSerie, numTemporada, episodi, puntuacio, data);
    }
}
