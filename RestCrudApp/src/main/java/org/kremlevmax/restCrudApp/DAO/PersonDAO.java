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
                Person person = new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("pob"),
                        resultSet.getString("email"),
                        resultSet.getInt("age")
                );
                result.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Person getPersonById(int id) {
        Person person = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Person WHERE id=?"
            );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            person = new Person(
                    resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("pob"),
                    resultSet.getString("email"),
                    resultSet.getInt("age")
                    );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public void save(Person person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Person VALUES (?, ?, ?, ?, ?, ?)"
            );
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getPob());
            preparedStatement.setString(5, person.getEmail());
            preparedStatement.setInt(6, person.getAge());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePerson(int id, Person updatedPerson) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Person SET firstName=?, lastName=?, pob=?, email=?, age=? WHERE id=?"
            );
            preparedStatement.setString(1, updatedPerson.getFirstName());
            preparedStatement.setString(2, updatedPerson.getLastName());
            preparedStatement.setString(3, updatedPerson.getPob());
            preparedStatement.setString(4, updatedPerson.getEmail());
            preparedStatement.setInt(5, updatedPerson.getAge());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePerson(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Person WHERE id=?"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
