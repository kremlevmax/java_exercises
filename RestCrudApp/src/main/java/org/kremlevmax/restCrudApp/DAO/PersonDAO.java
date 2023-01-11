package org.kremlevmax.restCrudApp.DAO;

import org.kremlevmax.restCrudApp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PERSON_COUNT;
    private List<Person> db;

    {
        db = new ArrayList<>();
        db.add(new Person(++PERSON_COUNT, "David", "Duchovny"));
        db.add(new Person(++PERSON_COUNT, "Jillian", "Anderson"));
    }

    public List<Person> getAllPersons() {
        return db;
    }

    public Person getPersonById(int id) {
        return db.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PERSON_COUNT);
        db.add(person);
    }
}
