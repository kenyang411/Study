package springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
//import org.springframework.web.portlet.ModelAndView;   //这个包会导致 setViewName不生效；采用默认的视图名：testModelAndView

@Controller
public class SpringmvcHandler {

    /**
     * Model
     */
    @RequestMapping("/testModel")
    public String testModel(Model model){

        model.addAttribute("loginMsg","用户名或者密码错误");
        return "success";
    }

    /**
     * Map
     * 猜测：SpringMVC会把Map中的模型数据放到request域对象中。
     *      SpringMVC在调用完请求处理方法后，不管方法的返回值是什么类型。都会处理成一个ModelAndView对象。
     */
    @RequestMapping("testMap")
    public String testMap(Map<String,Object> map){
        System.out.println(map.getClass().getName());   //输出map是什么类型数据 :BindingAwareModelMap
        map.put("passworld","2333");
        return "success";
    }


    /**
     * ModelAndView
     * 猜测：Springnvc会把ModelAndView中的模型数据存放到request域对象中。
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //模型数据: username=Admin
        ModelAndView mav=new ModelAndView();

        //添加模型数据
        mav.addObject("username","Admin");

        //设置试图信息
        mav.setViewName("success");
        return mav;
    }
}
