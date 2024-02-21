package com.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.binding.ContactForm;
import com.contact.entity.Contact;
import com.contact.repo.ContactRepo;
@Service
public class ContactServiceImpl implements ContactService {
    
	@Autowired
	private ContactRepo contactRepo;
	@Override
	public String saveContact(ContactForm form) {
		Contact entity=new Contact();
		
		BeanUtils.copyProperties(form, entity);
		entity.setActiveSw("Y");
		entity = contactRepo.save(entity);
		
		if(entity.getContactId()!=null) {
			return "Contact Saved";
		}
		return "Contact Failed To Save";
	}

	@Override
	public List<ContactForm> viewContacts() {
	List<ContactForm> dataList=new ArrayList<>();
		
		List<Contact> findAll = contactRepo.findAll();
		for(Contact entity : findAll) {
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

//	@Override
//	public ContactForm editContact(Integer contactId) {
//		Optional<Contact> findById = contactRepo.findById(contactId);
//		if(findById.isPresent()) {
//			Contact entity = findById.get();
//			ContactForm form=new ContactForm();
//			BeanUtils.copyProperties(entity, form);
//			return form;
//		}
//		return null;
//	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		//1.soft delete   2.permanet delete or hard delete
		contactRepo.deleteById(contactId);
		//return viewContacts();
		//boiler plate code
        List<ContactForm> dataList=new ArrayList<>();
		
		List<Contact> findAll = contactRepo.findAll();
		for(Contact entity : findAll) {
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

   @Override
	public String updateContact(Integer contactId, ContactForm update) {
		  Optional<Contact> optionalContact = contactRepo.findById(contactId);
	        if (optionalContact.isPresent()) {
	            Contact entity = optionalContact.get();
	            BeanUtils.copyProperties(update, entity);
	            entity = contactRepo.save(entity);
	            if (entity.getContactId() != null) {
	                return "Update Successfully..!";
	            }
	        }
	        return "Failed to Update..!";

	}



}
