package com.boots.repository;

import org.springframework.data.repository.CrudRepository;
import com.boots.entity.Service;

public interface ServiceRepository extends CrudRepository<Service, Long> {
}
