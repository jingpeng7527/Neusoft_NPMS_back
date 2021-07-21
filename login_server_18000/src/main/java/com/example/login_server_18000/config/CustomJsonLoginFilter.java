package com.example.login_server_18000.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.login_server_18000.entity.User;
import com.example.login_server_18000.service.IUserService;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomJsonLoginFilter extends AbstractAuthenticationProcessingFilter {
    private IUserService iUserService;

    protected CustomJsonLoginFilter(String defaultFilterProcessesUrl, IUserService iUserService) {
        super(defaultFilterProcessesUrl);
        this.iUserService=iUserService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

//        String username=  httpServletRequest.getParameter("username");
//        String password=  httpServletRequest.getParameter("password");

        InputStream inputStream= httpServletRequest.getInputStream();
        StringBuilder sb=new StringBuilder();
        byte[] byteArray=new byte[1024];
        int len=0;
        while((len=inputStream.read(byteArray))!=-1){
            sb.append(new String(byteArray,0,len));
        }
       JSONObject jsonObject= JSON.parseObject(sb.toString());
        String username= jsonObject.getString("username");
        String password= jsonObject.getString("password");

        System.out.println("**********************username:"+username+",password:"+password);

        validateUserPassword(username,password);

        String role = iUserService.getRole(username).toString();

        List<SimpleGrantedAuthority> simpleGrantedAuthoritylist=new ArrayList<>();
        simpleGrantedAuthoritylist.add(new SimpleGrantedAuthority(role));

        return new UsernamePasswordAuthenticationToken(username,password,simpleGrantedAuthoritylist);
    }



    public void validateUserPassword(String username,String password){
        // get data from database
//        Emp e=   iEmpService.getOne(Wrappers.<Emp>lambdaQuery().eq(Emp::getEname,"KING"));
        User u=iUserService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername,username));

        if(u==null){

            throw new UsernameNotFoundException("username wrong");
        }
//        EncryptionAlgorithm.ENCODER_MAP.get("bcrypt").encode();
        if(!EncryptionAlgorithm.ENCODER_MAP.get("bcrypt").matches(password, u.getPassword())){

            throw new AuthenticationServiceException("password wrong");
        }

    }




}
