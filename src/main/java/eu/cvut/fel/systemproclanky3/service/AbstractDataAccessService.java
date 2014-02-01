/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.service;

import eu.cvut.fel.systemproclanky3.dao.GenericDao;
import javax.inject.Inject;

/**
 *
 * @author mickapa1
 */
public abstract class AbstractDataAccessService {
    @Inject
    protected GenericDao genericDao;
    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    public GenericDao getGenericDao() {
        return genericDao;
    }    
}
