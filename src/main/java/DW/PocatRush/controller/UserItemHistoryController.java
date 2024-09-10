package DW.PocatRush.controller;


import DW.PocatRush.dto.UserItemHistoryDto;
import DW.PocatRush.model.UserItemHistory;
import DW.PocatRush.service.UserItemHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/itemhistory")
public class UserItemHistoryController {

    UserItemHistoryService userItemHistoryService;

    @Autowired
    public UserItemHistoryController(UserItemHistoryService userItemHistoryService) {
        this.userItemHistoryService = userItemHistoryService;
    }

    @PostMapping("/update")
    public ResponseEntity<UserItemHistory> userItemUpdate (@RequestBody UserItemHistoryDto userItemHistoryDto) {
        return new ResponseEntity<>(userItemHistoryService.userItemUpdate(userItemHistoryDto), HttpStatus.OK);
    }

    @GetMapping("/getlist/{charNickName}")
    public ResponseEntity<List<UserItemHistoryDto>> getItemHistoryByCharNickName (@PathVariable String charNickName) {
        return new ResponseEntity<>(userItemHistoryService.getItemHistoryByCharNickName(charNickName),HttpStatus.OK);
    }


}
