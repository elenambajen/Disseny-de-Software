/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author anna
 */

package edu.ub.informatica.spec;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import edu.ub.informatica.disseny.stub.*; // system under design
import org.concordion.api.BeforeExample;
import org.junit.Test;


@RunWith(ConcordionRunner.class)

public class STUBDataManager {

    private DAO_XML dataManager;

    @BeforeExample
    public void init(){
        dataManager = new DAO_XML("data/STUB.xml");
    }


    @Test
    public String getArtista() {

        return dataManager.getArtista();

    }

    @Test
    public String getSerie() {

        return dataManager.getSerie();

    }
    @Test
    public String getTemporada() {

        return dataManager.getTemporada();

    }
    @Test
    public String getEpisodi() {

        return dataManager.getEpisodi();

    }
    @Test
    public String getProductora() {
        return dataManager.getProductora();

    }
    @Test
    public String getAdmin() {
        return dataManager.getAdmin();

    }
    @Test
    public String getClient() {
        return dataManager.getClient();

    }

    @Test
    public String getValoracio() {
        return dataManager.getValoracio();

    }


}