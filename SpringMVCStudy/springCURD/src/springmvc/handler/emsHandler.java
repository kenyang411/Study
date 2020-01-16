package springmvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springmvc.beans.Employee;
import springmvc.dao.EmployeeDao;

import java.util.Collection;
import java.util.Map;

@Controller
public class emsHandler {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 显示所有员工信息列表
     */
    @RequestMapping(value ="/ems",method = RequestMethod.GET)
    public String getList(Map<String,Object> map){
        Collection<Employee> emps= employeeDao.getAll();
        map.put("emps",emps);
        System.out.println(map.toString());
        return "list";
    }
}
