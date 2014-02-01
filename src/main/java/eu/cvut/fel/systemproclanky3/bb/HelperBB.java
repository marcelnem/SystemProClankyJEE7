/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.bb;

import eu.cvut.fel.systemproclanky3.service.UserServiceImpl;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author marcel
 */
@javax.enterprise.context.RequestScoped
@Named
public class HelperBB {
    List<String> allCorrectors;

    @Inject
    protected UserServiceImpl userServiceImpl;
    
    
}
