package com.example.extramarks.service;

import com.example.extramarks.entity.Form;
import com.example.extramarks.repository.FormRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    public Form saveForm(Form form){
        return formRepository.save(form);
    }

    public List<Form> getForms(){
        return formRepository.findAll();
    }

    public Form getFormById(int id){
        return formRepository.findById(id).orElse(null);
    }

    public Form updateForm (Form form){
        Form existingForm=formRepository.findById(form.getId()).orElse(null);

        existingForm.setName(form.getName());
        existingForm.setEmail(form.getEmail());
        existingForm.setMobile(form.getMobile());
        existingForm.setGender(form.getGender());
        existingForm.setSkills(form.getSkills());
        existingForm.setState(form.getState());
        existingForm.setImage(form.getImage());

        return formRepository.save(existingForm);
    }

    public Form saveFormFile(Form form, String url){
        form.setImage(url);
        return form;
    }

    public Form getJson(String form, MultipartFile file){
        Form formJson=new Form();
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            formJson=objectMapper.readValue(form,Form.class);
        }
        catch (IOException e){
            System.out.printf("Error", e.toString());
        }
        return formJson;
    }
}

