package com.gens.task2.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;

import com.gens.task2.service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	private static final String[] ADMIN_VEHICLE_MATCHER =
		{
			"/vehicle/add/**",
			"/vehicle/edit/**"	
		};
	
	private static final String[] ADMIN_RENT_MATCHER = {
		"/rent/delete/**",
		"/rent/approve/**",
		"/rent/refuse/**",
		"/rent/show/**"
	};

	@Override
	protected void configure(final HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/login/**").permitAll()
		.antMatchers(ADMIN_VEHICLE_MATCHER).access("hasRole('ADMIN')")
		.antMatchers(ADMIN_RENT_MATCHER).access("hasRole('ADMIN')")
		.antMatchers("/vehicle/**").hasRole("USER")
		.antMatchers("/rent/**").hasRole("USER")
		.antMatchers("/user/info/**").hasRole("USER")
		.and()
			.formLogin()
			.loginPage("/login/form")
			.loginProcessingUrl("/login")
			.failureUrl("/login/form?error")
			.usernameParameter("userId")
			.passwordParameter("password")
			 .successHandler(new AuthenticationSuccessHandler() {
	                @Override
	                public void onAuthenticationSuccess(HttpServletRequest request,
	                                                    HttpServletResponse response,
	                                                    Authentication authentication)
	                        throws IOException, ServletException {
	                    response.sendRedirect("/CarRental/index");
	                }
	            })
		.and()
			.exceptionHandling()
			.accessDeniedPage("/login/form?forbidden")
		.and()
			.logout()
			.logoutUrl("/login/form/logout");
		//.and().csrf().disable();
	}
	
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
