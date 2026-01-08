package com.sparta.ioc.beans;

import com.sparta.ioc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Pet {

    private String name;

    public String getOwner() {
       if(owner == null){
           return "No owner";
       }
        return owner.getFullName();
    }

//    @Autowired
//    @Qualifier("janeDoe")
    private Person owner;

//    public Pet() {
//    }
//
//
//    public Pet(String name) {
//        this.name = name;
//    }

    @Autowired
    public Pet(Person owner){
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}