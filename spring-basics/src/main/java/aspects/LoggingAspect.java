package aspects;


import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Aspect
@Order(1)
public class LoggingAspect {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method will execute");
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Method " + methodName + " with params " + List.of(args) + " will execute");
        Object returned = joinPoint.proceed();
        logger.info("Method executed and returned " + returned);
        return returned;
    }
}
