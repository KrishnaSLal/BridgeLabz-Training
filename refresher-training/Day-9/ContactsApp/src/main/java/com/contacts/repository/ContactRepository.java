package com.contacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacts.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingOrAlternatePhoneContaining(
            String firstName,
            String lastName,
            String email,
            String phone,
            String alternatePhone
    );
}