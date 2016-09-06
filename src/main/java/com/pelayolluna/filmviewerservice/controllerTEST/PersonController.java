package com.pelayolluna.filmviewerservice.controllerTEST;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pelayolluna.filmviewerservice.domainTEST.Person;
import com.pelayolluna.filmviewerservice.domainTEST.PersonList;
import com.pelayolluna.filmviewerservice.serviceTEST.PersonService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class PersonController {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name = "personService")
    private PersonService personService;

    //========================================================================================
    // Llenar la DB
    //========================================================================================
    @RequestMapping(value = "/fillDB", method = RequestMethod.GET)
    private String fillDB() {
        personService.fillDB();
        return "ok";
    }

    //========================================================================================
    // Obtener todas las personas en XML
    //========================================================================================
    @RequestMapping(value = "/personsXml", method = RequestMethod.GET, produces = "application/xml")
    private @ResponseBody
    PersonList getPersonsXml() {

        PersonList result = new PersonList();
        result.setData(personService.findAllPersons());

        return result;
    }

    //========================================================================================
    // Obtener una persona en XML
    //========================================================================================
    @RequestMapping(value = "/personXml/{id}", method = RequestMethod.GET, produces = "application/xml")
    private @ResponseBody
    Person getPersonXml(@PathVariable("id") long id) {
        return personService.findById(id);
    }

    //========================================================================================
    // Obtener todas las personas en JSON
    //========================================================================================
    @RequestMapping(value = "/personsJson", method = RequestMethod.GET, produces = "application/json")
    private @ResponseBody
    PersonList getPersonsJson() {

        PersonList result = new PersonList();
        result.setData(personService.findAllPersons());

        return result;
    }

    //========================================================================================
    // Obtener una persona en JSON
    //========================================================================================
    @RequestMapping(value = "/personJson/{id}", method = RequestMethod.GET, produces = "application/json")
    private @ResponseBody
    Person getPersonJson(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    //========================================================================================
    // A�adir una persona
    //========================================================================================
    @RequestMapping(value = "/person/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPerson(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + person.getFirstName());

        if (personService.isPersonExist(person)) {
            System.out.println("A User with name " + person.getFirstName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        personService.savePerson(person);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/person/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //========================================================================================
    // Actualizar una persona
    //========================================================================================
    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        System.out.println("Updating User " + id);

        Person currentUser = personService.findById(id);

        if (currentUser == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }

        currentUser.setFirstName(person.getFirstName());
        currentUser.setLastName(person.getLastName());
        currentUser.setMoney(person.getMoney());

        personService.updatePerson(currentUser);
        return new ResponseEntity<Person>(currentUser, HttpStatus.OK);
    }

    //========================================================================================
    // Borrar una persona
    //========================================================================================
    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> deletePerson(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        Person person = personService.findById(id);
        if (person == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }

        personService.deletePersonById(id);
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }

    //========================================================================================
    // Borrar todas las personas
    //========================================================================================
    @RequestMapping(value = "/persons/", method = RequestMethod.DELETE)
    public ResponseEntity<Person> deleteAllPersons() {
        System.out.println("Deleting All Users");

        personService.deleteAllPersons();
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }
}
