package springmvc.HelloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 请求处理器 /控制器
 */
@Controller
public class SpringMVCHandler {
    /**
     * 处理客户端的请求： http://localhost:8888/Springmvc01/hello
     *
     * @RequestMapping:完成请求与请求处理方法的映射
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String handleHello(){
        System.out.println("Hello SpringMVC");
        return "success";   //通过视图解析器解析得到具体的视图，再转发去往该视图。
    }
}
