package com.macro.cloud.service;

import cn.hutool.core.collection.CollUtil;
import com.macro.cloud.domain.SecurityUser;
import com.macro.cloud.domain.User;
import com.macro.cloud.domain.UserDTO;
import com.macro.cloud.constant.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    private List<UserDTO> userList = new ArrayList<>();
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserService iUserService;

    @PostConstruct
    public void initData() {

//        List<UserDTO> userList = new ArrayList<>();
        for (User user:iUserService.list()) {
            long id = user.getId();
            String name = user.getUsername();
            String password = user.getPassword();
//            System.out.println("pppppp " + password);
//            String password = passwordEncoder.encode(user.getPassword());
            String roleId = String.valueOf(user.getRoleId());
            userList.add(new UserDTO(id,name,password,1,CollUtil.toList(roleId)));

        }
//        userList.add(new UserDTO(10L,"macro", passwordEncoder.encode("123456"),1, CollUtil.toList("1")));

//        for (UserDTO u:userList) {
//            System.out.println(u);
//        }
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String password = bCryptPasswordEncoder.encode("123456");


//        userList.add(new UserDTO(1L,"macro", password,1, CollUtil.toList("ADMIN")));
//        userList.add(new UserDTO(2L,"andy", password,1, CollUtil.toList("TEST")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDTO> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        if (CollUtil.isEmpty(findUserList)) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        SecurityUser securityUser = new SecurityUser(findUserList.get(0));
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }

}
