package hello.hellospring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
@Slf4j
public class TimeTraceAop {

    @Around("execution(* hello.hellospring.controller..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        String uuid = UUID.randomUUID().toString();
        long start = System.currentTimeMillis();
        log.info("[{}][START][{}]", uuid, joinPoint.getTarget().getClass().getName());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            log.info("[{}][START][{}][result time : {} ms]", uuid, joinPoint.getTarget().getClass().getName(), timeMs);

        }
    }
}

