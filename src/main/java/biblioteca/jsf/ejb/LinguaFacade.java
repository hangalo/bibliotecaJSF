/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.jsf.ejb;

import biblioteca.jsf.entities.Lingua;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author praveen
 */
@Stateless
public class LinguaFacade extends AbstractFacade<Lingua> {
    @PersistenceContext(unitName = "cpj_bibliotecaJSF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LinguaFacade() {
        super(Lingua.class);
    }
    
}
