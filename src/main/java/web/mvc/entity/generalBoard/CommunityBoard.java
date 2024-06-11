package web.mvc.entity.generalBoard;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import web.mvc.entity.user.Users;

import java.time.LocalDateTime;

@ToString //나중에 뺄수도(-> 무한루프 발생 가능성?)
@Setter
@Getter
@Entity
@Table(name = "CommunityBoard")
public class CommunityBoard {

    @Id
    //시퀀스 전략을 사용하여 기본 키 값을 자동으로 생성하도록 설정. generator 속성의 값은 아래의 name과 일치해야 함.
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commBoardSeq")
    //sequencName은 데이터베이스 시퀀스의 이름. name은 JPA에서 이 시퀀스를 식별하는 이름.
    @SequenceGenerator(allocationSize = 1, sequenceName = "commBoardSeq", name = "commBoardSeq")
    @Column(name = "COMM_BOARD_SEQ")
    private Long commBoardSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_SEQ", nullable = false)
    private Users user;

    @Column(name = "BOARD_TITLE", nullable = false)
    private String boardTitle;

    @Column(name = "BOARD_CONTENT", nullable = false)
    private String boardContent;

    @Column(name = "BOARD_TYPE", nullable = false)  //0번 : 실명(게시자 정보 표시) 게시판, 1번 : 익명 게시판
    private int boardType;

    @Column(name = "BOARD_LIKE", nullable = false)
    private int boardLike;

    @CreationTimestamp
    @Column(name = "BOARD_REG_DATE", nullable = false)
    private LocalDateTime boardRegDate;

    @UpdateTimestamp
    @Column(name = "BOARD_UPDATE_DATE", nullable = false)
    private LocalDateTime boardUpdateDate;

    @Column(name = "BOARD_PWD", nullable = false)
    private String boardPwd;

}