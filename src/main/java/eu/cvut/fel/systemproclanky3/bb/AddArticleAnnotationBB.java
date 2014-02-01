/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.bb;

import eu.cvut.fel.systemproclanky3.dto.ArticleDto;
import eu.cvut.fel.systemproclanky3.service.ArticleServiceImpl;
import eu.cvut.fel.systemproclanky3.service.UserServiceImpl;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author marcel
 */
@RequestScoped @Named
public class AddArticleAnnotationBB {

//@ManagedProperty(name="articleService", value="#{articleService}" )
    @Inject
    protected ArticleServiceImpl articleService;
    @Inject
    protected UserServiceImpl userServiceImpl;
    private String articleId;
    protected String name;
    protected Long articleIdLong;
    protected UploadedFile file;
    protected String annotationText;
    @Inject
    ArticleDetailBB articleDetailBB;

    public String getAnnotationText() {
        return annotationText;
    }

    public void setAnnotationText(String annotationText) {
        this.annotationText = annotationText;
    }

    @PostConstruct
    public void init() {
        articleId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("articleId");

        if (articleId == null) {
            return;
        }

        articleIdLong = Long.parseLong(articleId.trim());
        ArticleDto adto = articleService.getArticleById(articleIdLong);
        this.name = adto.getName();

    }

    public String addAnnotation(String articleId) throws Exception {
//        this.articleId = articleId;
//        init();
//        if (articleIdLong == null) {
//            throw new Exception("missing article id");
//        }
//        Long userId = null;
//        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (user instanceof UserDetails) {
//            String username = ((UserDetails) user).getUsername();
//            UserDto udto = userServiceImpl.getUserByUsername(username);
//            userId = udto.getId();
//        }
//        articleService.addAnnotationToArticle(articleIdLong, userId, annotationText, null);

        articleDetailBB.setMessage("***Article annotation adding not supported now***");
        articleDetailBB.setArticleId(articleId);
        articleDetailBB.init();
        return "/detailArticle";
    }

    public ArticleServiceImpl getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArticleIdLong() {
        return articleIdLong;
    }

    public void setArticleIdLong(Long articleIdLong) {
        this.articleIdLong = articleIdLong;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
