package DW.PocatRush.controller;

import DW.PocatRush.model.Post;
import DW.PocatRush.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
