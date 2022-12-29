package gdsc.yolog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data // Getter, Setter 생성
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 생성해줍니다.
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 생성해줍니다.
@Builder // builder 메서드를 자동 생성해줍니다.
@Entity // 서버 실행 시, Object Relation Mapping(ORM) 이 됨. (즉, 테이블이 DB에 생성 됨)
public class Post {

    @Id // PK를 해당 변수로 하겠다는 뜻.
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;

    @Column(length = 50000) // 최대 길이 설정
    private String content;



//    //  @Data - Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
//    private Long id;
//    private String title;
//    private String content;
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    public String getTitle() { return title; }
//    public void setTitle(String title) { this.title = title; }
//    public String getContent() { return content; }
//    public void setContent(String content) { this.content = content; }


//    // @NoArgsConstructor, @AllArgsConstructor
//    private Long id;
//    private String title;
//    private String content;
//    public Post() {
//    }
//    public Post(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }



}