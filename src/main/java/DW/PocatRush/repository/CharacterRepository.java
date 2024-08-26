package DW.PocatRush.repository;

import DW.PocatRush.model.Character;
import DW.PocatRush.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, String> {
    Character findByUser(User user);

}
