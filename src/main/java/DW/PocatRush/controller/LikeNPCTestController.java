package DW.PocatRush.controller;

import DW.PocatRush.model.LikeNPCTest;
import DW.PocatRush.service.LikeNPCTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/like")
public class LikeNPCTestController {


    LikeNPCTestService likeNPCTestService;

    @Autowired
    public LikeNPCTestController(LikeNPCTestService likeNPCTestService) {
        this.likeNPCTestService = likeNPCTestService;
    }

    @PutMapping("/update")
    public ResponseEntity<LikeNPCTest> putLikeNPC(@RequestBody LikeNPCTest likeNPCTest){
        return new ResponseEntity<>(likeNPCTestService.putLikeNPC(likeNPCTest), HttpStatus.OK);
    }

}
