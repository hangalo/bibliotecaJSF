/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.jsf.ejb;

import biblioteca.jsf.entities.Municipio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author praveen
 */
@Stateless
public class MunicipioFacade extends AbstractFacade<Municipio> {
    @PersistenceContext(unitName = "cpj_bibliotecaJSF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioFacade() {
        super(Municipio.class);
    }
    
}
