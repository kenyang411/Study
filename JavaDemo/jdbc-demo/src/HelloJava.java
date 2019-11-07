import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloJava {
        public static final String URL="jdbc:mysql://localhost:3306/javatest";
        public static final String USER="root";
        public static final String PASSWORD="123456";

        public static void main(String[] args) throws Exception{
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取数据库连接
            Connection conn= DriverManager.getConnection(URL,USER,PASSWORD);
            //3.操作数据库，实现增删改查
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM imooc_goddess");
            //如果有数据，rs.next()返回true
            while (rs.next()){
                System.out.println(rs.getString("user_name")+"年龄"+rs.getInt("age"));
                System.out.print(rs.getString("user_name")+"性别"+rs.getInt("sex"));
                System.out.print(" 出生日期"+ rs.getDate("birthday"));
                System.out.print(" 手机号"+rs.getInt("mobile")+'\n');
            }
        }
    }

