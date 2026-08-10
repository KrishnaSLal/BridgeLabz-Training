package com.contacts.service;

import com.contacts.dto.ContactRequestDTO;
import com.contacts.dto.ContactResponseDTO;
import com.contacts.entity.Contact;
import com.contacts.repository.ContactRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactResponseDTO createContact(ContactRequestDTO request) {

        Contact contact = new Contact();

        contact.setName(request.getName());
        contact.setPhone(request.getPhone());
        contact.setAlternatePhone(request.getAlternatePhone());
        contact.setEmail(request.getEmail());

        Contact savedContact = contactRepository.save(contact);

        return convertToResponseDTO(savedContact);
    }

    @Override
    public List<ContactResponseDTO> getAllContacts() {

        return contactRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContactResponseDTO getContactById(Long id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Contact not found with id: " + id));

        return convertToResponseDTO(contact);
    }

    @Override
    public ContactResponseDTO updateContact(
            Long id,
            ContactRequestDTO request) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Contact not found with id: " + id));

        contact.setName(request.getName());
        contact.setPhone(request.getPhone());
        contact.setAlternatePhone(request.getAlternatePhone());
        contact.setEmail(request.getEmail());

        Contact updatedContact = contactRepository.save(contact);

        return convertToResponseDTO(updatedContact);
    }

    @Override
    public void deleteContact(Long id) {

        if (!contactRepository.existsById(id)) {
            throw new RuntimeException(
                    "Contact not found with id: " + id);
        }

        contactRepository.deleteById(id);
    }

    private ContactResponseDTO convertToResponseDTO(Contact contact) {

        return new ContactResponseDTO(
                contact.getId(),
                contact.getName(),
                contact.getPhone(),
                contact.getAlternatePhone(),
                contact.getEmail()
        );
    }
}