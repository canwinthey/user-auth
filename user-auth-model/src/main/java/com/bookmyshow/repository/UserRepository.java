/**
 * 
 */
package com.bookmyshow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmyshow.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByUsername(String username);
	User findByUser(String username);

}
