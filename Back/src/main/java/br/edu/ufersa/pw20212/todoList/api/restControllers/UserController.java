package br.edu.ufersa.pw20212.todoList.api.restControllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.edu.ufersa.pw20212.todoList.api.dto.UserDto;
import br.edu.ufersa.pw20212.todoList.domain.entities.User;
import br.edu.ufersa.pw20212.todoList.domain.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService service;
	
	@GetMapping
	public List<UserDto> listar(){
		return service.listarTodos();		
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto adicionar(@Valid @RequestBody User user) {
		return service.adicionar(user);
	}
/*	@PutMapping("/{userId}")
	public ResponseEntity<User> atualizar(@PathVariable Long userId, 
			@RequestBody User user){
		if(!repository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		user = repository.save(user);
		return ResponseEntity.ok(user);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> buscar(@PathVariable Long userId){
		return repository.findById(userId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	*/
}
