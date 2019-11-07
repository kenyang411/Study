import Dao.GoddessDao;
import Model.Goddess;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        GoddessDao db=new GoddessDao();

        //根据id查询
        Goddess gd=db.get(1);
        System.out.println("姓名:"+gd.getUser_name()+" 年龄:" +gd.getAge());
    }
}
