package DW.PocatRush.dto;


import DW.PocatRush.model.Character;
import DW.PocatRush.model.Level;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RankCharacterDto {

    private int rank;
    private String charNickName;
    private String userId;
    private String profileImage;
    private long exp;
    private int createDateFromNow;
    private long point;
    private String level;
    private String levelImage;

    
    // 랭킹에 필요한 정보를 위한 DTO
    // 랭크는 불릴때 경험치 비교후 결정됨 -> 저장되면 안되는 값
    public static RankCharacterDto toCharDtoFromChar(int rank, Character character){
        return new RankCharacterDto(
                rank,
                character.getCharNickName(),
                character.getUser().getUserId(),
                character.getProfileImage(),
                character.getCharExp(),
                LocalDate.now().getDayOfYear() - character.getCreateCharDate().getDayOfYear(),
                character.getUserPoint(),
                character.getLevel().getLevelId(),
                character.getLevel().getMedalImage()
        );
    }

//    @PrePersist
//    public void getHowLongPlayDate(LocalDate createDate){
//        this.createDateFromNow = LocalDate.now().getDayOfYear() - createDate.getDayOfYear();
//    }
}
