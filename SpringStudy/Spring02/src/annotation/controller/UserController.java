package annotation.controller;

import org.springframework.stereotype.Controller;

/**
 * @Controller 注解的作用：
 *      相当于在xml文件中：
 *      <bean id="userController" class="annotation.UserController" ></bean>
 *
 *      注解默认的ID值就是类名首字母小写，可以在注解中手动指定id值：@Controller(value="id值")，可以简写为:@Controller("id值")
 */

@Controller
public class UserController {
}
