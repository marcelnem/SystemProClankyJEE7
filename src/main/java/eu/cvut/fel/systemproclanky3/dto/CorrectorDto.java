/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.dto;

import java.util.List;

/**
 *
 * @author Marcel
 */
public class CorrectorDto extends PersonAbstractDto {

    List<Long> articleIds;
    String email;

    public CorrectorDto() {
        super();
    }

    public List<Long> getArticleIds() {
        return articleIds;
    }

    public void setArticleIds(List<Long> articleIds) {
        this.articleIds = articleIds;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
