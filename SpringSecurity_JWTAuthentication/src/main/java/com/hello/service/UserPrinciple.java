package com.hello.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hello.entity.Users;

import jakarta.transaction.Transactional;

public class UserPrinciple implements UserDetails {

	private Users users;
	
	public UserPrinciple(Users users) {
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		System.out.println(users.getRoles());
		
//		return null;
		 return users.getRoles()
			        .stream()
			        .map(role -> new SimpleGrantedAuthority(role.getRole()))  // Ensure "ROLE_" prefix
			        .collect(Collectors.toSet()); // ✅ New immutable list avoids concurrent modification
		
	}

	@Override
	public String getPassword() {

		return users.getPassword();
	}

	@Override
	public String getUsername() {
		return users.getUsername();
	}

	
}
