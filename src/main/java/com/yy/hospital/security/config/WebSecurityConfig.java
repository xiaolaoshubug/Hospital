package com.yy.hospital.security.config;


import com.yy.hospital.security.JwtAuthenticationTokenFilter;
import com.yy.hospital.security.JwtTokenUtil;
import com.yy.hospital.security.domain.JwtAuthenticationEntryPoint;
import com.yy.hospital.security.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Web 安全配置类
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //对全局的所有方法都要做安全检查类
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  //未授权响应处理类
  private JwtAuthenticationEntryPoint unauthorizedHandler;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private JwtUserDetailsService jwtUserDetailsService;

  @Value("${jwt.header}")
  private String tokenHeader;

  @Value("${jwt.route.authentication.path}")
  //获取授权令牌的路径（配置文件里面）
  private String authenticationPath;


  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(jwtUserDetailsService)
        .passwordEncoder(passwordEncoderBean());
  }

  @Bean
  public PasswordEncoder passwordEncoderBean() {
    return new BCryptPasswordEncoder();
  }


  @Bean
  @Override
  //授权管理器
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }


  //configure分两部分写
  //安全访问的策略
  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        // we don't need CSRF because our token is invulnerable
        .csrf().disable()
        .cors().and() // 支持跨域访问

        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

        // don't create session
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

        .authorizeRequests()

        .antMatchers("/api/auth/**").permitAll()
        .anyRequest().authenticated();

    // Custom JWT based security filter
    //创建过滤器，过滤jwt请求
    JwtAuthenticationTokenFilter authenticationTokenFilter=new JwtAuthenticationTokenFilter(userDetailsService(), jwtTokenUtil, tokenHeader);
    httpSecurity
        .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

    // disable page caching
    httpSecurity
        .headers()
        .frameOptions().sameOrigin()  // required to set for H2 else H2 Console will be blank.
        .cacheControl();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // AuthenticationTokenFilter will ignore the below paths
    web
        .ignoring()
        .antMatchers(
            HttpMethod.POST,
            authenticationPath    //从配置文件里面读取出来的
        )

        // allow anonymous resource requests
        .and()
        .ignoring()
        .antMatchers(
            HttpMethod.GET,
            "/",
            "/*.html",
            "/favicon.ico",
            "/**/*.html",
            "/**/*.css",
            "/**/*.js"
        );
  }
}
