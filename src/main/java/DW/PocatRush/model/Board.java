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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "게시판")
public class Board {

    @Id
    @Column(name = "게시판번호")
    private long boardId;

    @Column(name = "게시판이름")
    private String boardTitle;
}
