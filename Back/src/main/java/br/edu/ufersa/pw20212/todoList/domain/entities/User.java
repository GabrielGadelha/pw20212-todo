package br.edu.ufersa.pw20212.todoList.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table (name="tb_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	UUID uuid;
	@Column(unique=true)
	@NotBlank (message = "Email não pode ser nulo")
	@Email(message="O email deve ser válido")
	String email;
	@NotBlank (message = "Uma senha precisa ser definida")
	@Size(min=6,max=100, message="A senha deve ter entre 6 e 100 caracteres")
	String senha;
	@OneToMany(mappedBy="user")
	private List<Todo> todoList = new ArrayList<Todo>();
	@OneToMany(mappedBy="user")
	private List<Concluded> concluded = new ArrayList<Concluded>();	
	public User() {
		uuid = UUID.randomUUID();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
