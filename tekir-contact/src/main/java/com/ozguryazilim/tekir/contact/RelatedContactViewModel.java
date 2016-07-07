/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ozguryazilim.tekir.contact;

import com.ozguryazilim.tekir.entities.Contact;
import com.ozguryazilim.tekir.entities.ContactRelation;
import com.ozguryazilim.telve.entities.ViewModel;

/**
 *
 * @author oyas
 */
public class RelatedContactViewModel implements ViewModel{

    
    private Long id;
    private Contact sourceContact;
    private Contact targetContact;
    private ContactRelation relation;
    private String info;

    public RelatedContactViewModel(Long id, Contact sourceContact, Contact targetContact, ContactRelation relation, String info) {
        this.id = id;
        this.sourceContact = sourceContact;
        this.targetContact = targetContact;
        this.relation = relation;
        this.info = info;
    }
    
    public RelatedContactViewModel(Long id, Long sourceContactId, String sourceContactName, 
            Long targetContactId, String targetContactName, 
            Long relationId, String relationName, String info) {
        this.id = id;
        this.sourceContact = sourceContact;
        this.targetContact = targetContact;
        this.relation = relation;
        this.info = info;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contact getSourceContact() {
        return sourceContact;
    }

    public void setSourceContact(Contact sourceContact) {
        this.sourceContact = sourceContact;
    }

    public Contact getTargetContact() {
        return targetContact;
    }

    public void setTargetContact(Contact targetContact) {
        this.targetContact = targetContact;
    }

    public ContactRelation getRelation() {
        return relation;
    }

    public void setRelation(ContactRelation relation) {
        this.relation = relation;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
    
}
