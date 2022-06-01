package br.edu.ufersa.pw20212.todoList.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.pw20212.todoList.api.dto.UserDto;
import br.edu.ufersa.pw20212.todoList.domain.entities.User;
import br.edu.ufersa.pw20212.todoList.domain.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	@Autowired
	private ModelMapper mapper;	
	public UserDto adicionar(User user) {
		return mapper.map(repository.save(user), UserDto.class);
	}
	public List<UserDto> listarTodos(){
		List<UserDto> list = new ArrayList<UserDto>();
		for (User user: repository.findAll()) {
			list.add(mapper.map(user, UserDto.class));
		}
		return list;
	}
}
