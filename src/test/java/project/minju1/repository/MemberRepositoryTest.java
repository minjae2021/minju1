package project.minju1.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.minju1.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @BeforeEach
    public void before(){
        Member member1 = new Member("minju");
        Member member2 = new Member("member2");
        memberRepository.save(member1);
        memberRepository.save(member2);

    }

    @Test
    public void memberTest(){
        List<Member> findMember = memberRepository.findByUsername("minju");
        assertThat(findMember.get(0).getUsername()).isEqualTo("minju");
    }
}