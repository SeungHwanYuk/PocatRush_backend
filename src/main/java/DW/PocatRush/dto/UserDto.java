package DW.PocatRush.dto;


import DW.PocatRush.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotBlank(message = "유저 아이디는 필수로 입력해주세요")
    private String userId;

    @NotBlank(message = "비밀번호는 필수로 입력해주세요")
    @Size(min = 4, message = "비밀번호는 4글자 이상으로 입력해주세요")
    private String password;

    @NotBlank(message = "이름은 필수로 입력해주세요")
    private String userName;

    @NotBlank(message = "이메일은 필수로 입력해주세요")
    @Email(message = "이메일 형식으로 입력해주세요")
    private String userEmail;

    @NotBlank(message = "성별은 필수로 선택해주세요")
    private String gender;




    // 0808 BaseResponse를 위한 Dto 승환
    public static UserDto toUserDtoFromUser(User user) {
        return new UserDto(
                user.getUserId(),
                null,
                user.getUserRealName(),
                user.getEmail(),
                user.getGender()

        );
    }

}
