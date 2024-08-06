package DW.PocatRush.controller;

import DW.PocatRush.service.BoardService;
import DW.PocatRush.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    BoardService boardService;

    PostService postService;

    @Autowired
    public BoardController(BoardService boardService, PostService postService) {
        this.boardService = boardService;
        this.postService = postService;
    }
}
