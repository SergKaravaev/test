package com.boots.repository;

import org.springframework.data.repository.CrudRepository;
import com.boots.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
}
