package com.upload;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/tvUploadServlet1")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

public class tvUploadServlet1 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
     create images folder at, C:\Users\Dharmesh Mourya\Documents\NetBeansProjects\ImageProject\build\web\images
     */

    public static final String UPLOAD_DIR = "images";
    public String dbFileName = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        
        String name = request.getParameter("name");
       
        String language = request.getParameter("language");
        
        String adminun=request.getParameter("adminun");

        Part part = request.getPart("file");//
        String fileName = extractFileName(part);//file name

        /**
         * *** Get The Absolute Path Of The Web Application ****
         */
        String applicationPath = getServletContext().getRealPath("");
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
     //   System.out.println("applicationPath:" + applicationPath);
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        String savePath = uploadPath + File.separator + fileName;
      //  System.out.println("savePath: " + savePath);
        String sRootPath = new File(savePath).getAbsolutePath();
       // System.out.println("sRootPath: " + sRootPath);
        part.write(savePath + File.separator);
        File fileSaveDir1 = new File(savePath);
        /*if you may have more than one files with same name then you can calculate some random characters
         and append that characters in fileName so that it will  make your each image name identical.*/
        dbFileName = UPLOAD_DIR + File.separator + fileName;
        part.write(savePath + File.separator);
        //out.println(id+" "+firstName+" "+lastName+" "+fileName+" "+savePath);
        /*
         You need this loop if you submitted more than one file
         for (Part part : request.getParts()) {
         String fileName = extractFileName(part);
         part.write(savePath + File.separator + fileName);
         }*/
        
         boolean isAvailable = uploadDB.tvcheckavailability(name);
         
         if(isAvailable==true) {
        	 
        	out.println("<script type='text/javascript'>");
   			out.println("alert('Movie Already Available');");
   			out.println("location='tvupload.jsp'");
   			out.println("</script>");
        	 
        	 
         }else {
        	 
        	
        	 
        	 boolean isSuccess = uploadDB.uploadtvseries(name,language,dbFileName,savePath,adminun);
        	 if(isSuccess==true) {
        		 
        		out.println("<script type='text/javascript'>");
      			out.println("alert('Successfully Uploaded ');");
      			out.println("location='tvupload.jsp'");
      			out.println("</script>");
        		 
        	 }else {
        		 
        		 out.println("<script type='text/javascript'>");
     			out.println("alert('Upload Failed ');");
     			out.println("location='tvupload.jsp'");
     			out.println("</script>");
        		 
        	 }
        	 
         }
        
        

    }
    // file name of the upload file is included in content-disposition header like this:
    //form-data; name="dataFile"; filename="PHOTO.JPG"

    private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}