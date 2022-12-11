package com.miniprojectone.service;

import com.miniprojectone.repository.ContactRepository;

import com.miniprojectone.binding.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

	
	
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public String saveContact(Contact contact){
 
        contact = contactRepository.save(contact);
       
        if(contact.getContactId() != null){
            return "Contact with ID- "+ contact.getContactId()+" saved";
        }
        else{
            return "Contact Failed to Save!";
        }
    }

    @Override
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Integer contactId){
        Optional<Contact> findById = contactRepository.findById(contactId);
        if(findById.isPresent()){
            return findById.get();
        }
        return null;
    }

    @Override
    public String updateContact (Contact contact){

        if(contactRepository.existsById(contact.getContactId())){
            contactRepository.save(contact);
            return "Update Success";
        }
        else return "No Record Found";
    }

    @Override
    public String deleteContactById(Integer contactId){
        if(contactRepository.existsById(contactId)){
            contactRepository.deleteById(contactId);
            return "Record Deleted";
        }
        else{
            return "Delete Record Failed.";
        }
    }

}
