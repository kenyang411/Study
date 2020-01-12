package springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("test")
public class SpringmvcHandler {

    /**
     * 测试原生的Servlet API
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Request:" + request);       //转发
        System.out.println("Response:" + response);     //重定向 将数据写给客户端

        //转发
        //request.getRequestDispatcher("/WEB-INF/view/success.jsp").forward(request,response);

        //重定向
        //response.sendRedirect("http://www.baidu.com");

        //将数据写给客户端
        response.getWriter().println("response data");
    }


    /**
     * POJO
     *
     * @return
     */
    @RequestMapping("testPOJO")
    public String testPOJO(User user) {
        System.out.println("POJO:" + user);
        return "success";
    }

    /**
     * @RequestCookie
     */
    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookieValue) {
        System.out.println("CookieValue:" + cookieValue);
        return "testRequest";
    }


    /**
     * @RequestHeader 映射请求头信息到请求处理方法的形参中
     */
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String acceptlanguage) {
        System.out.println("acceptLanguage" + acceptlanguage);
        return "success";
    }


    /**
     * @RequestParam 映射请求参数到请求处理方法的形参
     * 1.如果请求参数名与形参名一致，则可以省略@RequestParam的指定。
     * 2.@RequestParam 注解标注的形参必须要赋值。必须要能从请求对象中获取到对应的请求参数。
     * 可以使用required来设置为不是必须的。
     * 3.可以使用defaultValue来指定一个默认值取代 null
     */
    @RequestMapping(value = "testRequestParam")
    public String testRequestParam(@RequestParam("username") String username, @RequestParam(value = "age", defaultValue = "0", required = false) Integer age) {
        //web: request.getParameter()   request.getParameterMap()
        System.out.println(username + "," + age);
        return "testRequest";
    }


    /**
     * REST PUT
     * <p>
     * 消息 JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS
     * 描述 请求行中接收的方法由源服务器知道，但目标资源不支持
     * 上面报错解决方法 ： @ResponseBody
     */
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    @ResponseBody
    public String testRestPut() {
        System.out.println("REST PUT");
        return "success";
    }

    /**
     * REST POST
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String testRestPost() {
        System.out.println("TEST POST");
        return "success";
    }

    /**
     * REST DELETE
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String testRestDelete(@PathVariable("id") Integer id) {
        System.out.println("REST DELETE:" + id);
        return "success";
    }

    /**
     * REST GET
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id) {
        System.out.println("REST GET:" + id);
        return "success";
    }


    /**
     * 带占位符的URL
     */
    @RequestMapping(value = "/testPathVariable/{name}/{id}")
    public String testPathVariable(@PathVariable("name") String name, @PathVariable("id") Integer id) {
        System.out.println("姓名:" + name + ";参数id:" + id);
        return "testREquest";
    }


    /**
     * @RequestMapping 映射请求参数，以及请求头信息
     * @params : username=tom&age=22
     * headers: 请求头不能包含"Accept-Language"
     * params：显示请求必须有"username"字段以及"age"必须等于22。如果不想包含某个字段。可以用 "!"前缀
     */
    @RequestMapping(value = "/testParmsAndHeaders", params = {"username", "age=22"}, headers = {"!Accept-Language"})
    public String testRMParamAndHead() {

        return "testRequest";
    }

    /**
     * method 可以有多个参数。下面示例既可以是post请求，也可以是get请求
     *
     * @return
     */
    @RequestMapping(value = "testRequestMapping", method = {RequestMethod.GET, RequestMethod.POST})
    public String testRequestMapping() {
        return "testRequest";
    }

}
