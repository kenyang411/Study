package AOP.aspectJ.jdbc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJdbc {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate npjt;

    @Before
    public void init() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

        npjt = ctx.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);
    }

    //本地版本过高，没有测试

    /**
     * update():增删改操作
     */
    @Test
    public void testUpdate() {
        String sql = " insert into employee (last_name,email,gender,d_id) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"李当心", "2333@123.com", 1, 3});
    }

    /**
     * batchUpdate():批量增删改
     */
    @Test
    public void testBatchUpdate() {
        String sql = " insert into employee (last_name,email,gender,d_id) VALUES(?,?,?,?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new Object[]{"吴南北", "wnb@qq.com", 1, 2});
        batchArgs.add(new Object[]{"李东西", "ldx@qq.com", 0, 3});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     * queryForObject():
     * 1.查询单行数据，返回一个对象
     * 2.查询单值，返回单个值
     */
    @Test
    public void testqueryForObjectReturnObject(int Id) {
        String sql = " select id,last_name,email,gender from employee where id=? ";
        //rowMapper:行映射，将结果集的一条数据映射成具体的一个java对象
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);

        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, Id);
        System.out.println(employee);
    }

    @Test
    public void testQueryForObjectReturnValue() {
        String sql = "select count(1) from employee";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    /**
     * query()： 查询多条数据返回多个对象的集合
     */
    @Test
    public void testQuery() {
        String sql = "select id,last_name,email,gender from employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper);
        System.out.println(employees);
    }

    /**
     * 测试具名参数模板类
     */
    public void testNpjt() {
        String sql = "insert into employee (last_name,email,gender,d_id) VALUES(:ln,:em,:gen,:did)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ln", "我是具名");
        paramMap.put("em", "juming@qq.com");
        paramMap.put("gen", 1);
        paramMap.put("did", 4);
        npjt.update(sql, paramMap);
    }

    @Test
    public void testNpjtObject() {
    //模拟Service层传递给Dao层一个具体的对象
        Employee employee=new Employee(null,"李淳罡","lichungang@qq.com",1);

        //在dao的插入方法中：
        String sql="insert into employee(last_name,email,gender) VALUES(:last_name,:email,:gender))";
        SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(employee);
                npjt.update(sql,parameterSource);
    }

}
