package com.example.login_server_18000.config;

import com.example.login_server_18000.service.IUserService;
import com.example.login_server_18000.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/admin/admin.html").hasRole("ADMIN")
//                .antMatchers("/admin/admin.html").hasAnyAuthority("ADMIN")


//                .antMatchers(HttpMethod.POST,"/users/user/admin/**").hasAnyAuthority("ADMIN")

//                granularity
//        hasRole
//        hasAnyAuthority
//        .antMatchers(HttpMethod.POST,"/users/user/admin/**").hasRole("ADMIN")

                .antMatchers(
                        HttpMethod.POST,
                        "/**/*.html",
                        "/**/*.css",
                        "/",
//                        测试用
                        "/*.jpg",
                        "/image/*.jpg",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.js"
//                        ,"/**/*.jpg"
                ).permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//                .accessDeniedHandler(new CustomAccessDeniedHandler())
                .and().logout().logoutUrl("/logout")
                .and()
                .csrf().disable();
        ;

        System.out.println("here1");
        http.addFilterAt(customJSONLoginFilter(), UsernamePasswordAuthenticationFilter.class);


    }

    //    @Autowired
//    IRoleService iRoleService;
    @Autowired
    UserServiceImpl iUserService;

    public CustomJsonLoginFilter customJSONLoginFilter() {
        System.out.println("here2");
        CustomJsonLoginFilter customJsonLoginFilter = new CustomJsonLoginFilter("/login", iUserService);
        customJsonLoginFilter.setAuthenticationSuccessHandler(new MyAuthenticationSuccessHandler(iUserService));
        customJsonLoginFilter.setAuthenticationFailureHandler(new MyAuthenticationFailureHandler());
        return customJsonLoginFilter;
    }


    @Bean
    public static PasswordEncoder passwordEncoder() {

        String encoderType = EncryptionAlgorithm.ENCODER_TYPE.get(1);
        return EncryptionAlgorithm.ENCODER_MAP.get(encoderType);

//        return new BCryptPasswordEncoder();

    }


}








