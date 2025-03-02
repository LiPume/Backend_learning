package com.itheima;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RequestController {

    /**
     * ����·�� http://localhost:8080/request?name=Tom&age=18
     * @param request
     * @return
     */
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        //1.��ȡ������� name, age
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name = " + name + ", age = " + age);

        //2.��ȡ����·��
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        System.out.println("uri = " + uri);
        System.out.println("url = " + url);

        //3.��ȡ����ʽ
        String method = request.getMethod();
        System.out.println("method = " + method);

        //4.��ȡ����ͷ
        String header = request.getHeader("User-Agent");
        System.out.println("header = " + header);
        return "request success";
    }

}