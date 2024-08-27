package DW.PocatRush.controller;

import DW.PocatRush.dto.BaseResponse;
import DW.PocatRush.dto.CharacterDto;
import DW.PocatRush.enumstatus.ResultCode;
import DW.PocatRush.model.Character;
import DW.PocatRush.model.User;
import DW.PocatRush.service.CharacterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/character")
public class CharacterController {
    private CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }


    @PostMapping("/create")
    public ResponseEntity<BaseResponse<String>> createUserCharacter(@Valid @RequestBody CharacterDto characterDto) {
        return new ResponseEntity<>(
                new BaseResponse<>(ResultCode.SUCCESS.name(),
                        characterService.createUserCharacter(characterDto),
                        ResultCode.SUCCESS.getMsg()), HttpStatus.OK);

    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<BaseResponse<Character>> getCharacterByUserId(@PathVariable String userId){
        return new ResponseEntity<>(
                new BaseResponse<>(ResultCode.SUCCESS.name(),
                        characterService.getCharacterByUserId(userId),
                        ResultCode.SUCCESS.getMsg()),HttpStatus.OK);

    }

    @GetMapping("/overlap/{nickName}")
        public HttpStatus checkOverlapCharacter(@PathVariable String nickName) {
            return characterService.checkOverlapCharacter(nickName);
    }

}

