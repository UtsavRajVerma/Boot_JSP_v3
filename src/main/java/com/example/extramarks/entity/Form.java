package com.example.extramarks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name ="Form_Table")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Size(min=3,max=50)
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min=10,max=10,message="Phone No. must contain 10 digits")
    private String mobile;
    @NotBlank
    private String state;
    @NotBlank
    private String gender;
    @NotBlank
    private String skills;
    @NotBlank
    private String image;

//    public Form(String name, String email, String mobile, String state, String gender, String skills) {
//        this.name = name;
//        this.email = email;
//        this.mobile = mobile;
//        this.state = state;
//        this.gender = gender;
//        this.skills = skills;
//    }

    public Form(String name, String email, String mobile, String state, String gender, String skills, String image) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.state = state;
        this.gender = gender;
        this.skills = skills;
        this.image = image;
    }

    public Form() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

