package DW.PocatRush.controller;

import DW.PocatRush.dto.BaseResponse;
import DW.PocatRush.dto.SessionDto;
import DW.PocatRush.dto.UserDto;
import DW.PocatRush.enumstatus.ResultCode;
import DW.PocatRush.service.UserDetailService;
import DW.PocatRush.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/")
public class UserController {

   private UserService userService;
    private UserDetailService userDetailService;

    private AuthenticationManager authenticationManager;

    private HttpServletRequest httpServletRequest;

    @Autowired
    public UserController(UserService userService, UserDetailService userDetailService, AuthenticationManager authenticationManager, HttpServletRequest httpServletRequest) {
        this.userService = userService;
        this.userDetailService = userDetailService;
        this.authenticationManager = authenticationManager;
        this.httpServletRequest = httpServletRequest;
    }

    // 로그인 0808 승환
//    @PostMapping("login")
//    public ResponseEntity<String> login(@RequestBody UserDto userDto,
//                                        HttpServletRequest request) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(userDto.getUserId(), userDto.getPassword())
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // 세션 생성
//        HttpSession session = request.getSession(false); // true : 세선이 없으면 새로 생성
//        // 세션에 인증 객체 저장
//        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
//                SecurityContextHolder.getContext());
//
//        return ResponseEntity.ok("Success");
//    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<String>> login(@RequestBody UserDto userDto,
                                                      HttpServletRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUserId(), userDto.getPassword())
        );

        // 인증 저장공간. 인증한 정보를 딱 하나만 저장가능
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 세션 생성
        HttpSession session = request.getSession(true); // true : 세션이 없으면 새로 생성
        // 세션에 인증 객체 저장
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());

        return new ResponseEntity<>(
                new BaseResponse<>(ResultCode.SUCCESS.name(),
                        null,
                        ResultCode.SUCCESS.getMsg())
                , HttpStatus.OK);

    }

    // 회원가입 0808 승환
    @PostMapping("signup")
    public ResponseEntity<BaseResponse<String>> saveUser(@Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                new BaseResponse<>(ResultCode.SUCCESS.name(),
                        userService.saveUser(userDto),
                        ResultCode.SUCCESS.getMsg()), HttpStatus.OK);
    }

    // 비밀번호는 null, 모든 유저정보 표시 0808 승환
    @GetMapping("allbydto")
    public ResponseEntity<List<UserDto>> getAllUserByDto() {
        return new ResponseEntity<>(userService.getAllUserByDto(), HttpStatus.OK);
    }

    // 세션커런트 0808 승환
//    @GetMapping("current")
//    public SessionDto getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
//            throw new IllegalStateException("유저의 권한이없습니다");
//        }
//        SessionDto sessionDto = new SessionDto();
//        sessionDto.setUserId(authentication.getName());
//        sessionDto.setAuthority(authentication.getAuthorities());
//        return sessionDto;
//    }

    @GetMapping("/current")
    public ResponseEntity<BaseResponse<SessionDto>> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("User is not authenticated");
        }
        SessionDto sessionDto = new SessionDto();
        sessionDto.setUserId(authentication.getName());
        sessionDto.setAuthority(authentication.getAuthorities());

        return new ResponseEntity<>(
                new BaseResponse(ResultCode.SUCCESS.name(),
                        sessionDto,
                        ResultCode.SUCCESS.getMsg())
                , HttpStatus.OK);
    }

}
