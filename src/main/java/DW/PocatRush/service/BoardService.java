package DW.PocatRush.service;

import DW.PocatRush.repository.BoardRepository;
import DW.PocatRush.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BoardService {
    BoardRepository boardRepository;
    PostRepository postRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository, PostRepository postRepository) {
        this.boardRepository = boardRepository;
        this.postRepository = postRepository;
    }


}
