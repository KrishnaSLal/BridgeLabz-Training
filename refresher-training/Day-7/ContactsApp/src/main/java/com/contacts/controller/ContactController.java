package com.contacts.controller;

import com.contacts.dto.ContactRequestDTO;
import com.contacts.dto.ContactResponseDTO;
import com.contacts.service.ContactService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactResponseDTO> createContact(
            @RequestBody ContactRequestDTO request) {

        ContactResponseDTO response =
                contactService.createContact(request);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> getAllContacts() {

        List<ContactResponseDTO> contacts =
                contactService.getAllContacts();

        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> getContactById(
            @PathVariable Long id) {

        ContactResponseDTO contact =
                contactService.getContactById(id);

        return ResponseEntity.ok(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> updateContact(
            @PathVariable Long id,
            @RequestBody ContactRequestDTO request) {

        ContactResponseDTO updatedContact =
                contactService.updateContact(id, request);

        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(
            @PathVariable Long id) {

        contactService.deleteContact(id);

        return ResponseEntity.noContent().build();
    }
}