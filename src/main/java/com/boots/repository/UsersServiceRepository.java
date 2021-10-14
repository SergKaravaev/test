package com.boots.repository;

import org.springframework.data.repository.CrudRepository;
import com.boots.entity.UsersService;

public interface UsersServiceRepository extends CrudRepository<UsersService, Long> {
}
