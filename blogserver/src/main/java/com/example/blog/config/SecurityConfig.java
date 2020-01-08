package com.example.blog.config;

import com.example.blog.bean.User;
import com.example.blog.common.RespBean;
import com.example.blog.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig {//extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private UserService userService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
//            }
//        });
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/css/**", "/js/**","/images/**", "/webjars/**", "**/favicon.ico", "/index.html").permitAll()
//                .anyRequest()
//                .authenticated()//其他的路径都是登录后即可访问
//                .and()
//                .formLogin()
//                .loginPage("/index.html#/login")
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
//                                                        HttpServletResponse httpServletResponse,
//                                                        Authentication authentication) throws IOException, ServletException {
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        RespBean respBean = RespBean.ok("登录成功!", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//                        ObjectMapper om = new ObjectMapper();
//                        PrintWriter out = httpServletResponse.getWriter();
//                        out.write(om.writeValueAsString(respBean));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
//                                                        HttpServletResponse httpServletResponse,
//                                                        AuthenticationException e) throws IOException, ServletException {
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = httpServletResponse.getWriter();
//                        out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .loginProcessingUrl("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .csrf()
//                .disable()
//                .exceptionHandling()
//                .accessDeniedHandler(new AccessDeniedHandler() {
//                    @Override
//                    public void handle(HttpServletRequest httpServletRequest,
//                                       HttpServletResponse httpServletResponse,
//                                       AccessDeniedException e) throws IOException, ServletException {
//                        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
//                    }
//                });
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/index.html", "/static/**");
//    }
}
