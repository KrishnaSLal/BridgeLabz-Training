package com.contacts.dto;

public class ContactResponseDTO {

    private Long id;
    private String name;
    private String phone;
    private String alternatePhone;
    private String email;

    public ContactResponseDTO() {
    }

    public ContactResponseDTO(Long id, String name, String phone,
                              String alternatePhone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.alternatePhone = alternatePhone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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