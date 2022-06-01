package br.edu.ufersa.pw20212.todoList.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ufersa.pw20212.todoList.domain.entities.User;
import br.edu.ufersa.pw20212.todoList.domain.repository.UserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		User currentUser = repository.findUserByEmail(email);
		UserDetails user = new org.springframework.security.core
		          .userdetails.User(email, currentUser.getSenha(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
		return user;
	}
	

}
