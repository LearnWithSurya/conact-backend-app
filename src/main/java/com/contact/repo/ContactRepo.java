package com.contact.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact,Serializable>{

}

