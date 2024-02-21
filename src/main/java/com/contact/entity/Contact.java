package com.contact.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="CONTACT_DTLS")
@Data
public class Contact {
@Id
@GeneratedValue
@Column(name="contact_id")
private Integer contactId;
@Column(name="contact_name")
private String contactName;
@Column(name="contact_email")
private String contactEmail;
@Column(name="contact_phone_number")
private Long contactPhoneNo;
@Column(name="Active_Switch")
private String activeSw;
@Column(name="created_date")
@CreationTimestamp
private LocalDate createdDate;
@UpdateTimestamp
@Column(name="update_date")
private LocalDate updateDate;

}

