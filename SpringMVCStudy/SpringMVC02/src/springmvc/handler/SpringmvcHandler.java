package springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.portlet.ModelAndView;   //这个包会导致 setViewName不生效；采用默认的视图名：testModelAndView

@Controller
public class SpringmvcHandler {
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
