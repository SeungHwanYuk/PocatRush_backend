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
@Table(name = "추파TEST")
public class LikeNPCTest {

    @Id
    @Column(name = "NPC이름")
    private String npcName;

    @Column(name = "갯수")
    private int liked;
}
