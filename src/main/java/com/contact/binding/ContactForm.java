package com.contact.binding;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class ContactForm {

	private Integer contactId;

	private String contactName;
	
	private String contactEmail;
	
	private Long contactPhoneNo;
	
	private String activeSw;
	
	private LocalDate createdDate;
	
	private LocalDate updateDate;

}
