package com.example.extramarks.controller;

import com.example.extramarks.fileHelper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Component
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("image")MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize()+" Bytes");
        System.out.println(file.getContentType());
        System.out.println(file.getName());

        try {
            //Validation 1
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Picture not uploaded!");
            }

            //Validation 2
            if (!(file.getContentType().equals("image/jpg") || file.getContentType().equals("image/png") || file.getContentType().equals("image/jpeg"))) {
                return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("File type not supported!");
            }

            //File Upload
            boolean uploadStatus=fileUploadHelper.fileUploaded(file);
            if(uploadStatus){
//                return ResponseEntity.ok("File upload successful!");
                return ResponseEntity.ok(ServletUriComponentsBuilder     // -> Gives localhost or server path -> localhost:5747
                        .fromCurrentContextPath().path("/image/")        // -> localhost:5747/image/
                        .path(file.getOriginalFilename())               // -> localhost:5747/image/<File Name>
                        .toUriString());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. Try again!");
    }

}
