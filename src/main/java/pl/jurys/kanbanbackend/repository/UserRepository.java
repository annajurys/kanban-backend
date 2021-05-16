package pl.jurys.kanbanbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jurys.kanbanbackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserId(Long userId);
    User findUserByEmail(String email);
}
