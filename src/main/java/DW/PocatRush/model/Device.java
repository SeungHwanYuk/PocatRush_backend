package DW.PocatRush.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.security.SecureRandom;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "디바이스데이터")
public class Device {

    @Id
    @Column(name = "디바이스아이디", length = 20)
    private String deviceId;

    @Column(name = "km")
    private int km;
    @Column(name = "kg")
    private int kg;
    @Column(name = "min")
    private int min;


    @Column(name = "동기화날짜")
    @CreationTimestamp
    private LocalDate createDate;

    @Column(name = "업데이트날짜")
    @UpdateTimestamp
    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "사용자아이디")
    private User user;

    // 랜덤 난수 생성
    private static final SecureRandom random = new SecureRandom();

    @PrePersist
    public void generateDeviceId() {
        if (this.deviceId == null) {
            // ID 생성 로직 구현
            if (this.deviceId == null) {
                this.deviceId = "DEV" + String.format("%010d", random.nextInt(1000000000));
            }
        }
    }
}
