package aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class SecurityAspect {
    private Logger logger = Logger.getLogger(SecurityAspect.class.getName());


    @Around(value = "@annotation(ToLog)")
    public Object secure (ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Security Aspect: calling the intercepted method");
        Object returnedValue = joinPoint.proceed();
        logger.info("Security Aspect: method executed and returned " + returnedValue);
        return returnedValue;
    }
}