package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
}
