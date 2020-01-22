package springmvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * 使用HttpMessageConveter完成下载功能：
     * 支持@RequestBody @ResponseBody  HttpEntity ResponseEntity(下载)
     * 下载原理：将服务器文件以流的形式写到客户端。
     * ResponseEntity:将下载的文件数据，以及响应信息封装到ResponseEntity对象中，浏览器端通过解析发送回去的响应数据，就可以进行一个下载操作。
     */


    /**
     * 处理Json
     * @ResponseBody注解
     */
    @RequestMapping(value = "/testJson")
    @ResponseBody
    public Collection<Employee> testJson(){
        Collection<Employee> emps=employeeDao.getAll();
        return emps;
    }

    /**
     * 修改功能：具体的修改操作
     */
    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 修改功能：去往修改页面
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("id")Integer id,Map<String,Object>map) {
        //查询要修改的员工信息
        Employee employee= employeeDao.get(id);
        map.put("employee",employee);

        //页面中显示部门下拉列表的数据
        Collection<Department> depts=departmentDao.getDepartments();
        map.put("depts",depts);

        //页面中生成性别单选框的数据
        Map<String,String> genders=new HashMap<>();
        genders.put("0","女");
        genders.put("1","男");
        map.put("genders",genders);

        //重定向到添加页面
        return "input";
    }


    /**
     * 删除功能
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
//    @ResponseBody
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        //重定向到列表(使用@ResponseBody无法实现跳转)
        return "redirect:/emps";
    }

    /**
     * 显示所有员工信息列表
     */
    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String getList(Map<String, Object> map) {
        Collection<Employee> emps = employeeDao.getAll();
        map.put("emps", emps);
        System.out.println(map.toString());
        return "list";
    }


    /**
     * 添加功能：去往添加页面;
     * 添加页面需要部门数据
     */
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String toAddPage(Map<String, Object> map) {
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);

        //2. 构造页面中生成单选框的数据
        Map<String, String> genders = new HashMap<>();
        genders.put("0", "女");
        genders.put("1", "男");

        map.put("genders", genders);

        //3.设置页面中要回显的数据
        map.put("employee", new Employee());
        return "input";
    }


    /**
     * 添加功能：具体的添加操作
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(Employee employee) {
        //添加员工
        employeeDao.save(employee);
        //回到列表页面
        return "redirect:/emps";
    }


}
