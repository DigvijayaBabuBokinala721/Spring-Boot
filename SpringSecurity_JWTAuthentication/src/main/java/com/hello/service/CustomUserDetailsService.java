package com.hello.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hello.entity.Users;
import com.hello.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	
	@Override
//	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> users = userRepo.findByUsername(username);
		
		if(users.isPresent()) {
			
//			System.out.println("Loaded User: " + users.get().getUsername());
//	        System.out.println("Password: " + users.get().getPassword());
//	        System.out.println("Roles: " + users.get().getRoles());
			
//	        return null;
	        System.out.println(new UserPrinciple(users.get()).getAuthorities());
			return new UserPrinciple(users.get());
		}
		else {
			System.out.println("no users");
			throw new NullPointerException("no users exists");
		}
	}

	public Users register(Users user) {
		PasswordEncoder encoder = applicationContext.getBean(PasswordEncoder.class);
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
}
