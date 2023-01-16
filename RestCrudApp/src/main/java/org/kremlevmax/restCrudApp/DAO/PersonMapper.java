package org.kremlevmax.restCrudApp.DAO;

import org.kremlevmax.restCrudApp.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
       return new Person(
                resultSet.getInt("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("pob"),
                resultSet.getString("email"),
                resultSet.getInt("age")
        );
    }
}
