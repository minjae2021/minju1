package project.minju1.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.minju1.entity.Member;
import project.minju1.entity.Post;
import project.minju1.entity.QPost;
import project.minju1.repository.MemberRepository;
import project.minju1.repository.PostRepository;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    /**
     * 글쓰기
     */
    public Long postWrite(Long memberId, String title, String content){

        //엔티티 조회
        Member member = memberRepository.findById(memberId).get();

        //글 생성
        Post post = new Post(member,title,content);

        //글 저장
        postRepository.save(post);
        return post.getId();
    }
    /**
     * 삭제
     */
    public void postDelete(Long postId){

        Post findPost = postRepository.findById(postId).get();
        postRepository.delete(findPost);
    }

    /**
     * 조회
     */
    //글을 작성한 member의 Id로 조회
    public List<Post> findAllPostById(Long memberId){
        List<Post> result = postRepository.findAllPostByMemberId(memberId);
        return result;
    }
    //글의 title로 조회
    public List<Post> findByTitle(String title){
        List<Post> result = postRepository.findByTitle(title);
        return result;
    }
    //글을 작성한 member의 username으로 조회
    public List<Post> findAllPostByName(String name){
        List<Post> result = postRepository.findAllPostByMemberUsername(name);
        return result;
    }

}
