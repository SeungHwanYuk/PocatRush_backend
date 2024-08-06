package DW.PocatRush.repository;

import DW.PocatRush.PocatRushApplication;
import DW.PocatRush.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
