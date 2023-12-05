package com.sir.tech.bd.repository;

import com.sir.tech.bd.domain.User;
import com.sir.tech.bd.jdbc.ConnectionPool;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class JdbcUserCustomerRepoImpl implements UserCustomerRepo {

    private DataSource dataSource
            = ConnectionPool.getInstance().getDataSource();


    private static final String INSERT_USER
            = "insert into user_list(" +
             " username, " + // 1
             " password, " + // 2
             " email_address, " + // 3
             " is_admin, " + // 4
             " first_name, " + // 5
             " last_name, " + // 6
             " version, " + // 7
             " date_created, " + // 8
             " date_last_updated) " + // 9
             " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    // Saving new User
    @Override
    public void save(User user) {
        try (var connection = dataSource.getConnection();
             var prstmnt = connection.prepareStatement(INSERT_USER)){
            prstmnt.setString(1, user.getUsername());
            prstmnt.setString(2, user.getPassword());
            prstmnt.setString(3, user.getEmail());
            prstmnt.setInt(4, user.getIsAdmin());
            prstmnt.setString(5, user.getFirstName());
            prstmnt.setString(6, user.getLastName());
            prstmnt.setLong(7, user.getVersion());
            prstmnt.setTimestamp(8, Timestamp.valueOf(user.getDate_created()));
            prstmnt.setTimestamp(9, Timestamp.valueOf(user.getDate_last_updated()));

            prstmnt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Unable to insert new user");
        }
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
