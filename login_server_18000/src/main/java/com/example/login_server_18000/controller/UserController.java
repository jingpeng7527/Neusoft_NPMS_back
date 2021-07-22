package com.example.login_server_18000.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.login_server_18000.entity.User;
import com.example.login_server_18000.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin
//@RequestMapping("")
public class UserController {

    @Autowired
    UserServiceImpl userService;

//    @PostMapping("/login")
//    public RespBean checkLogin(@RequestBody User usersinfo) {
//        System.out.println("*******************usersinfo:" + usersinfo);
//        String username = usersinfo.getUsername();
//        String password = usersinfo.getPassword();
//
//        QueryWrapper<User> qw = Wrappers.query();
//        qw.apply("username= {0}", username).apply("password={0}", password);
//        List<User> userList = userService.list(qw);
//        RespBean respBean = null;
//        if (userList.size() < 1) {
//            //error can't login in
//            respBean = RespBean.error(2001, "error username or password error");
//        } else if (userList.size() == 1) {
//            //ok  pass
//            respBean = RespBean.ok(1001, "username password true you can login in", userList.get(0));
//        } else {
//            // error can't login in   hint
//            respBean = RespBean.error(2002, " error: find user more than one ");
//        }
//        return respBean;
//    }


}
