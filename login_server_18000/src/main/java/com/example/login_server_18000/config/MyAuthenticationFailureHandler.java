package com.example.login_server_18000.config;

import com.example.client_management_provider_16000.dto.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();
        RespBean error =null;

        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            error =RespBean.error(500, "用户名或密码错误", null);
        } else if (e instanceof LockedException) {
            error =RespBean.error(500, "账户被锁定，请联系管理员!", null);
        } else if (e instanceof CredentialsExpiredException) {
            error =RespBean.error(500, "证书过期，请联系管理员!", null);
        } else if (e instanceof AccountExpiredException) {
            error =RespBean.error(500, "账户过期，请联系管理员!", null);
        } else if (e instanceof DisabledException) {
            error =RespBean.error(500, "账户被禁用，请联系管理员!", null);
        } else {
//            log.error("登录失败：", e);
            error = RespBean.error(500, "登录失败！！", null);
        }


        //转化为json 可以使用 jackson的ObjectMapper().writeValueAsString 方法转换
        pw.print(new ObjectMapper().writeValueAsString(error));
        pw.flush();
        pw.close();



    }

}
