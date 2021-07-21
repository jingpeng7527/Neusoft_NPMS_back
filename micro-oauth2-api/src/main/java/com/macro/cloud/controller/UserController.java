package com.macro.cloud.controller;

import com.macro.cloud.domain.UserDTO;
import com.macro.cloud.holder.LoginUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 获取登录用户信息接口
 * Created by macro on 2020/6/19.
 */
@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private LoginUserHolder loginUserHolder;

    @GetMapping("/currentUser")
    public UserDTO currentUser() {
        return loginUserHolder.getCurrentUser();
    }

    @PostMapping("/testPost")
    public UserDTO testPost(@RequestBody UserDTO userDTO)  {
        System.out.println(userDTO);
        return userDTO;
    }

}
