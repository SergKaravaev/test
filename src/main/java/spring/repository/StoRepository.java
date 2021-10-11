package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.models.Sto;

public interface StoRepository extends CrudRepository<Sto, Long> {
}
