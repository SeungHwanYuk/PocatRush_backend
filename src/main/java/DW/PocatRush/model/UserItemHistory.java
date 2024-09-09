package DW.PocatRush.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "아이템소유정보")
public class UserItemHistory {

    @Id
    @Column(name = "아이템소유번호")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemHistoryNum;

    @ManyToOne
    @JoinColumn(name = "캐릭터닉네임")
    private Character charNickName;

    @ManyToOne
    @JoinColumn(name = "아이템아이디")
    private Items itemId;

    @Column(name = "개수")
    private int itemValue;


}
