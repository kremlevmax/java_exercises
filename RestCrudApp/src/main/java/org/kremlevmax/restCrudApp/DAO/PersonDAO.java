package org.kremlevmax.restCrudApp.DAO;

import org.kremlevmax.restCrudApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
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
         jdbcTemplate.update("INSERT INTO Person(firstName, lastName, pob, email, age) VALUES(?, ?, ?, ?, ?) ",
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

    private List<Person> create1000People() {
        List<Person> people = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            people.add(new Person(i, "FirstName "+i, "LastName "+i, "POB "+i, "email"+i+"@email.com", i));
        }

        return people;
    }

        public void createWithoutBatch() {
        List<Person> people = create1000People();

        for (Person person : people) {
            jdbcTemplate.update("INSERT INTO Person(firstName, lastName, pob, email, age) VALUES (?, ?, ?, ?, ?)",
                    person.getFirstName(),
                    person.getLastName(),
                    person.getPob(),
                    person.getEmail(),
                    person.getAge());
        }
    }

    public void createWithBatch() {
        List<Person> people = create1000People();

        jdbcTemplate.batchUpdate("INSERT INTO Person(firstName, lastName, pob, email, age) VALUES (?, ?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, people.get(i).getFirstName());
                ps.setString(2, people.get(i).getLastName());
                ps.setString(3, people.get(i).getPob());
                ps.setString(4, people.get(i).getEmail());
                ps.setInt(5, people.get(i).getAge());
            }

            @Override
            public int getBatchSize() {
                return people.size();
            }
        });
    }
}
