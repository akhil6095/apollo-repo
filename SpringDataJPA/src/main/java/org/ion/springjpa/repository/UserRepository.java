package org.ion.springjpa.repository;

import org.ion.springjpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByFirstName(String firstName);

	@Query("select firstName from User")
	List<String> getListOfFirstNames();

	User findTopByOrderByAgeDesc();

	@Query("SELECT u FROM User u ")
	Stream<User> getUserAsStream();
}
