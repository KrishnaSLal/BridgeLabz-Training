package com.contacts.controller;

import com.contacts.dto.ContactRequestDTO;
import com.contacts.dto.ContactResponseDTO;
import com.contacts.service.ContactService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactViewController {

    private final ContactService contactService;

    public ContactViewController(ContactService contactService) {
        this.contactService = contactService;
    }

    // ==============================
    // VIEW ALL CONTACTS
    // ==============================

    @GetMapping("/contacts")
    public String showContacts(Model model) {

        List<ContactResponseDTO> contacts =
                contactService.getAllContacts();

        model.addAttribute("contacts", contacts);

        return "contacts";
    }


    // ==============================
    // SHOW ADD CONTACT FORM
    // ==============================

    @GetMapping("/contacts/add")
    public String showAddContactForm(Model model) {

        model.addAttribute(
                "contact",
                new ContactRequestDTO()
        );

        return "add-contact";
    }


    // ==============================
    // CREATE CONTACT
    // ==============================

    @PostMapping("/contacts/save")
    public String saveContact(
            ContactRequestDTO contact) {

        contactService.createContact(contact);

        return "redirect:/contacts";
    }


    // ==============================
    // SHOW EDIT FORM
    // ==============================

    @GetMapping("/contacts/edit/{id}")
    public String showEditContactForm(
            @PathVariable Long id,
            Model model) {

        ContactResponseDTO contact =
                contactService.getContactById(id);

        ContactRequestDTO request =
                new ContactRequestDTO();

        request.setName(contact.getName());
        request.setPhone(contact.getPhone());
        request.setAlternatePhone(
                contact.getAlternatePhone()
        );
        request.setEmail(contact.getEmail());

        model.addAttribute("contact", request);
        model.addAttribute("contactId", id);

        return "edit-contact";
    }


    // ==============================
    // UPDATE CONTACT
    // ==============================

    @PostMapping("/contacts/update/{id}")
    public String updateContact(
            @PathVariable Long id,
            ContactRequestDTO contact) {

        contactService.updateContact(
                id,
                contact
        );

        return "redirect:/contacts";
    }


    // ==============================
    // DELETE CONTACT
    // ==============================

    @GetMapping("/contacts/delete/{id}")
    public String deleteContact(
            @PathVariable Long id) {

        contactService.deleteContact(id);

        return "redirect:/contacts";
    }
}