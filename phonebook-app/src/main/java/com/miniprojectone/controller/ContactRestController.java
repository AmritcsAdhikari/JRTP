package com.miniprojectone.controller;

import com.miniprojectone.binding.Contact;
import com.miniprojectone.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactRestController {

    @Autowired
    private ContactService contactService;


    @PostMapping("/contacts")
    public ResponseEntity<String> createContact(@RequestBody Contact contact){
    	System.out.println(contact.getContactName());
        String msg = contactService.saveContact(contact);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts(){
        List<Contact> contacts = contactService.getAllContacts();
        return new ResponseEntity<>(contacts,HttpStatus.OK);
    }

    @GetMapping("/contacts/{contactId}")
    public ResponseEntity<Contact> getContactById(@PathVariable Integer contactId){
        Contact contact = contactService.getContactById(contactId);
        return new ResponseEntity<>(contact,HttpStatus.OK);
    }

    @PutMapping("/contacts")
    public ResponseEntity<String> updateContact(@RequestBody Contact contact){
        String msg = contactService.updateContact(contact);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @DeleteMapping("contacts/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable Integer contactId){
        String msg = contactService.deleteContactById(contactId);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
