package com.miniprojectone.binding;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="Contact_Table")
@Data
public class Contact {

    @Id
    @GeneratedValue
    private Integer contactId;
    private String contactName;
    private String contactEmail;
    private Long contactNum;
}
