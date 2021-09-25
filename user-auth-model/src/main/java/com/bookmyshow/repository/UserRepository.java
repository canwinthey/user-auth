/**
 * 
 */
package com.bookmyshow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookmyshow.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
