package hu.unideb.prog2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Aspect
@Service
public class NeedsMeasuringAspect {

    @Around("@annotation(hu.unideb.prog2.NeedsMeasuring)")
    public Object timeAnnotatedMethod(ProceedingJoinPoint pjp) throws Throwable {
        long before = System.nanoTime();
        Object retVal = pjp.proceed();
        long after = System.nanoTime();
        System.out.println(String.format("The entire measurement took %d ms.", (long) (after - before) / 1000000));
        return retVal;
    }
}
