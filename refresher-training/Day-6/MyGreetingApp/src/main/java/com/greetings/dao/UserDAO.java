package com.greetings.dao;

import com.greetings.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    // Spring Boot provides and manages the database connection
    @Autowired
    private DataSource dataSource;


    
    // CREATE - REGISTER USER
   

    public boolean registerUser(User user) {

        String sql =
                "INSERT INTO users (name, email, password) " +
                "VALUES (?, ?, ?)";

        try (
                Connection connection =
                        dataSource.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(
                    1,
                    user.getName()
            );

            preparedStatement.setString(
                    2,
                    user.getEmail()
            );

            preparedStatement.setString(
                    3,
                    user.getPassword()
            );

            int rows =
                    preparedStatement.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // READ - CHECK EMAIL
    
    public boolean emailExists(String email) {

        String sql =
                "SELECT id FROM users WHERE email = ?";

        try (
                Connection connection =
                        dataSource.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(
                    1,
                    email
            );

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    
    // READ - LOGIN
    

    public User login(
            String email,
            String password) {

        String sql =
                "SELECT * FROM users " +
                "WHERE email = ? AND password = ?";

        try (
                Connection connection =
                        dataSource.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(
                    1,
                    email
            );

            preparedStatement.setString(
                    2,
                    password
            );

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


   
    // READ - GET ALL USERS
   

    public List<User> getAllUsers() {

        List<User> users =
                new ArrayList<>();

        String sql =
                "SELECT * FROM users";

        try (
                Connection connection =
                        dataSource.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {

                User user =
                        new User(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("password")
                        );

                users.add(user);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return users;
    }


    // READ - GET USER BY ID
  
    public User getUserById(int id) {

        String sql =
                "SELECT * FROM users WHERE id = ?";

        try (
                Connection connection =
                        dataSource.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(
                    1,
                    id
            );

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    
    // UPDATE - UPDATE USER
    
    public boolean updateUser(User user) {

        String sql =
                "UPDATE users " +
                "SET name = ?, email = ?, password = ? " +
                "WHERE id = ?";

        try (
                Connection connection =
                        dataSource.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(
                    1,
                    user.getName()
            );

            preparedStatement.setString(
                    2,
                    user.getEmail()
            );

            preparedStatement.setString(
                    3,
                    user.getPassword()
            );

            preparedStatement.setInt(
                    4,
                    user.getId()
            );

            int rows =
                    preparedStatement.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    
    // DELETE - DELETE USER
   
    public boolean deleteUser(int id) {

        String sql =
                "DELETE FROM users WHERE id = ?";

        try (
                Connection connection =
                        dataSource.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(
                    1,
                    id
            );

            int rows =
                    preparedStatement.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }
}