package com.kungfudev.tutorials.springjdbc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * User: Kevin W. Sewell
 * Date: 2014-08-05
 * Time: 10h12
 */
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-config.xml",
        "classpath:/META-INF/spring/spring-jdbc.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class H2SpringJdbcIntegrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {

        try {
            jdbcTemplate.execute("drop table test;");
        } catch (DataAccessException ignore) {
        }
    }

    @Test
    public void shouldCreateAndDropTable() throws Exception {

        jdbcTemplate.execute("create table test (id int primary key, name varchar(255));");

        jdbcTemplate.execute("drop table test;");
    }

    @Test
    public void shouldInsertAndQueryData() throws Exception {

        jdbcTemplate.execute("create table test (id int primary key, name varchar(255));");

        jdbcTemplate.execute("insert into test (id, name) values (1, 'Geoff')");

        /*
         * Query Option 1
         */
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from test;");

        Assert.assertNotNull(maps);
        Assert.assertEquals(1, maps.size());

        Map<String, Object> map = maps.get(0);
        Integer id = (Integer) map.get("id");
        Assert.assertEquals(new Integer(1), id);

        String name = (String) map.get("name");
        Assert.assertEquals("Geoff", name);

        /*
         * Query Option 2
         */
        List<TestEntity> testEntities = jdbcTemplate.query("select id, name from test;", new RowMapper<TestEntity>() {
            @Override
            public TestEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                TestEntity testEntity = new TestEntity();
                testEntity.setId(rs.getInt("id"));
                testEntity.setName(rs.getString("name"));
                return testEntity;
            }
        });

        Assert.assertNotNull(testEntities);
        Assert.assertEquals(1, testEntities.size());

        TestEntity testEntity = testEntities.get(0);
        id = testEntity.getId();
        Assert.assertEquals(new Integer(1), id);

        name = testEntity.getName();
        Assert.assertEquals("Geoff", name);

        jdbcTemplate.execute("drop table test;");
    }
}
