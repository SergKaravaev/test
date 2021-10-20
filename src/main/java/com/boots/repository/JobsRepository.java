package com.boots.repository;

import com.boots.entity.Jobs;
import org.springframework.data.repository.CrudRepository;

public interface JobsRepository extends CrudRepository<Jobs, Long> {
}
