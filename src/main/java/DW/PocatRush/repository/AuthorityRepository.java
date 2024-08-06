package DW.PocatRush.repository;

import DW.PocatRush.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository
    <Authority, String>
{
}
