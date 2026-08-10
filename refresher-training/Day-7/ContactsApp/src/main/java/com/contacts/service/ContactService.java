package com.contacts.service;

import com.contacts.dto.ContactRequestDTO;
import com.contacts.dto.ContactResponseDTO;

import java.util.List;

public interface ContactService {

    ContactResponseDTO createContact(ContactRequestDTO request);

    List<ContactResponseDTO> getAllContacts();

    ContactResponseDTO getContactById(Long id);

    ContactResponseDTO updateContact(
            Long id,
            ContactRequestDTO request);

    void deleteContact(Long id);
}