package ss.servlet;

import org.springframework.context.ApplicationContext;
import ss.beans.Person;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        /**
         * 访问到SpringIOC容器的person对象。
         * 从ServletContext对象中获取SpringIOC容器对象
         */
        ServletContext sc=getServletContext();
        ApplicationContext ctx= (ApplicationContext) sc.getAttribute("applicationContext");
        Person person=ctx.getBean("person",Person.class);
        person.sayHello();
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException{
        doGet(request,response);
    }
}
