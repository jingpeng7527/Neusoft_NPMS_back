package com.example.login_server_18000.config;


import com.example.login_server_18000.dto.RespBean;
import com.example.login_server_18000.entity.User;
import com.example.login_server_18000.service.IUserService;
import com.example.login_server_18000.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    IUserService iUserService;

    public MyAuthenticationSuccessHandler(IUserService iUserService) {
        super();
        this.iUserService = iUserService;
    }

//	当访问成功后 向前台返回的json字符串 封装到 response中
//	这里 就像我们学的servlet一样  有request，response
//	除此之外还有 我们进行认证时候的信息authentication
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // TODO Auto-generated method stub

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();

        authentication.getCredentials();
        authentication.getDetails();
//        System.out.println("authentication.getPrincipal().toString():"+authentication.getPrincipal().toString());

//        User u=new User();
//        u.setUsername(authentication.getPrincipal().toString());

//        System.out.println(authentication.getPrincipal().toString());
//        System.out.println();
//        System.out.println("iUserService"+iUserService);
//        List<User> list = iUserService.list();
//        System.out.println(iUserService.getRole("yky"));

//        System.out.println("p"+authentication.getPrincipal());
//        System.out.println("d"+authentication.getDetails()+"   "+authentication.getAuthorities());
        User role = iUserService.getRole(authentication.getPrincipal().toString());
        System.out.println("role role"+role);
        RespBean ok =RespBean.ok(1001, "login successful", role);


        //转化为json 可以使用 jackson的ObjectMapper().writeValueAsString 方法转换


        pw.print(new ObjectMapper().writeValueAsString(ok));
        pw.flush();
        pw.close();

    }
}
