package DW.PocatRush.controller;

import DW.PocatRush.model.Post;
import DW.PocatRush.dto.PostDto;
import DW.PocatRush.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {

    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/freeboard")
    public ResponseEntity<List<Post>> getPostByFreeboard() {
        long boardId = 1; // 자유게시판 직접 불러오기
        return new ResponseEntity<>(postService.getPostByBoardId(boardId), HttpStatus.OK);
    }
    @GetMapping("/whatsnew")
    public ResponseEntity<List<Post>> getPostByWhatsnew() {
        long boardId = 2; // 공지사항 직접 불러오기
        return new ResponseEntity<>(postService.getPostByBoardId(boardId), HttpStatus.OK);
    }

    // 글쓰기 (게시판 번호 포함되어야함) 0814 승환
    @PostMapping("/write")
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto){
        PostDto savePost = postService.savePost(postDto);
        return new ResponseEntity<>(savePost,
                HttpStatus.OK);
    }

    //게시글 보여주기
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostByPostId(@PathVariable long postId) {
        return new ResponseEntity<>(postService.getPostByPostId(postId),HttpStatus.OK);
    }

    @GetMapping("/search/{text}")
    public  ResponseEntity<List<Post>> searchPostByText(@PathVariable String text){
        return new ResponseEntity<>(postService.searchPostByText(text),HttpStatus.OK);
    }

}
