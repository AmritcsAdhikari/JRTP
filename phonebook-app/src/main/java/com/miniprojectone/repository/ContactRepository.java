package com.miniprojectone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miniprojectone.binding.Contact;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
