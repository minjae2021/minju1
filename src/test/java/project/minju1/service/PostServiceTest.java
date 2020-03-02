package project.minju1.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import project.minju1.entity.Member;
import project.minju1.entity.Post;
import project.minju1.repository.MemberRepository;
import project.minju1.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PostService postService;

    @BeforeEach
    public void before(){
        Member member = new Member("minju");
        memberRepository.save(member);

        Long postId1 = postService.postWrite(member.getId(), "글 제목", "글 내용1");
        Long postId2 = postService.postWrite(member.getId(), "글 제목", "글 내용2");
        Long postId3 = postService.postWrite(member.getId(), "글 제목", "글 내용3");
        Long postId4 = postService.postWrite(member.getId(), "글 제목1", "글 내용4");
    }


    @Test
    public void postFindTest(){
        Member findMember = memberRepository.findByUsername("minju").get(0);
        List<Post> result = postRepository.findAllPostByMemberId(findMember.getId());
        for (Post post : result) {
            System.out.println("post = " + post);
        }
    }

    @Test
    public void postDeleteTest(){
        Long postId = postRepository.findByTitle("글 제목1").get(0).getId();
        postService.postDelete(postId);
        Member findMember = memberRepository.findByUsername("minju").get(0);
        int size = postService.findAllPostById(findMember.getId()).size();
        assertThat(size).isEqualTo(1);
    }

    @Test
    public void findByTitleTest(){
        List<Post> result = postService.findByTitle("글 제목");
        for (Post post : result) {
            System.out.println("post = " + post);
        }
    }

    @Test
    public void findByNameTest(){
        List<Post> result = postService.findAllPostByName("minju");
        for (Post post : result) {
            System.out.println("post = " + post);
        }
    }

}