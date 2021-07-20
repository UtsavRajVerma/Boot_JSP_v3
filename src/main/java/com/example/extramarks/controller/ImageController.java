//package com.example.extramarks.controller;
//
//import java.io.IOException;
//
//import javax.annotation.Resource;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.extramarks.entity.Form;
//import com.example.extramarks.service.FormService;
//
//@Controller
//@RequestMapping("/image")
//public class ImageController {
//	
//}
//	@Resource(name="categoryService")
//	private Se categoryService;
//
//	@Resource(name="itemService")
//	private FormService formService;
//
//	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
//	  public void showImage(@RequestParam("id")Integer id, HttpServletResponse response,HttpServletRequest request) 
//	          throws ServletException, IOException{
//
//
//	    Form form = formService.getFormById(form.getId());        
//	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//	    response.getOutputStream().write(form.getImage());
//
//
//	    response.getOutputStream().close();
//
//}
