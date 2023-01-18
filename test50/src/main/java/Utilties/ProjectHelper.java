package Utilties;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public  class ProjectHelper {
	
	public static String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length() - 1);
	            }
	        }
	        return "";
	    }
	
	
	
	
	
	
	
	public static String SingleImageUploader(HttpServletRequest request) throws IOException, ServletException {
		
		
		String UPLOAD_DIR = "images"+ File.separator+"product-images";
        String applicationPath = request.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + UPLOAD_DIR;
        String photo_pathString = null;
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");  
        String formattedDate = myDateObj.format(myFormatObj);  

       // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        // get the image part from the form
        Part filePart = request.getPart("image");
       
        String fileName =  extractFileName(filePart);
        if (!fileName.isEmpty()) {
            fileName = new File(fileName).getName();
            String filePath = uploadFilePath + File.separator + formattedDate+fileName;
            System.out.println("Write file: " + filePath);
            filePart.write(filePath);
            photo_pathString= UPLOAD_DIR + File.separator +formattedDate+fileName;
        }
        
		
		
		
		
		
		
		
		
		return photo_pathString;
		
		
		
	}

}
