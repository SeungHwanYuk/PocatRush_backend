package DW.PocatRush.service;

import DW.PocatRush.exception.ResourceNotFoundException;
import DW.PocatRush.model.Post;
import DW.PocatRush.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }



    public List<Post> getPostByBoardId (long boardId){
        return postRepository.findAll()
                .stream().filter((post -> post.getBoard().getBoardId() == boardId))
                .collect(Collectors.toList())
                .reversed();
    }


}
