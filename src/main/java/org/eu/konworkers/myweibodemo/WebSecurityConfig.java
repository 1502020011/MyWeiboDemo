package org.eu.konworkers.myweibodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userdetailsserviceimpl;

    protected void configure(HttpSecurity http) throws Exception {
            http
                .headers()
                    .frameOptions()
                    .sameOrigin()
                    .and()
                .authorizeRequests()
                    .antMatchers("/message/getmessage").permitAll()
                    .antMatchers("/user/register").permitAll()
                    .antMatchers("/auth").permitAll()
                    .antMatchers("/getloggedin").permitAll()
                    .antMatchers("/index.html").permitAll()
                    .antMatchers("/messagereviewer.html").hasAnyRole("REVIEWER","ADMIN")
                    .antMatchers("/message/deletemessage").hasAnyRole("REVIEWER","ADMIN")
                    .antMatchers("/setrole.html").hasRole("ADMIN")
                    .antMatchers("/user/getuser").hasRole("ADMIN")
                    .antMatchers("/user/deleteuser").hasRole("ADMIN")
                    .anyRequest()
                    .authenticated()
                    .and()
                .formLogin()
                    .loginPage("/index.html")
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                    .loginProcessingUrl("/login/login")
//                    .defaultSuccessUrl("/datetest.html")//登录成功后默认的跳转页面路径
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                    .and()
                .sessionManagement()
                    .invalidSessionUrl("/index.html")
                    .and()
                .csrf()
                    .disable();
    }

    public void configure(WebSecurity web) throws Exception {
        //配置静态文件不需要认证
        web.ignoring().antMatchers("/index.html");
    }


    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userdetailsserviceimpl);
//        auth.inMemoryAuthentication()
//                .withUser("user")//用户名
//                .password(passwordEncoder().encode("123456"))//密码
//                .roles("USER");//角色
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }
}
