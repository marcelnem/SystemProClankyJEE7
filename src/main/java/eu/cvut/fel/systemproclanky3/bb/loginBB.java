/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.bb;

import eu.cvut.fel.systemproclanky3.bo.Role;
import eu.cvut.fel.systemproclanky3.dto.UserDto;
import eu.cvut.fel.systemproclanky3.service.UserServiceImpl;
import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jirka
 */
@SessionScoped
@Named("loginBB")
public class loginBB implements Serializable{

    String username;
    String role;
    String lang;
    long id;
    @Inject
    protected UserServiceImpl userService;

    public String getUsername() {
//        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (user instanceof UserDetails) {
//            this.username = ((UserDetails) user).getUsername();
//            //fing user id by username
//        }
//        return username;
        return "admin";
    }

    public String getRole() {
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
        return "/";
        //return null;
    }
}
