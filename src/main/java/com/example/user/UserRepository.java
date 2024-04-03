package com.example.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Controller.User, String> {
	Controller.User findByUsername(String username);

	boolean existsByUsername(String username);
}
