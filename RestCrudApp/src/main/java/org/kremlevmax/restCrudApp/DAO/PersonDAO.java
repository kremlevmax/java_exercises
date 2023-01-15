package org.kremlevmax.restCrudApp.DAO;

import org.kremlevmax.restCrudApp.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PERSON_COUNT;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/javaspringprojectdb";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getAllPersons() {
        List<Person> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getInt("age"));
                person.setFirstName(resultSet.getString("firstName"));
                person.setLastName(resultSet.getString("lastName"));
                person.setEmail(resultSet.getString("email"));
                person.setPob(resultSet.getString("pob"));

                result.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public Person getPersonById(int id) {
        Person person = new Person();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person WHERE id="+id;
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {

                person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getInt("age"));
                person.setFirstName(resultSet.getString("firstName"));
                person.setLastName(resultSet.getString("lastName"));
                person.setEmail(resultSet.getString("email"));
                person.setPob(resultSet.getString("pob"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public void save(Person person) {
//        person.setId(++PERSON_COUNT);
//        db.add(person);
    }

    public void updatePerson(int id, Person updatedPerson) {
//        Person personToUpdate = getPersonById(id);
//        personToUpdate.setFirstName(updatedPerson.getFirstName());
//        personToUpdate.setLastName(updatedPerson.getLastName());
//        personToUpdate.setPob(updatedPerson.getPob());
//        personToUpdate.setAge(updatedPerson.getAge());
//        personToUpdate.setEmail(updatedPerson.getEmail());
    }

    public void deletePerson(int id) {
//        db.remove(getPersonById(id));
    }
}
