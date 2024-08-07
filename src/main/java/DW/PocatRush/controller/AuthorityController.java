package DW.PocatRush.controller;

import DW.PocatRush.model.Authority;
import DW.PocatRush.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/authority")
public class AuthorityController {

    AuthorityService authorityService;

    @Autowired
    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Authority>> getAllAuthority(){
        return new ResponseEntity<>(authorityService.getAllAuthority(), HttpStatus.OK);
    }
}
