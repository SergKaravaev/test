package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.models.Avto;

public interface AvtoRepository extends CrudRepository<Avto, Long> {
}
