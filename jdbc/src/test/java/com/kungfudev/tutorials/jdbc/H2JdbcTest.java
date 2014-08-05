package com.kungfudev.tutorials.jdbc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Kevin W. Sewell
 * Date: 2014-08-05
 * Time: 09h53
 */
public class H2JdbcTest {

    @Before
    public void setUp() throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:h2:target/test", "sa", "");
        try {
            connection.prepareStatement("drop table test;").execute();
        } catch (SQLException ignore) {
        }
    }

    @Test
    public void shouldConnectToInMemoryH2Database() throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:h2:target/test", "sa", "");

        Assert.assertNotNull(connection);
    }

    @Test
    public void shouldCreateAndDropTable() throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:h2:target/test", "sa", "");

        connection
                .prepareStatement("create table test (id int primary key, name varchar(255));")
                .execute();

        connection
                .prepareStatement("drop table test;")
                .execute();
    }

    @Test
    public void shouldInsertAndQueryData() throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:h2:target/test", "sa", "");

        connection
                .prepareStatement("create table test (id int primary key, name varchar(255));")
                .execute();

        connection
                .prepareStatement("insert into test (id, name) values (1, 'Geoff');")
                .execute();

        ResultSet resultSet = connection
                .prepareStatement("select * from test;")
                .executeQuery();

        while (resultSet.next()) {

            // int id = resultSet.getInt(1);
            int id = resultSet.getInt("id");
            Assert.assertEquals(1, id);

            // String name = resultSet.getString(2);
            String name = resultSet.getString("name");
            Assert.assertEquals("Geoff", name);
        }

        connection
                .prepareStatement("drop table test;")
                .execute();
    }
}
