package DW.PocatRush.dto;

import DW.PocatRush.model.Level;
import DW.PocatRush.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {

@NotBlank(message = "닉네임은 필수로 입력해주세요")
    private String charNickName;


    private String user;


    private String profileImage;


}
