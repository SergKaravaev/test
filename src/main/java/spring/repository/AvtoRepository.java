package spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.models.Avto;
import spring.models.Users;

import java.util.List;

public interface AvtoRepository extends CrudRepository<Avto, Long> {
}
