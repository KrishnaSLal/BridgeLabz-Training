package com.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacts.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}