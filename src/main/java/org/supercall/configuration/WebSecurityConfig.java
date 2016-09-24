package org.supercall.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.RememberMeConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.supercall.security.CustomAuthenticationProvider;
import org.supercall.security.MenuInitHandler;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomAuthenticationProvider provider;//自定义验证
    @Autowired
    private UserDetailsService userDetailsService;//自定义用户服务

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    }


    @Autowired
    MenuInitHandler menuInitHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        RememberMeConfigurer<HttpSecurity> rs = http.authorizeRequests()
                .antMatchers("/", "/css/**", "/img/**", "/js/**", "/lib/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .successHandler(menuInitHandler)
                .loginPage("/admin/")
                .failureUrl("/admin/")
                .usernameParameter("username")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                .deleteCookies("remember-me")
                .logoutSuccessUrl("/admin/")
                .permitAll()
                .and()
                .rememberMe();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //将验证过程交给自定义验证工具
        auth.authenticationProvider(provider);
    }
}
