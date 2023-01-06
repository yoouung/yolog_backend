package gdsc.yolog.service;

import gdsc.yolog.domain.Post;
import gdsc.yolog.dto.WritePostReq;
import gdsc.yolog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service // 해당 클래스를 Spring Container에 빈으로 등록 후, Spring MVC 서비스로 표시
@RequiredArgsConstructor // final 또는 @NotNull 이 붙은 필드의 생성자를 자동으로 생성해준다.

public class PostService {

    // Spring Container에 싱글톤으로 생성되고 관리되는, PostRepository Bean 을 의존성 주입 받는다.
    private final PostRepository postRepository;


    // 단건 생성
    @Transactional // 해당 함수 종료 시, commit 또는 Rollback 수행 (트랜젝션 관리)
    public  Post save(WritePostReq writePostReq) {
        Post post = Post.builder()
                .title(writePostReq.getTitle())
                .content(writePostReq.getContent()).build();
        return postRepository.save(post);
    }

    // 전체 조회
    @Transactional(readOnly = true) // PA 변경감지(Database의 객체 필드값의 변경을 감지하는 내부 기능) Off
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    // 단건 조회
    @Transactional(readOnly =true)
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("id에 해당하는 Post 가 없습니다."));
    }

    // 단건 수정
    // 해당 서비스 함수 종료 시 => 트랜잭션 종료 시 => 영속화 되어있는 데이터를 DB로 갱신 (flush) => DB에 commit
    @Transactional
    public Post updateById(Long id, WritePostReq writePostReq) {
        Post postEntity = postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("id에 해당하는 Post 가 없습니다."));
        postEntity.setTitle(writePostReq.getTitle());
        postEntity.setContent(writePostReq.getContent());
        return postEntity;
    }

    // 단건 삭제
    @Transactional
    public String deleteById(Long id) {
        try {
            postRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("id에 해당하는 Post 가 없습니다.");
        }
        return "ok";
    }

}
