package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


/**
 * 자바코드로 직접 스프링 빈 등록하기
 */
@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//	private EntityManager em;
//	
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
    @Bean
    public MemberService memberService(){
        //return new MemberService(memoryMemberRepository());
    	return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memoryMemberRepository(){
//        // return new MemoryMemberRepository();
//        // return new JdbcMemberRepository(dataSource);
//        // return new JdbcTemplateMemberRepository(dataSource);
//    	 return new JpaMemberRepository(em);
//
//    }

//	@Bean
//	public TimeTraceAop timeTraceAop(){
//		return new TimeTraceAop();
//	}


}
