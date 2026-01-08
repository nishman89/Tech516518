package com.sparta.ioc;


import com.sparta.ioc.beans.Pet;
import com.sparta.ioc.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

//        ApplicationContext contextXml = new ClassPathXmlApplicationContext("beans.xml");
//
//        Vehicle vehicleXml = contextXml.getBean(Vehicle.class);
//        Person personXml = contextXml.getBean(Person.class);
//        System.out.println(vehicleXml.getMake() + " " + vehicleXml.getModel());
//        System.out.println(personXml.getFirstName() + " " + personXml.getLastName());

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Vehicle vehicle = context.getBean("fordFiesta",Vehicle.class);
//        Person person = context.getBean(Person.class);
//        System.out.println(person.getFullName());
        System.out.println(vehicle.getMake() + " " + vehicle.getModel());
        Pet pet = context.getBean(Pet.class);
        System.out.println(pet.getName());
        pet.setName("Fido");
        System.out.println(pet.getName());
        System.out.println(pet.getOwner());

        Pet pet2 = context.getBean(Pet.class);

        pet2.setName("Nish");
        System.out.println(pet.getName());
        System.out.println(pet2.getName());
        System.out.println(pet.hashCode());
        System.out.println(pet2.hashCode()); //hashcodes the same as requesting same bean. Bean is created when we start our application



    }
}
