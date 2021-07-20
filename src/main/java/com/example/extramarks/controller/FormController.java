package com.example.extramarks.controller;

import com.example.extramarks.entity.Form;
import com.example.extramarks.fileHelper.FileUploadHelper;
import com.example.extramarks.repository.FormRepository;
import com.example.extramarks.service.FormService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

@Controller
//@RestController
public class FormController {

    @Autowired
    private FormService formService;
    
    @Autowired
    private FileUploadHelper fileUploadHelper;
    
    @Autowired
    private FileUploadController fileUploadController; 
    
    @RequestMapping("home")
//    @GetMapping("/home")
    public String home() {
    	System.out.println("Project launched successfully.");
    	return "home";
    }
    
//    @PostMapping("/success")
//    public String addForm(Form form) {    	
////    	Form formDto = new ObjectMapper().readValue(jsonString,Form.class);	
//    	formService.saveForm(form);
//    	ModelAndView mv=new ModelAndView();
//    	mv.addObject("form",form);
//    	mv.setViewName("success");
//    	return "success";
//    }
    
    @PostMapping("/success")
    public ModelAndView addForm(@RequestParam("image") MultipartFile file, @RequestParam("name") String name,
    		@RequestParam("email") String email,@RequestParam("mobile") String mobile,
    		@RequestParam("gender") String gender,@RequestParam("skills") String skills,
    		@RequestParam("state") String state) {    		
    	Form form=new Form(name,email,mobile,gender,state,skills,ServletUriComponentsBuilder 
                .fromCurrentContextPath().path("/image/")
                .path(file.getOriginalFilename())
                .toUriString());
    	
    	formService.saveForm(form);
    	
    	ModelAndView mv=new ModelAndView();
    	mv.addObject("form",form);
    	mv.setViewName("success");
    	return mv;
    }
    
