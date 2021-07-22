package com.macro.cloud.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;
import com.macro.cloud.domain.UserDTO;
import com.macro.cloud.entity.User;
import com.macro.cloud.holder.LoginUserHolder;
import com.macro.cloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取登录用户信息接口
 * Created by macro on 2020/6/19.
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    IUserService iUserService;

    @Autowired
    private LoginUserHolder loginUserHolder;

    @GetMapping("/currentUser")
    public UserDTO currentUser() {
        return loginUserHolder.getCurrentUser();
    }

    @GetMapping("/login")
    public User getUserInfo() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String userStr = request.getHeader("user");
        JSONObject userJsonObject = new JSONObject(userStr);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(userJsonObject.getStr("user_name"));
        userDTO.setId(Convert.toLong(userJsonObject.get("id")));
        userDTO.setRoles(Convert.toList(String.class,userJsonObject.get("authorities")));

        User user = iUserService.getById(Integer.parseInt(String.valueOf(userDTO.getId())));
        return user;
    }

    @PostMapping("/testPost")
    public UserDTO testPost(@RequestBody UserDTO userDTO)  {
        System.out.println(userDTO);
        return userDTO;
    }

}
