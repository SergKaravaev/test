package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.models.Service;

public interface ServiceRepository extends CrudRepository<Service, Long> {
}
