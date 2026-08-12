package com.contacts.service;

import java.util.List;

import com.contacts.dto.ContactPatchDTO;
import com.contacts.dto.ContactRequestDTO;
import com.contacts.dto.ContactResponseDTO;

public interface ContactService {

    ContactResponseDTO createContact(ContactRequestDTO request);

    List<ContactResponseDTO> getAllContacts();

    ContactResponseDTO getContactById(Long id);

    ContactResponseDTO updateContact(Long id, ContactRequestDTO request);
    
    ContactResponseDTO partialUpdateContact(Long id, ContactPatchDTO request);
    
    List<ContactResponseDTO> searchContacts(String keyword);

    void deleteContact(Long id);
}