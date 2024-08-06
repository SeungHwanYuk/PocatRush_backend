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
@Table(name = "자유게시판")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "게시글번호")
    private long postId;

    @Column(name = "글제목")
    private String postTitle;
    @Column(name = "글내용")
    private String postText;

    @Column(name = "등록일자")
    private LocalDate postDate;
    @Column(name = "이미지")
    private String postImage;

    @ManyToOne
    @JoinColumn(name = "게시판번호")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "사용자아이디")
    private User user;
}
