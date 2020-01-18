package springmvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springmvc.beans.Department;
import springmvc.beans.Employee;
import springmvc.dao.DepartmentDao;
import springmvc.dao.EmployeeDao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class emsHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 显示所有员工信息列表
     */
    @RequestMapping(value ="/emps",method = RequestMethod.GET)
    public String getList(Map<String,Object> map){
        Collection<Employee> emps= employeeDao.getAll();
        map.put("emps",emps);
        System.out.println(map.toString());
        return "list";
    }


    /**
     * 添加功能：去往添加页面;
     * 添加页面需要部门数据
     */
    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String toAddPage(Map<String,Object> map){
        Collection<Department> depts= departmentDao.getDepartments();
        map.put("depts",depts);

        //2. 构造页面中生成单选框的数据
        Map<String,String> genders=new HashMap<>();
        genders.put("0","女");
        genders.put("1","男");

        map.put("genders",genders);

        //3.设置页面中要回显的数据
        map.put("command",new Employee());
        return "input";
    }


    /**
     *添加功能：具体的添加操作
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmp(Employee employee){
            //添加员工
        employeeDao.save(employee);
        //回到列表页面
        return "redirect:/emps";
    }

    /**
     * 删除功能
     */


}
