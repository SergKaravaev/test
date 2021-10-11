package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.models.Jobs;

public interface JobsRepository extends CrudRepository<Jobs, Long> {
}
