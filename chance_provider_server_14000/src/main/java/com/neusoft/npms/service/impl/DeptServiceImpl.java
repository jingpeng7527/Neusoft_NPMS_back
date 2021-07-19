package com.neusoft.npms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neusoft.npms.entity.Dept;
import com.neusoft.npms.entity.User;
import com.neusoft.npms.mapper.DeptMapper;
import com.neusoft.npms.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.npms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-07-13
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    IUserService iUserService;

    public List<Dept> getDepartment(String userId, String roleId){
        List<Dept> list = new ArrayList<>();
        if (roleId.equals("1") || roleId.equals("3") || roleId.equals("4")) {
            String deptId = getDeptIdByUserId(userId); // 找user对应的dept_id
            Dept dept = getOne(Wrappers.<Dept>lambdaQuery().eq(Dept::getId,deptId)); // 找dept_id对应的 dept
            list.add(dept);
            return list;
        } else if (roleId.equals("2") || roleId.equals("5")){
            return list();
        } else return null;
    }

    public String getDeptIdByUserId(String userId){
        return iUserService.getOne(Wrappers.<User>lambdaQuery().eq(User::getId,userId)).getDeptId().toString();
    }

}
