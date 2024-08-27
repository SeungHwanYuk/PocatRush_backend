package DW.PocatRush.service;

import DW.PocatRush.dto.CharacterDto;
import DW.PocatRush.exception.ResourceNotFoundException;
import DW.PocatRush.model.Character;
import DW.PocatRush.model.Level;
import DW.PocatRush.model.User;
import DW.PocatRush.repository.CharacterRepository;
import DW.PocatRush.repository.UserRepository;
import jakarta.transaction.Status;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class CharacterService {
    private CharacterRepository characterRepository;

    private UserRepository userRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, UserRepository userRepository) {
        this.characterRepository = characterRepository;
        this.userRepository = userRepository;
    }

    public String createUserCharacter(CharacterDto characterDto) {
        System.out.println("캐릭터 정보 : " + characterDto.getUser() + characterDto.getCharNickName() );
        Optional<User> userOptional = userRepository.findById(characterDto.getUser());
        Level level = new Level();
        level.setLevelId("인간");
        Character character = new Character();

        if (userOptional.isPresent()) {

            character.setCharNickName(characterDto.getCharNickName());
            character.setUser(userOptional.get());
            character.setLevel(level);
            character.setCharExp(0);
            character.setUserPoint(100);
            character.setCharHp(10);
            character.setCreateCharDate(LocalDate.now());
            character.setProfileImage(characterDto.getProfileImage());
            return characterRepository.save(character).getCharNickName();
        } else {
            throw new ResourceNotFoundException("User", "ID", characterDto.getUser());
        }
    }

    public Character getCharacterByUserId(String userId) {
        Optional<User> userOptional = userRepository.findByUserId(userId);
        if (userOptional.isPresent()) {
                return characterRepository.findByUser(userOptional.get());
        } else {
                throw new ResourceNotFoundException("User", "ID", userId);
        }
    }

    public HttpStatus checkOverlapCharacter(String nickName) {
        Optional<Character> characterOptional = characterRepository.findById(nickName);
        if(characterOptional.isPresent())
        {
            return HttpStatus.FOUND;
        } else {
            return HttpStatus.NOT_FOUND;
        }

    }
}
