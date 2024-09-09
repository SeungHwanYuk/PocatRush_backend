package DW.PocatRush.repository;

import DW.PocatRush.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, String> {
}
