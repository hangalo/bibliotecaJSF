/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.jsf.ejb;

import biblioteca.jsf.entities.LivroCategoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author praveen
 */
@Stateless
public class LivroCategoriaFacade extends AbstractFacade<LivroCategoria> {
    @PersistenceContext(unitName = "cpj_bibliotecaJSF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivroCategoriaFacade() {
        super(LivroCategoria.class);
    }
    
}
