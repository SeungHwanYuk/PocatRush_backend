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
@Table(name = "디바이스데이터")
public class Device {

    @Id
    @Column(name = "디바이스번호")
    private String deviceNum;

    @Column(name = "km")
    private String km;
    @Column(name = "kg")
    private String kg;
    @Column(name = "min")
    private String min;

    @ManyToOne
    @JoinColumn(name = "사용자아이디")
    private User user;
}
