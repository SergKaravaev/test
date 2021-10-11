package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.models.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
}
