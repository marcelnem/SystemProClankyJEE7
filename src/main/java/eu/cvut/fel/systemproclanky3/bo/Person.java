/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.bo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author marcel
 */

@MappedSuperclass
public abstract class Person extends User {

    @Column(length = 100, nullable = false)
    @Size(max=100)
            @NotNull
    String firstname;
    @Column(length = 100, nullable = false)
    @Size(max=100)
    @NotNull
    String lastname;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
