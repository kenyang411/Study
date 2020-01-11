package springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContext;

import javax.sound.midi.Soundbank;

@Controller
@RequestMapping("test")
public class SpringmvcHandler {

    /**
     * REST PUT
     *
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
