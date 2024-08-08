package DW.PocatRush.service;

import DW.PocatRush.dto.UserDto;
import DW.PocatRush.model.Authority;
import DW.PocatRush.model.User;
import DW.PocatRush.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
   private UserRepository userRepository;

   private BCryptPasswordEncoder bCryptPasswordEncoder;


   @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // 회원가입 0808 승환
    public String saveUser(UserDto userDto) {
        Authority authority =new Authority();
        authority.setAuthorityName("ROLE_USER");

        User users = new User(
                userDto.getUserId(),
                authority,
                bCryptPasswordEncoder.encode(userDto.getPassword()),
                userDto.getUserEmail(),
                userDto.getUserName(),
                userDto.getGender(),

                LocalDateTime.now());
        return userRepository.save(users).getUserId();
    }

    // 비밀번호는 null, 모든 유저정보 표시 0808 승환
    public List<UserDto> getAllUserByDto() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            UserDto userDto = new UserDto();
            userDtoList.add(userDto.toUserDtoFromUser(userList.get(i)));
        }
        return userDtoList;
    }


}
