/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.bb;

import eu.cvut.fel.systemproclanky3.bo.Role;
import eu.cvut.fel.systemproclanky3.dto.UserDto;
import eu.cvut.fel.systemproclanky3.service.UserServiceImpl;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Locale;

/**
 * @author Marcel
 */
@SessionScoped
@Named("loginBB")
public class loginBB implements Serializable {

    @SessionScoped
    String username;
    @SessionScoped
    String role;
    @SessionScoped
    String lang;
    long id;
    private String logOut;
    @Inject
    UserServiceImpl userService;


    public String getUsername() {
        this.username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return this.username;
    }

    public String getRole() {
        if (this.getUsername() == null) {
            return null;
        }
        if (role == null) {

            UserDto user = userService.getUserByUsername(this.getUsername());
            Role roletemp = user.getRole();
            this.role = roletemp.name();
        }
        return role;
    }

    public void setRole(String role) {

        UserDto user = userService.getUserByUsername(this.getUsername());
        Role roletemp = user.getRole();
        String strRole = roletemp.name();
        this.role = strRole;
    }

    public long getId() {

        userService = new UserServiceImpl();
        UserDto user = userService.getUserByUsername(this.getUsername());
        this.id = user.getId();
        return this.id;
    }

    public void setId(long id) {

        UserDto user = userService.getUserByUsername(this.getUsername());
        long idtemp = user.getId();
        this.id = idtemp;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    //change of language
    public String changeLang(String langCode) {
        //FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(langCode));
        this.lang = langCode;
        if (langCode.equals("en")) {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("en"));
        } else {
            FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("cs"));
        }
        return "/system/";
        //return null;
    }

}
