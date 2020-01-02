package annotation.dao;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoJdbcImpl implements UserDao {

    @Override
    public void addUser() {
        System.out.println("this is a Jdbc...");
    }
}
