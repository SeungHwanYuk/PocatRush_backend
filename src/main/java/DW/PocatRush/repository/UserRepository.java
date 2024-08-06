package DW.PocatRush.repository;

import DW.PocatRush.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUserId(String userId);
}
