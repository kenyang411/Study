package Model;

import java.util.Date;

public class Goddess {
    private Integer id;
    private String user_name;
    private Integer sex;
    private Integer age;
    private Date birthday;
    private String email;
    private Integer mobile;
    private String update_user;
    private Date update_date;
    private Integer isdel;
    private String create_user;
    private Date create_date;


    //setter方法
    public void setId(Integer id){
        this.id=id;
    }

    public void setUser_name(String user_name){
        this.user_name=user_name;
    }

    public void setSex(Integer sex){
        this.sex=sex;
    }

    public void setAge(Integer age){
        this.age=age;
    }

    public void setBirthday(Date birthday){
        this.birthday=birthday;
    }

    public void setEmial(String email){
        this.email=email;
    }

    public void setMobile(Integer mobile){
        this.mobile=mobile;
    }

    public void setUpdate_user(String update_user){
        this.update_user=update_user;
    }

    public void setUpdate_date(Date update_date){
        this.update_date=update_date;
    }

    public void setCreate_user(String create_user){
        this.create_user=create_user;
    }

    public void setCreate_date(Date create_date){
        this.create_date=create_date;
    }

    public void setIsdel(Integer isdel){
     this.isdel=isdel;
    }

    //getter方法
    public Integer getId(){
        return this.id;
    }

    public String getUser_name(){
        return this.user_name;
    }

    public Integer getSex(){
        return this.sex;
    }

    public Integer getAge(){
        return this.age;
    }

    public Date getBirthday(){
        return this.birthday;
    }

    public String getEmial(){
        return this.email;
    }

    public Integer getMobile(){
        return this.mobile;
    }

    public String getUpdate_user(){
        return this.update_user;
    }

    public Date getUpdate_date(){
        return this.update_date;
    }

    public String getCreate_user(){
        return this.create_user;
    }

    public Date getCreate_date(){
        return this.create_date;
    }

    public Integer getIsdel(){
        return this.isdel;
    }


}
