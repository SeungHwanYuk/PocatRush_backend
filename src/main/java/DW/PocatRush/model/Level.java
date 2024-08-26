package DW.PocatRush.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "레벨")
public class Level {

    @Id
    @Column(name = "레벨명")
    private String levelId;

    @Column(name = "레벨업필요경험치하한선")
    private long levelUpExpLowLimit;

    @Column(name = "레벨업필요경험치상한선")
    private long levelUpExpHighLimit;
}
