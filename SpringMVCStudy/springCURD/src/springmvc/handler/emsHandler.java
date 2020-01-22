package springmvc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springmvc.beans.Department;
import springmvc.beans.Employee;
import springmvc.dao.DepartmentDao;
import springmvc.dao.EmployeeDao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class emsHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 文件上传
     */
    @RequestMapping("/upload")
    public String testUploadFile(@RequestParam("desc") String desc,
                                 @RequestParam("uploadFile")MultipartFile uploadFile,
                                 HttpSession httpSession) throws IOException {
        //获取上传文件的名字
        String uploadFileName=uploadFile.getOriginalFilename();
        //获取输入流
        InputStream in=uploadFile.getInputStream();
        //获取服务器端的uploads文件夹真实路径
        ServletContext sc=httpSession.getServletContext();
        String realPath=sc.getRealPath("uploads");
        File targetFile=new File(realPath +"/"+uploadFileName);

//        FileOutputStream os=new FileOutputStream(targetFile);
//
//        //写文件
//        int i;
//        while ((i=in.read())!=-1){
//            os.write(i);
//        }
//        in.close();
//        os.close();

        //提供了一种方法直接保存
        uploadFile.transferTo(targetFile);

        return "success";
    }


    /**
     * 使用HttpMessageConveter完成下载功能：
     * 支持@RequestBody @ResponseBody  HttpEntity ResponseEntity(下载)
     * 下载原理：将服务器文件以流的形式写到客户端。
     * ResponseEntity:将下载的文件数据，以及响应信息封装到ResponseEntity对象中，浏览器端通过解析发送回去的响应数据，就可以进行一个下载操作。
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> testDownload(HttpSession session) throws IOException {
        //将要下载的文件读取成一个字节数据
        byte[] imgs;
        ServletContext sc=session.getServletContext();
        InputStream in= sc.getResourceAsStream("image/123.jpg");
        imgs=new byte[in.available()];  //分配字节长度
        in.read(imgs);
        //将相应数据 以及一些响应头信息封装到ResponseEntity中
        /**
         * 参数：
         *  1.发送给浏览器端的数据
         *  2.设置响应头
         *  3.设置响应码
         */
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=123.jpg");
        HttpStatus statusCode=HttpStatus.OK;
        ResponseEntity<byte[]> re=new ResponseEntity<byte[]>(imgs,headers,statusCode);
        return re;
    }

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
