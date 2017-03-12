package com.rest.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.users.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