    @GetMapping("/get")
    @ResponseBody
    public List<Form> findAllForms(){
        return formService.getForms();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Form findFormById(@PathVariable int id) {
        return formService.getFormById(id);
    }

    @PutMapping(path="/home",consumes={"application/json"})
    public Form updateForm(@RequestBody Form form){
        return formService.saveForm(form);
    }
    
    
    
//    @RequestMapping(value="/image", method = RequestMethod.POST) 
//	 public	String addEmployee(Form form,@RequestParam("image") MultipartFile file, ModelMap model) throws IOException {
//		 
//		 String fileName = form.getName()+file.getOriginalFilename();
//		 
//		 String fileExtension = fileName.substring(fileName.length()- 4);
//		 if(!(fileExtension.equals("jpeg") || fileExtension.equals(".jpg") || fileExtension.equals(".png"))) {
//			 model.addAttribute("message", "File format not supported for 'Profile Picture', please upload jpeg, jpg or png only");
//			 return "success";
//		 }
//		 		 
//		 Path fileNameAndPath = Paths.get(fileUploadHelper.UPLOAD_DIR, fileName);	     
//		 Files.write(fileNameAndPath, file.getBytes());		 
//		 form.setImage(fileName);
//		 return "success";	 
//	 }
    
//    @PostMapping("/success")
//    public ModelAndView addFormAndImage(@ModelAttribute("form") @Valid Form form
//            , @RequestParam("image") MultipartFile multipartFile, ModelAndView modelAndView)
//            throws IOException {
//        String fileName = org.springframework.util.StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        //File Handling
//        Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR + fileName), StandardCopyOption.REPLACE_EXISTING);
//        Form formAndFile= formService.saveFormFile(form,fileName);
//
//        //Adding photo url to userDetailsAndSkill
//        form.setImage("http://localhost:5757/get/" + String.valueOf(formAndFile));
//
//        //Sending Object from controller to view
//        modelAndView.addObject("form", form);
//        modelAndView.setViewName("success");
//        return modelAndView;
//    }
    
//	@RequestMapping(value="/success" , method=RequestMethod.POST)
//	public String userInfo(Form form, @RequestParam("image") MultipartFile file, Model model) throws IOException {    
//		//processing and uploading files
//		Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+"/"+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
//		form.setImage(ServletUriComponentsBuilder.fromCurrentContextPath().path("img/"+file.getOriginalFilename()).toUriString());
//		//saving the data in database
//		 formService.saveForm(form);
//		 //adding the object to model for displaying and providing editing functionality
//		 model.addAttribute("form", form);
//		 return "success";
//	}
    
//    @RequestMapping("/success")
//    public String handleForm(@RequestParam("name") String userName, @RequestParam("email") String userMail,
//                             @RequestParam("mobile") String userMobile, @RequestParam("state") String userState,
//                             @RequestParam("gender") String userGender,@RequestParam("skills") String userSkills,
//                             @RequestParam("image") String userImage,Model model, @RequestParam("image") MultipartFile file){
////
////        model.addAttribute("name",userName);
////        model.addAttribute("email",userMail);
////        model.addAttribute("mobile",userMobile);
////        model.addAttribute("state",userState);
////        model.addAttribute("gender",userGender);
////        model.addAttribute("skills",userSkills);
////        model.addAttribute("image",userImage);
////        return "success";
//
//          try{
//              Path fileNameAndPath=Paths.get(UPLOAD_DIR,file.getOriginalFilename());
//              String fileName=file.getOriginalFilename();
//              Files.write(fileNameAndPath,file.getBytes());
//          }
//          catch(IOException e){
//              e.printStackTrace();
//          }
//          model.addAttribute("msg","Successfully added image");
//          return "success";
//    }
    
    /*
    public String getUrl(@RequestParam("image") MultipartFile file) throws IOException{
       File saveFile=new ClassPathResource("static/image/").getFile();
       Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());

       Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);

        return path.toString();
    }
    */

//    -> ORIGINAL Git Version
//    @CrossOrigin(origins = "http://localhost:63342")
//    @PostMapping("/add")
//    public Form addForm(@RequestBody Form form){
//        return formService.saveForm(form);
//    }

    /*
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/add")
    public Form addForm(@RequestParam Form form, @RequestParam("profileImage") MultipartFile file) throws IOException {
        String receivedUrl=getUrl(file);
        form.setImage(receivedUrl);
        return formService.saveForm(form);
    }
    */

    /*
    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new SpringBootV2Application());
        return "signup form";
    }
    */

    /*
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/add")
    public Form addForm(@RequestBody Form form, @RequestParam("profileImage") MultipartFile file){
            try {
                System.out.println("Add form: "+ form.toString());
                if(file.isEmpty()) System.out.println("Cannot upload empty image.");
                else{
                    form.setImage(file.getOriginalFilename());

                    File saveFile=new ClassPathResource("static/image/").getFile();

                    Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
                    Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("Image successfully uploaded.");
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return formService.saveForm(form);
    }
    */

//    public static String uploadDirectory=System.getProperty("user.dir")+"/uploads";
//    @RequestMapping("/add")
//    public String uploadPage(Model model){
//        return "index";
//    }

    /*
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("form") Form form, @RequestParam (value="name",defaultValue = "false") boolean name,Model model){
        System.out.println(("Name: "+ name));
        System.out.println(("Form: ")+ form);
        return "index";
    }
    */

    /*
    public static String UPLOAD_DIR=System.getProperty("user.dir")+"/home/extramarks/IdeaProjects/SpringBoot_v2/src/main/resources/static/image";

    @CrossOrigin("localhost:63342")
    @RequestMapping("/add")
    @ResponseBody
    public String addForm(Form form, @RequestParam("image") MultipartFile file){
        StringBuilder fileNames=new StringBuilder();
        String fileName=form.getId()+file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
        Path fileNameAndPath=Paths.get(UPLOAD_DIR,fileName);

        try {
            Files.write(fileNameAndPath,file.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        form.setImage(fileName);
        formService.saveForm(form);
        return "Image upload successful.";
    }
      */

    /*
    //ABV
    @PostMapping("/add")
    public String userInfo(Form form, @RequestParam("image") MultipartFile file, Model model) throws IOException {
        Files.copy(file.getInputStream(), Paths.get(fileUploadHelper.UPLOAD_DIR+"/"+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
        form.setImage(ServletUriComponentsBuilder.fromCurrentContextPath().path("img/"+file.getOriginalFilename()).toUriString());
        formService.saveForm(form);
        model.addAttribute("obj", form);
        return "file2";
    }
    */

    /*
    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/add")
    public String addForm(Model model, @RequestParam("image") MultipartFile file){
        Path fileNameAndPath=Paths.get(FileUploadHelper.UPLOAD_DIR, file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath,file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("msg","Successfully attached image.");
        return "index";
    }
    */

    /* Latest
    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public Form addForm(@RequestPart("form") String form,@RequestPart("image")MultipartFile file){
        Form formJson=formService.getJson(form,file);

        return formJson;
    }
    */

    /*
    @PostMapping("/file2")
    public String handleForm(@RequestParam("name") String userName, @RequestParam("email") String userMail,
                             @RequestParam("mobile") String userMobile, @RequestParam("state") String userState,
                             @RequestParam("gender") String userGender,@RequestParam("skills") String userSkills,
                             @RequestParam("image") String userImage,Model model){

        model.addAttribute("name",userName);
        model.addAttribute("email",userMail);
        model.addAttribute("mobile",userMobile);
        model.addAttribute("state",userState);
        model.addAttribute("gender",userGender);
        model.addAttribute("skills",userSkills);
        model.addAttribute("image",userImage);
        return "success";
    }
    */
}
