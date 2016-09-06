package com.pelayolluna.filmviewerservice.serviceTEST;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pelayolluna.filmviewerservice.domainTEST.Person;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

@Service("personService")
public class PersonService {

    protected static final Logger logger = Logger.getLogger("service");

    private static final AtomicLong counter = new AtomicLong();
    private static final List<Person> persons = new ArrayList<Person>();

    public PersonService() {

    }

    public void fillDB() {
        logger.debug("Iniciando DB");

        Person person1 = new Person();
        person1.setId(0L);
        person1.setFirstName("Juan");
        person1.setLastName("Perez");
        person1.setMoney(1000.0);

        Person person2 = new Person();
        person2.setId(1L);
        person2.setFirstName("Elias");
        person2.setLastName("Lopez");
        person2.setMoney(1000.0);

        Person person3 = new Person();
        person3.setId(2L);
        person3.setFirstName("Rodrigo");
        person3.setLastName("Sanz");
        person3.setMoney(1000.0);

        Person person4 = new Person();
        person4.setId(3L);
        person4.setFirstName("Carla");
        person4.setLastName("Martinez");
        person4.setMoney(1000.0);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
    }

    public List<Person> findAllPersons() {
        return persons;
    }

    public Person findById(long id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public Person findByFirstName(String firstName) {
        for (Person person : persons) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                return person;
            }
        }
        return null;
    }

    public Person findByLastName(String lastName) {
        for (Person person : persons) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                return person;
            }
        }
        return null;
    }

    public void savePerson(Person person) {
        if (persons != null) {
            counter.set(0);

            for (Person p : persons) {
                counter.incrementAndGet();
            }

            person.setId(counter.getAndIncrement());
        }
        persons.add(person);
    }

    public void updatePerson(Person person) {
        int index = persons.indexOf(person);
        persons.set(index, person);
    }

    public void deletePersonById(long id) {
        for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
            Person person = iterator.next();
            if (person.getId() == id) {
                iterator.remove();
            }
        }
    }

    public boolean isPersonExist(Person person) {
        return findByFirstName(person.getFirstName()) != null;
    }

    public void deleteAllPersons() {
        persons.clear();
    }
}
