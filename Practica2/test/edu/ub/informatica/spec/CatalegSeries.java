package edu.ub.informatica.spec;
import controller.*;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;



import java.util.ArrayList;

@RunWith(ConcordionRunner.class)

public class CatalegSeries{
    private Controlador c;

    @BeforeExample
    public void init(){
        c = new Controlador();
    }

    @Test
    public ArrayList<String> getCatalegSerie(){
        return c.getCatalegSeries();
    }

}
