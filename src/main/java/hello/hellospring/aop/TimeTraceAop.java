package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //AOP로 사용하는 클래스
@Component
public class TimeTraceAop {

    //공통 관심사항을 어디에 적용할 것인지 타겟팅
//    @Around("execution(* hello.hellospring..*(..))") //패키지 하위에 모두 적용
    @Around("execution(* hello.hellospring.service..*(..))") //service 패키지 하위에 모두 적용

    public Object execute(ProceedingJoinPoint joinPoint) throws  Throwable{
        //시간 로직
        long start = System.currentTimeMillis();
        System.out.println("START: "+joinPoint.toString());
        try{
            return joinPoint.proceed(); //다음 메서드로 진행
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: "+joinPoint.toString()+" "+timeMs+"ms");
        }

    }
}
