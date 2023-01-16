package org.kremlevmax.restCrudApp.DAO;

import org.kremlevmax.restCrudApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAllPersons() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getPersonById(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
         jdbcTemplate.update("INSERT INTO Person VALUES (?, ?, ?, ?, ?, ?)",
                                person.getId(),
                                person.getFirstName(),
                                person.getLastName(),
                                person.getPob(),
                                person.getEmail(),
                                person.getAge());
    }

    public void updatePerson(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET firstName=?, lastName=?, pob=?, email=?, age=? WHERE id=?",
                updatedPerson.getFirstName(),
                updatedPerson.getLastName(),
                updatedPerson.getPob(),
                updatedPerson.getEmail(),
                updatedPerson.getAge(),
                id
        );
    }

    public void deletePerson(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?",
                id
        );
    }
}
