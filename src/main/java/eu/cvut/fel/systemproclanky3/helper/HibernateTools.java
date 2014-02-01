/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.helper;

import eu.cvut.fel.systemproclanky3.bo.DomainEntity;
import org.hibernate.proxy.HibernateProxy;


/**
 * Hibernate support tools
 * @author Pavel Micka
 */
public class HibernateTools {
    /**
     * Get id from the proxy of the object without hitting the database
     * @return identifikator objektu
     */
    public static Long getIdentifier(DomainEntity o){
        if(o == null) return null;
        Long id = null;
        if(o instanceof HibernateProxy){
            id = (Long)((HibernateProxy) o).getHibernateLazyInitializer().getIdentifier();
        }else{
            id = o.getId();
        }
        return id;
    }
}