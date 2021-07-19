package com.neusoft.npms.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.dto.RespBean;
import com.neusoft.npms.entity.User;
import com.neusoft.npms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-07-16
 */
@RestController
@RequestMapping("/npms/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping("/get_user_by_dept_id")
    public RespBean getUserByDeptId(String dept_id, String user_id, String role_id){
        System.out.println("/get_user_by_dept_id: dept_id:"+dept_id+
                " user_id:"+user_id+" role_id:"+role_id);
        if (dept_id == null || dept_id.equals("") || user_id == null || user_id.equals("")
                || role_id == null || role_id.equals(""))
            return RespBean.error(400,"参数为空");

        if (role_id.equals("1")) {// 判断权限--客户经理 返回自己
            List<User> user = iUserService.list(Wrappers.<User>lambdaQuery().eq(User::getId,user_id));
            return RespBean.ok(200,"获得本人",user);
        }

        List list = iUserService.list(Wrappers.<User>lambdaQuery().eq(User::getDeptId,dept_id));
        if (list == null || list.size() == 0)
            return RespBean.ok(200,"该部门下无员工");
        else if (list.size() != 0) return RespBean.ok(200,"该部门下员工",list);
        else return RespBean.error(400,"出现未知问题");
    }


}

