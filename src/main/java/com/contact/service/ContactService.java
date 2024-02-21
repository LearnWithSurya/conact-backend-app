package com.contact.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contact.binding.ContactForm;
@Service
public interface ContactService {

	public String saveContact(ContactForm form);
	
	public List<ContactForm> viewContacts();
	
	//public ContactForm editContact(Integer contactId);
	
	public List<ContactForm> deleteContact(Integer contactId);

	public String updateContact(Integer contactId, ContactForm update);
    

}
