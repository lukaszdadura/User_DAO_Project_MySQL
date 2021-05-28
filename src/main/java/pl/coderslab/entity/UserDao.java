package pl.coderslab.entity;


import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Arrays;

public class UserDao {

        private static final String CREATE_USER_QUERY = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id = ?";
        private static final String UPDATE_USER_QUERY = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
        private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";
        private static final String FIND_ALL_QUERY = "SELECT * FROM users";


        public User create(User user) {



                try (Connection connection = DBUtil.getConnection()) {
                        PreparedStatement statement = connection.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
                        statement.setString(1, user.getUserName());
                        statement.setString(2, user.getEmail());
                        statement.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
                        statement.executeUpdate();
                        ResultSet resultSet = statement.getGeneratedKeys();
                        if (resultSet.next()) {
                                user.setId(resultSet.getInt(1));
                        }
                        return user;
                } catch (SQLException sql_ex) {
                        sql_ex.printStackTrace();
                }
                return null;
        }

        public User read(int userId) {

                try (Connection connection = DBUtil.getConnection()) {
                        PreparedStatement statement = connection.prepareStatement(READ_USER_QUERY);
                        statement.setInt(1, userId);
                        ResultSet resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                                User user = new User();
                                user.setId(resultSet.getInt(1));
                                user.setUserName(resultSet.getString(2));
                                user.setEmail(resultSet.getString(3));
                                user.setPassword(resultSet.getString(4));
                                return user;
                        }
                } catch (SQLException sqlEx2) {
                        sqlEx2.printStackTrace();
                }
                return null;
        }
        public void update(User user) {

                try(Connection connection = DBUtil.getConnection()) {
                        PreparedStatement statement = connection.prepareStatement(UPDATE_USER_QUERY);
                        statement.setString(1, user.getUserName());
                        statement.setString(2, user.getEmail());
                        statement.setString(3, user.getPassword());
                        statement.setInt(4, user.getId());
                        statement.executeUpdate();
                } catch (SQLException sqlEx3) {
                        sqlEx3.printStackTrace();
                }
        }
        public void delete(int userId) {

                try(Connection connection = DBUtil.getConnection()) {
                        PreparedStatement statement = connection.prepareStatement(DELETE_USER_QUERY);
                        statement.setInt(1, userId);
                        statement.executeUpdate();
                } catch (SQLException sqlEx4) {
                        sqlEx4.printStackTrace();
                }
        }
        public User[] findAll() {
                try (Connection connection = DBUtil.getConnection()) {
                        User[] users = new User[0];
                        PreparedStatement statement = connection.prepareStatement(FIND_ALL_QUERY);
                        ResultSet resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                                User user = new User();
                                user.setId(resultSet.getInt(1));
                                user.setUserName(resultSet.getString(2));
                                user.setEmail(resultSet.getString(3));
                                user.setPassword(resultSet.getString(4));
                                users = addToArray(user, users);
                        }
                        return users;
                } catch (SQLException sqlEx5) {
                        sqlEx5.printStackTrace();
                        return null;
                }
        }
        private User[] addToArray(User u, User[] users) {
                User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
                tmpUsers[users.length] = u;
                return tmpUsers;
        }




}
