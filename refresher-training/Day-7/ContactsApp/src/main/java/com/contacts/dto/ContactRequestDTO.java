package com.contacts.dto;

public class ContactRequestDTO {

    private String name;
    private String phone;
    private String alternatePhone;
    private String email;

    public ContactRequestDTO() {
    }

    public ContactRequestDTO(String name, String phone,
                             String alternatePhone, String email) {
        this.name = name;
        this.phone = phone;
        this.alternatePhone = alternatePhone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}