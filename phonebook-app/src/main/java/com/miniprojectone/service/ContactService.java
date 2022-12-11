package com.miniprojectone.service;

import com.miniprojectone.binding.Contact;

import java.util.List;

public interface ContactService {

    public String saveContact(Contact contact);
    public List<Contact> getAllContacts();
    public Contact getContactById(Integer contactId);
    public String updateContact (Contact contact);

    public String deleteContactById(Integer contactId);
}
