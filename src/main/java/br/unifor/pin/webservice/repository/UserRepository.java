package br.unifor.pin.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unifor.pin.webservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmailAndPassword(String email, String password);

}
