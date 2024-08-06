package DW.PocatRush.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "댓글")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "댓글번호")
    private long replyId;

    @Column(name = "댓글내용")
    private String replyText;

    @Column(name = "댓글등록일")
    private LocalDate replyDate;

    @ManyToOne
    @JoinColumn(name = "사용자아이디")
    private User user;

    @ManyToOne
    @JoinColumn(name = "게시글번호")
    private Post post;
}
