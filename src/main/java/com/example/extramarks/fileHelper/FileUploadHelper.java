package com.example.extramarks.fileHelper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
      //Static Path
//	public final String UPLOAD_DIR="/home/extramarks/Documents/workspace-spring-tool-suite-4-4.11.0.RELEASE/Boot_V3/src/main/resources/static/image";

	public final String UPLOAD_DIR="/home/extramarks/Documents/workspace-spring-tool-suite-4-4.11.0.RELEASE/Boot_V3/src/main/resources/static/image";
	
    //Dynamic Path / Relative Path
//	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {
        //For using dynamic path
    }

    public boolean fileUploaded(MultipartFile file){
        boolean flag=false;

        try {
            //1. Using Stream API-> 'io' Package
//            //Reading image
//            InputStream inputStream=file.getInputStream();
//            byte data[]=new byte[inputStream.available()];
//            inputStream.read(data);
//
//            //Writing image
//            //FileOutputStream fileOutputStream=new FileOutputStream(UPLOAD_DIR+"/"+file.getOriginalFilename());   Can be used interchangeably
//            FileOutputStream fileOutputStream=new FileOutputStream(UPLOAD_DIR+ File.separator+file.getOriginalFilename());
//            fileOutputStream.write(data);
//            fileOutputStream.flush();
//            fileOutputStream.close();

            //2. Alternative Approach-> 'nio' Package
            //<Input Stream,Folder Path,Write Option>
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
