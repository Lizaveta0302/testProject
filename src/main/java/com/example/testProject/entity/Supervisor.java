package com.example.testProject.entity;

import com.example.testProject.entity.util.MessageHelper;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supervisor_id;
    @NotBlank(message = "Please fill the name")
    @Length(max = 20, message = "Message too long (more than 20 symbols)")
    private String name;
    @NotBlank(message = "Please fill the last name")
    @Length(max = 20, message = "Message too long (more than 20 symbols)")
    private String last_name;
    @NotBlank(message = "Please fill the patronymic")
    @Length(max = 20, message = "Message too long (more than 20 symbols)")
    private String patronymic;
    @NotBlank(message = "Please fill the phone")
    @Length(max = 20, message = "Message too long (more than 20 symbols)")
    private String phone;
    @NotBlank(message = "Please fill the city")
    @Length(max = 20, message = "Message too long (more than 20 symbols)")
    private String city;

    public Supervisor() {
    }

    public Supervisor(String name, String last_name, String patronymic, String phone, String city) {
        this.name = name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.phone = phone;
        this.city = city;
    }

    public Long getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(Long supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
