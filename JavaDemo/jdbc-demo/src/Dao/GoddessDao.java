package Dao;

import Db.DbUtil;
import Model.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoddessDao {

    //增加
    public void addGoddess(Goddess goddess) throws SQLException{
        //获取连接
        Connection conn=DbUtil.getConnection();

        //sql
        String sql="INSERT INTO imooc_goddess(user_name, sex, age, birthday, email, mobile,\"+\n" +
                "            \"create_user, create_date, update_user, update_date, isdel)\"\n" +
                "                +\"values(\"+\"?,?,?,?,?,?,?,CURRENT_DATE(),?,CURRENT_DATE(),?)";

        //预编译
        PreparedStatement ptmt=conn.prepareStatement(sql);  //预编译SQL，减少sql执行

        //传参
        ptmt.setString(1,goddess.getUser_name());
        ptmt.setInt(2,goddess.getSex());
        ptmt.setInt(3,goddess.getAge());
        ptmt.setDate(4, (Date) goddess.getBirthday());
        ptmt.setString(5,goddess.getEmial());
        ptmt.setInt(6,goddess.getMobile());
        ptmt.setString(7,goddess.getCreate_user());
        ptmt.setString(8,goddess.getUpdate_user());
        ptmt.setInt(9,goddess.getIsdel());

        //执行
        ptmt.execute();
}


//更新
    public void updateGoddess(Goddess goddess) throws SQLException {
        //获取连接
        Connection conn=DbUtil.getConnection();
        //sql
        String sql="UPDATE imooc_goddess\" +\n" +
                "                \" set user_name=?, sex=?, age=?, birthday=?, email=?, mobile=?,\"+\n" +
                "                \" update_user=?, update_date=CURRENT_DATE(), isdel=? \"+\n" +
                "                \" where id=?";

        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
        ptmt.setString(1,goddess.getUser_name());
        ptmt.setInt(2,goddess.getSex());
        ptmt.setInt(3,goddess.getAge());
        ptmt.setDate(4, (Date) goddess.getBirthday());
        ptmt.setString(5,goddess.getEmial());
        ptmt.setInt(6,goddess.getMobile());
        ptmt.setString(7,goddess.getUpdate_user());
        ptmt.setInt(8,goddess.getIsdel());
        ptmt.setInt(9,goddess.getId());

        //执行
        ptmt.execute();
    }


    //删除
    public void delGoddess(int id) throws SQLException {
        //获取连接
        Connection conn=DbUtil.getConnection();
        //sql
        String sql="delete from imooc_goddess where id=?";

        //预编译
        PreparedStatement ptmt=conn.prepareStatement(sql);

        //传参
        ptmt.setInt(1,id);

        //执行
        ptmt.execute();
    }


    //查询
    public List<Goddess> query() throws SQLException {
        //获取连接
        Connection conn=DbUtil.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT user_name,age from  imooc_goddess");


        List<Goddess> goddesses=new ArrayList<Goddess>();
        Goddess goddess=null;
        while (rs.next()){
            goddess=new Goddess();
            goddess.setUser_name(rs.getString("user_name"));
            goddess.setAge(rs.getInt("age"));

            //添加到列表
            goddesses.add(goddess);
        }
        return goddesses;
    }


    //根据id查询
    public Goddess get(int id) throws  SQLException{

        Goddess goddess=null;
        //连接
        Connection conn=DbUtil.getConnection();

        //sql
        String sql="SELECT * FROM imooc_goddess where id=?";

        //预编译 减少sql执行时间
        PreparedStatement ptmt=conn.prepareStatement(sql);

        //传参
        ptmt.setInt(1,id);

        //执行
        ResultSet rs= ptmt.executeQuery();

        while (rs.next()){
            goddess=new Goddess();
            goddess.setId(rs.getInt("id"));
            goddess.setUser_name(rs.getString("user_name"));
            goddess.setAge(rs.getInt("age"));
            goddess.setSex(rs.getInt("sex"));
            goddess.setBirthday(rs.getDate("birthday"));
            goddess.setEmial(rs.getString("email"));
            goddess.setMobile(rs.getInt("mobile"));
            goddess.setCreate_date(rs.getDate("create_date"));
            goddess.setCreate_user(rs.getString("create_user"));
            goddess.setUpdate_date(rs.getDate("update_date"));
            goddess.setUpdate_user(rs.getString("update_user"));
            goddess.setIsdel(rs.getInt("isdel"));
        }
        return goddess;
    }


}
