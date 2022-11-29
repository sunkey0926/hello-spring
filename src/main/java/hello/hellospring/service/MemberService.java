package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

//@Service
@Transactional
public class MemberService {

    //private  final MemberRepository memberRepository = new MemoryMemberRepository();

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입
     */
    public Long join(Member member){
    		// 같은 이름이 있는 중복회원 X
//          Optional<Member> result = memberRepository.findByName(member.getName());
//          result.ifPresent(m ->{
//              throw new IllegalStateException("이미 존재하는 회원입니다.");
//          });
          validateDuplicateMember(member); // 중복회원 검증

          memberRepository.save(member);
          return member.getId();
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 단일 회원 조회
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

}
