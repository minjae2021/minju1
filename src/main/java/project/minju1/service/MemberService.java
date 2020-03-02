package project.minju1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.minju1.entity.Member;
import project.minju1.repository.MemberRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    public Long join(Member member){
        memberRepository.save(member);
        return member.getId();
    }

    //id로 회원 찾기
    @Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return memberRepository.findById(memberId).get();
    }

    //이름으로 회원찾기
    public List<Member> findByUsername(String name){
        List<Member> result = memberRepository.findByUsername(name);
        return result;
    }

}
