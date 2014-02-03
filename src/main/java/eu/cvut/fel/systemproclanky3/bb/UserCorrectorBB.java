/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.bb;

import eu.cvut.fel.systemproclanky3.service.UserServiceImpl;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Marcel
 */

@javax.enterprise.context.RequestScoped
@Named
public class UserCorrectorBB {

//    @ManagedProperty(name = "userService", value = "#{userService}")
    @Inject
    protected UserServiceImpl userService;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String email;
    //ROLE string

    public String saveUser() {
        getUserService().addCorrector(firstName, lastName, username, password, email);
        return "success";
    }

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * getters and setters *
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}