package com.hrp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
 	/*@Autowired
    UserDetailsService myUserDetailsService;
 	
 	@Autowired
	private JwtRequestFilter jwtRequestFilter;
 
 	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
               /* .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/login", "/h2-console/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/house-rent/fetchPosts").hasAnyRole("ADMIN", "USER")
                .antMatchers("/house-rent/addPost").hasAnyRole("ADMIN", "USER")
                .antMatchers("/house-rent/authenticate").permitAll()*/
                .antMatchers("/house-rent/**").permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				  .and().formLogin();
		
       //.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
              
        http.csrf().disable();
        http.headers().frameOptions().disable();
        
    }

	   
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
        		.withUser("admin").password("admin")
                .roles("USER", "ADMIN");    
    }
	
}
