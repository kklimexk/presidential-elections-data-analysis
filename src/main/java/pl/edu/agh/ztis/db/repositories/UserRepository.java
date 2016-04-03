package pl.edu.agh.ztis.db.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.edu.agh.ztis.db.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserId(Long userId);
}
