package DW.PocatRush.repository;

import DW.PocatRush.model.Character;
import DW.PocatRush.model.UserItemHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserItemHistoryRepository extends JpaRepository<UserItemHistory, String> {

    Optional<List<UserItemHistory>> findByCharNickName(Character character);
}
