package com.contacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.contacts.dto.ContactRequestDTO;
import com.contacts.dto.ContactResponseDTO;
import com.contacts.service.ContactService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
    	this.contactService = contactService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ContactResponseDTO> createContact(@Valid @RequestBody ContactRequestDTO request) {

        ContactResponseDTO response = contactService.createContact(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> getAllContacts() {

        List<ContactResponseDTO> contacts = contactService.getAllContacts();

        return ResponseEntity.ok(contacts);
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> getContactById(@PathVariable Long id) {

        ContactResponseDTO response = contactService.getContactById(id);

        return ResponseEntity.ok(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> updateContact(@PathVariable Long id,@Valid @RequestBody ContactRequestDTO request) {

        ContactResponseDTO response = contactService.updateContact(id, request);

        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {

        contactService.deleteContact(id);

        return ResponseEntity.noContent().build();
    }
}