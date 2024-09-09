package DW.PocatRush.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "아이템")
public class Items {

    @Id
    @Column(name = "아이템아이디")
    private String itemId;

    @Column(name = "아이템이름")
    private String itemName;

    @Column(name = "아이템설명")
    private String itemInfo;

    @Column(name = "가격")
    private int itemPrice;


}
