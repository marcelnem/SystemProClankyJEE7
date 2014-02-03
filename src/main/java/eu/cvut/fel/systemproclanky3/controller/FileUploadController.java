package eu.cvut.fel.systemproclanky3.controller;
 
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
  
import org.primefaces.model.UploadedFile;  
  
/**
 *
 * @author Marcel
 */
public class FileUploadController {
    private UploadedFile file;  
  
    public UploadedFile getFile() {  
        return file;  
    }  
  
    public void setFile(UploadedFile file) {  
        this.file = file;  
    }  
  
    public void upload() {  
        if(file != null) {  
            FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }  
    }  
}
