package com.contacts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.contacts.dto.ContactPatchDTO;
import com.contacts.dto.ContactRequestDTO;
import com.contacts.dto.ContactResponseDTO;
import com.contacts.entity.Contact;
import com.contacts.exception.ContactNotFoundException;
import com.contacts.repository.ContactRepository;

@ExtendWith(MockitoExtension.class)
public class ContactServiceImplTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;


    // CREATE
    @Test
    void shouldCreateContact() {

        ContactRequestDTO request = new ContactRequestDTO(
                "Krishna",
                "S Lal",
                "krishna@gmail.com",
                "9874563210",
                "8569741230"
        );

        Contact contact = new Contact(
                1L,
                "Krishna",
                "S Lal",
                "krishna@gmail.com",
                "9874563210",
                "8569741230"
        );

        when(contactRepository.save(any(Contact.class)))
                .thenReturn(contact);

        ContactResponseDTO response = contactService.createContact(request);

        assertEquals(1L, response.getId());
        assertEquals("Krishna", response.getFirstName());
        assertEquals("S Lal", response.getLastName());
        assertEquals("krishna@gmail.com", response.getEmail());
        assertEquals("9874563210", response.getPhone());
        assertEquals("8569741230", response.getAlternatePhone());

        verify(contactRepository).save(any(Contact.class));
    }


    // READ ALL
    @Test
    void shouldGetAllContacts() {

        Contact contact1 = new Contact(
                1L,
                "Krishna",
                "S Lal",
                "krishna@gmail.com",
                "9874563210",
                "8569741230"
        );

        Contact contact2 = new Contact(
                2L,
                "Kiran",
                "Jith",
                "kiran@gmail.com",
                "8974521660",
                "9632587410"
        );

        when(contactRepository.findAll())
                .thenReturn(Arrays.asList(contact1, contact2));

        var contacts = contactService.getAllContacts();

        assertEquals(2, contacts.size());

        assertEquals(1L, contacts.get(0).getId());
        assertEquals("Krishna", contacts.get(0).getFirstName());

        assertEquals(2L, contacts.get(1).getId());
        assertEquals("Kiran", contacts.get(1).getFirstName());

        verify(contactRepository).findAll();
    }


    // READ ONE
    @Test
    void shouldGetContactById() {

        Contact contact = new Contact(
                1L,
                "Krishna",
                "S Lal",
                "krishna@gmail.com",
                "9874563210",
                "8569741230"
        );

        when(contactRepository.findById(1L))
                .thenReturn(Optional.of(contact));

        ContactResponseDTO response =
                contactService.getContactById(1L);

        assertEquals(1L, response.getId());
        assertEquals("Krishna", response.getFirstName());
        assertEquals("S Lal", response.getLastName());
        assertEquals("krishna@gmail.com", response.getEmail());
        assertEquals("9874563210", response.getPhone());
        assertEquals("8569741230", response.getAlternatePhone());

        verify(contactRepository).findById(1L);
    }


    // READ ONE - NOT FOUND
    @Test
    void shouldThrowExceptionWhenContactNotFound() {

        when(contactRepository.findById(99L))
                .thenReturn(Optional.empty());

        ContactNotFoundException exception =
                assertThrows(
                        ContactNotFoundException.class,
                        () -> contactService.getContactById(99L)
                );

        assertEquals(
                "Contact not found with id: 99",
                exception.getMessage()
        );

        verify(contactRepository).findById(99L);
    }


    // UPDATE
    @Test
    void shouldUpdateContact() {

        Contact existingContact = new Contact(
                1L,
                "Krishna",
                "S Lal",
                "krishnaslal@example.com",
                "9874563210",
                "8888888888"
        );

        ContactRequestDTO request = new ContactRequestDTO(
                "Krishna",
                "S Lal",
                "krishnas@gmail.com",
                "7896541230",
                "8888888888"
        );

        when(contactRepository.findById(1L))
                .thenReturn(Optional.of(existingContact));

        when(contactRepository.save(any(Contact.class)))
                .thenReturn(existingContact);

        ContactResponseDTO response =
                contactService.updateContact(1L, request);

        assertEquals(1L, response.getId());
        assertEquals("Krishna", response.getFirstName());
        assertEquals("S Lal", response.getLastName());
        assertEquals("krishnas@gmail.com", response.getEmail());
        assertEquals("7896541230", response.getPhone());
        assertEquals("8888888888", response.getAlternatePhone());

        verify(contactRepository).findById(1L);
        verify(contactRepository).save(existingContact);
    }


    // UPDATE - NOT FOUND
    @Test
    void shouldThrowExceptionWhenUpdatingNonExistingContact() {

        ContactRequestDTO request = new ContactRequestDTO(
                "Krishna",
                "S Lal",
                "krishna@gmail.com",
                "9874563210",
                "8569741230"
        );

        when(contactRepository.findById(99L))
                .thenReturn(Optional.empty());

        ContactNotFoundException exception =
                assertThrows(
                        ContactNotFoundException.class,
                        () -> contactService.updateContact(99L, request)
                );

        assertEquals(
                "Contact not found with id: 99",
                exception.getMessage()
        );

        verify(contactRepository).findById(99L);
        verify(contactRepository, never()).save(any(Contact.class));
    }


    // DELETE
    @Test
    void shouldDeleteContact() {

        Contact contact = new Contact(
                1L,
                "Krishna",
                "S Lal",
                "krishna@gmail.com",
                "9874563210",
                "9632587410"
        );

        when(contactRepository.findById(1L))
                .thenReturn(Optional.of(contact));

        contactService.deleteContact(1L);

        verify(contactRepository).findById(1L);
        verify(contactRepository).delete(contact);
    }


    // DELETE - NOT FOUND
    @Test
    void shouldThrowExceptionWhenDeletingNonExistingContact() {

        when(contactRepository.findById(99L))
                .thenReturn(Optional.empty());

        ContactNotFoundException exception =
                assertThrows(
                        ContactNotFoundException.class,
                        () -> contactService.deleteContact(99L)
                );

        assertEquals(
                "Contact not found with id: 99",
                exception.getMessage()
        );

        verify(contactRepository).findById(99L);
        verify(contactRepository, never()).delete(any(Contact.class));
    }
    
    // PARTIAL UPDATE
    
    @Test
    void partialUpdateContact_shouldUpdateOnlyProvidedField() {

        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("Arjun");
        contact.setLastName("Sah");
        contact.setEmail("arjun@gmail.com");
        contact.setPhone("7854693210");
        contact.setAlternatePhone("9999999889");

        ContactPatchDTO patchDTO = new ContactPatchDTO();
        patchDTO.setPhone("9876543210");

        when(contactRepository.findById(1L))
                .thenReturn(Optional.of(contact));

        when(contactRepository.save(any(Contact.class)))
                .thenReturn(contact);

        ContactResponseDTO result =
                contactService.partialUpdateContact(1L, patchDTO);

        assertEquals("9876543210", result.getPhone());
        assertEquals("Arjun", result.getFirstName());
        assertEquals("Sah", result.getLastName());
        assertEquals("arjun@gmail.com", result.getEmail());

        verify(contactRepository).findById(1L);
        verify(contactRepository).save(contact);
    }
    
    //Partial update with multiple fields
    
    @Test
    void partialUpdateContact_shouldUpdateMultipleProvidedFields() {

        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("Arjun");
        contact.setLastName("Sah");
        contact.setEmail("arjun@gmail.com");
        contact.setPhone("7854693210");
        contact.setAlternatePhone("9999999889");

        ContactPatchDTO patchDTO = new ContactPatchDTO();

        patchDTO.setFirstName("Rahul");
        patchDTO.setPhone("9876543210");

        when(contactRepository.findById(1L))
                .thenReturn(Optional.of(contact));

        when(contactRepository.save(any(Contact.class)))
                .thenReturn(contact);

        ContactResponseDTO result =
                contactService.partialUpdateContact(1L, patchDTO);

        assertEquals("Rahul", result.getFirstName());
        assertEquals("9876543210", result.getPhone());

        assertEquals("Sah", result.getLastName());
        assertEquals("arjun@gmail.com", result.getEmail());

        verify(contactRepository).findById(1L);
        verify(contactRepository).save(contact);
    }
    
    //Contact doesn't exist
    
    @Test
    void partialUpdateContact_shouldThrowExceptionWhenContactNotFound() {

        ContactPatchDTO patchDTO = new ContactPatchDTO();
        patchDTO.setPhone("9876543210");

        when(contactRepository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(
                ContactNotFoundException.class,
                () -> contactService.partialUpdateContact(99L, patchDTO)
        );

        verify(contactRepository).findById(99L);
        verify(contactRepository, never()).save(any(Contact.class));
    }
    
    //Search Contact
    
    @Test
    void searchContacts_shouldReturnMatchingContacts() {

        Contact contact = new Contact();
        contact.setId(1L);
        contact.setFirstName("Arjun");
        contact.setLastName("Sah");
        contact.setEmail("arjun@gmail.com");
        contact.setPhone("9876543210");
        contact.setAlternatePhone("9999999889");

        when(contactRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingOrAlternatePhoneContaining(
                        "Arjun",
                        "Arjun",
                        "Arjun",
                        "Arjun",
                        "Arjun"
                ))
                .thenReturn(Arrays.asList(contact));

        List<ContactResponseDTO> result =
                contactService.searchContacts("Arjun");

        assertEquals(1, result.size());
        assertEquals("Arjun", result.get(0).getFirstName());
        assertEquals("Sah", result.get(0).getLastName());

        verify(contactRepository).findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingOrAlternatePhoneContaining(
                "Arjun",
                "Arjun",
                "Arjun",
                "Arjun",
                "Arjun"
        );
    }
    
    //Search returns empty list when nothing matches
    
    @Test
    void searchContacts_shouldReturnEmptyListWhenNoContactFound() {

        when(contactRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingOrAlternatePhoneContaining(
                        "XYZ",
                        "XYZ",
                        "XYZ",
                        "XYZ",
                        "XYZ"
                ))
                .thenReturn(Arrays.asList());

        List<ContactResponseDTO> result =
                contactService.searchContacts("XYZ");

        assertEquals(0, result.size());

        verify(contactRepository).findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingOrAlternatePhoneContaining(
                "XYZ",
                "XYZ",
                "XYZ",
                "XYZ",
                "XYZ"
        );
    }
    
    
}

