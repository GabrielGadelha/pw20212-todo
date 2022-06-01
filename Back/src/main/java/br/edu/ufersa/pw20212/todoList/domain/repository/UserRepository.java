package br.edu.ufersa.pw20212.todoList.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufersa.pw20212.todoList.domain.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

	public User findUserByEmail(String email);

}
