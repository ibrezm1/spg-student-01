package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//https://medium.com/@aamir.zaidi5/spring-security-implementation-805520a297d5

@Configuration
public class SecurityConfig {


    // create a security filter chain that only authenticates the /students endpoint
      @Bean
      public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
          httpSecurity.csrf().disable()
                  .authorizeHttpRequests()
                  //update below to only authenticate students endpoint
                  .requestMatchers("/students")
                  .authenticated()
                  .and()
                  .httpBasic();
          return httpSecurity.build();
      }

      // allow unauthenticated access to /  homepage without basic authentication
      @Bean
        public SecurityFilterChain filterChainHomePage(HttpSecurity httpSecurity) throws Exception{
            httpSecurity.csrf().disable()
                    .authorizeHttpRequests()
                    .requestMatchers("/").permitAll();
            return httpSecurity.build();
        }



      @Bean
      public InMemoryUserDetailsManager userDetailsService() {
          UserDetails user = User.withDefaultPasswordEncoder()
                  .username("admin")
                  .password("123")
                  .roles("ADMIN")
                  .build();
          return new InMemoryUserDetailsManager(user);
          // create a curl command below to test it
            // curl -u admin:123 http://localhost:8001/students
            // http command 
            // http -a admin:123 http://localhost:8001/students
 


      }
}