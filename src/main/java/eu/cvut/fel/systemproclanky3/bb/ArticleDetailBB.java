/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cvut.fel.systemproclanky3.bb;

import static eu.cvut.fel.systemproclanky3.bo.Role.ROLE_AUTHOR;
import static eu.cvut.fel.systemproclanky3.bo.Role.ROLE_BOARD_MEMBER;
import static eu.cvut.fel.systemproclanky3.bo.Role.ROLE_CORRECTOR;
import eu.cvut.fel.systemproclanky3.bo.Status;
import eu.cvut.fel.systemproclanky3.dto.AdvisoryBoardMemberDto;
import eu.cvut.fel.systemproclanky3.dto.AnnotationDto;
import eu.cvut.fel.systemproclanky3.dto.ArticleDto;
import eu.cvut.fel.systemproclanky3.dto.AuthorDto;
import eu.cvut.fel.systemproclanky3.dto.CorrectorDto;
import eu.cvut.fel.systemproclanky3.dto.UserDto;
import eu.cvut.fel.systemproclanky3.dto.VersionDto;
import eu.cvut.fel.systemproclanky3.service.ArticleServiceImpl;
import eu.cvut.fel.systemproclanky3.service.UserServiceImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jirka
 */
@RequestScoped @Named
public class ArticleDetailBB {

    @Inject
    protected ArticleServiceImpl articleService;
    @Inject
    protected UserServiceImpl userServiceImpl;
    protected String name;
    protected boolean priority;
    protected Status status;
    String authors;
    List<AnnotationDto> annotationDtos;
//    List<VersionDto> versionDtos;
    CorrectorDto corrector;
    String selectedCorrector;
    String pathOfFile;
//    @Value("#{view.getParameter('articleId')}")
    private String articleId;
    private boolean checked;

    public boolean isChecked() {
        return (getStatus() == Status.checked);
    }
    
    private Long articleIdLong;
    private String message;
    private DataModel<VersionDto> versionDtos;

    public DataModel<VersionDto> getVersionDtos() {
        return versionDtos;
    }

    public void setVersionDtos(DataModel<VersionDto> versionDtos) {
        this.versionDtos = versionDtos;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String deleteVersion() {
        VersionDto selectedVersion = versionDtos.getRowData();
        articleService.deleteArticleVersion(selectedVersion.getId());
        init();
        setMessage("***Article version removed***");
        return "/system/detailArticle";
        //FacesUtil.addMessage("User was sucessfully deleted");
    }

    @PostConstruct
    public void init() {
        String readArticleId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("articleId");

        if (readArticleId != null && !"".equals(readArticleId)) {
            articleId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("articleId");
        }

        if (articleId == null) {
            return;
        }
//        System.out.println(articleId);
        articleIdLong = Long.parseLong(articleId.trim());
        ArticleDto adto = articleService.getArticleById(articleIdLong);
        this.name = adto.getName();
        this.status = adto.getStatus();

        priority = adto.isPriority();

        authors = "";
        for (Long authorId : adto.getAuthorsIDs()) {
            AuthorDto authordto = userServiceImpl.getAuthorById(authorId);
            authors = authors + "; " + authordto.getFirstname() + " " + authordto.getLastname() + " (" + authordto.getUsername() + ")";
        }
        authors = authors.replaceFirst(";", "");
        annotationDtos = articleService.getAnnotationsForArticle(articleIdLong);
        versionDtos = new ListDataModel<VersionDto>(articleService.getAllVersionsOfArticle(articleIdLong));
        if (adto.getCorrectorID() != null) {
            corrector = userServiceImpl.getCorrectorById(adto.getCorrectorID());
        }
    }

    public String getAuthorNameById(Long userId) {
        UserDto udto = userServiceImpl.getUserById(userId);
        String name;
        switch (udto.getRole()) {

            case ROLE_AUTHOR:
                AuthorDto authorDto = userServiceImpl.getAuthorById(userId);
                name = authorDto.getFirstname() + " " + authorDto.getLastname();
                break;
            case ROLE_BOARD_MEMBER:
                AdvisoryBoardMemberDto advisoryBoardMemberDto = userServiceImpl.getAdvisoryBoardMemberById(userId);
                name = advisoryBoardMemberDto.getFirstname() + " " + advisoryBoardMemberDto.getLastname();
                break;
            case ROLE_CORRECTOR:
                CorrectorDto correctorDto = userServiceImpl.getCorrectorById(userId);
                name = correctorDto.getFirstname() + " " + correctorDto.getLastname();
                break;
            default:
                name = "?";
                break;
        }
        return name;
    }

    public String markAsCorrected() {
        articleService.markArticleAsCorrected(articleIdLong);
        init();
        return "/system/detailArticle";
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public ArticleServiceImpl getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleServiceImpl articles) {
        this.articleService = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPathOfFile() {
        return pathOfFile;
    }

    public void setPathOfFile(long id) {
        List<VersionDto> list = articleService.getAllVersionsOfArticle(id);
        VersionDto v = list.get(list.size() - 1);
        this.pathOfFile = v.getPathOfFile();
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getSelectedCorrector() {
        return selectedCorrector;
    }

    public void setSelectedCorrector(String selectedCorrector) {
        this.selectedCorrector = selectedCorrector;
    }

    public List<AnnotationDto> getAnnotationDtos() {
        return annotationDtos;
    }

    public void setAnnotationDtos(List<AnnotationDto> annotationDtos) {
        this.annotationDtos = annotationDtos;
    }
}
