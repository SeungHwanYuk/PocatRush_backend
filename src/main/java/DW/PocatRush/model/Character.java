package DW.PocatRush.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "사용자캐릭터")
public class Character {

    @Id
    @Column(name = "캐릭터닉네임")
    private String charNickName;

    @OneToOne
    @JoinColumn(name = "사용자아이디")
    private User user;

    @Column(name = "누적경험치")
    private long charExp;
    @Column(name = "유저체력")
    private long charHp;
    @Column(name = "보유포인트")
    private long userPoint;
    @Column(name = "생성날짜")
    private LocalDate createCharDate;
    @Column(name = "프로필이미지")
    private String profileImage;

    @ManyToOne
    @JoinColumn(name = "레벨명")
    private Level level;


}
