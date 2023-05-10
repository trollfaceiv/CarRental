package com.gens.task2.service;

import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.*;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	
	@Autowired
	private UserService userService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		org.springframework.security.core.userdetails.User userDet = null;
		com.gens.task2.entities.User user = userService.selectByUserName(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		if(user.isAdminRole()) {
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		if(!(user.isAdminRole())) {
	        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}


		try {
		 userDet = new org.springframework.security.core.userdetails.User(
	                username,
	      user.getPassword(), grantedAuthorities);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(userDet.getAuthorities().toString());
		return userDet;

		 }
}
