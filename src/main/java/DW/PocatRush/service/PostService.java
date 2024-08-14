package DW.PocatRush.service;

import DW.PocatRush.exception.ResourceNotFoundException;
import DW.PocatRush.model.Board;
import DW.PocatRush.model.Post;
import DW.PocatRush.dto.PostDto;
import DW.PocatRush.model.User;
import DW.PocatRush.repository.BoardRepository;
import DW.PocatRush.repository.PostRepository;
import DW.PocatRush.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {

    private PostRepository postRepository;

    private BoardRepository boardRepository;

    private UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, BoardRepository boardRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getPostByBoardId (long boardId){
        return postRepository.findAll()
                .stream().filter((post -> post.getBoard().getBoardId() == boardId))
                .collect(Collectors.toList())
                .reversed();
    }

    public PostDto savePost(PostDto postDto){
        Board board = boardRepository.findById(postDto.getBoardNumber())
                .orElseThrow(()->new IllegalArgumentException("유효하지 않은 게시판아이디입니다."));
        User user= userRepository.findById(postDto.getUserId())
                .orElseThrow(()-> new IllegalArgumentException("아이디를 확인해주세요."));
        Post post = new Post();
        post.setBoard(board);
        post.setUser(user);
        post.setPostTitle(postDto.getPostTitle());
        post.setPostText(postDto.getPostText());
        post.setPostDate(LocalDate.now());
        post.setPostImage(postDto.getPostImage());

        Post savePost = postRepository.save(post);
        return postDto.toPostDtoFromPost(savePost);
    }

    //게시글 보여주기
    public Post getPostByPostId(long postId){
        Optional<Post> postOptional = postRepository.findById(postId);
        if(postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new ResourceNotFoundException("postId가","없떠요",postId);
        }
    }

    //검색기능
    public List<Post> searchPostByText(String postName) {
        return postRepository.findAll()
                .stream()
                .filter(postData -> postData.getPostText().contains(postName))
                .collect(Collectors.toList());
    }
}
