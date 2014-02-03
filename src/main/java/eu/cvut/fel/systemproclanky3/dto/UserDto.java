/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.dto;

import eu.cvut.fel.systemproclanky3.bo.Role;

/**
 *
 * @author Marcel
 */
public class UserDto extends AbstractDto {

    private String username;
    private Role role;

    public UserDto() {
    }

    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
}
