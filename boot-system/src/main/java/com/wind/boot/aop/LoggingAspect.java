package com.wind.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @fileName LoggingAspect.java
 * @package com.ancda.palmbaby.ancda.aop
 * @description 性能日志记录
 * @author wind
 * @date 2017年6月23日 下午12:55:07
 * @version V1.0
 */
@Aspect
@Component
public class LoggingAspect {
    
    private static final Logger logger = LoggerFactory.getLogger("speedLog");
    
    
    /**
     * 
     * </p>性能日志切面</p>
     * @author wind
     */
    @Pointcut("execution(* com.wind.boot.controller..*.*(..)) || execution(* com.wind.boot.dao..*.*(..))")
    public void logAspect() {

    }
    
    /**
     * 
     * </p>打印日志切面</p>
     * @author wind
     */
    @Pointcut("execution(* com.wind.boot.controller..*.*(..))")
    public void printAspect() {

    }
    
    /**
     * 
     * </p>拦截方法，计算方法执行耗时并写入日志文件</p>
     * @param point
     * @return
     * @throws Throwable
     * @author wind
     */
    @Around("logAspect()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            Object result = point.proceed();
            return result;
        } finally {
            logger.info("{} {} timeConsuming：{}", point.getSignature().getDeclaringTypeName().substring(point.getSignature().getDeclaringTypeName().lastIndexOf(".") + 1),
                    point.getSignature().getName(), (System.currentTimeMillis() - startTime) + " ms");
        }
        
    }
    
    /**
     * 
     * </p>打印方法返回值</p>
     * @author wind
     */
    @AfterReturning(value = "printAspect()",returning="returnValue")
    public void doAfterReturning(JoinPoint joinPoint, Object returnValue) throws Throwable {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        String simpleName = targetClass.getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Logger log = LoggerFactory.getLogger(targetClass);
        log.info("{}.{} return value is {}", simpleName, methodName, returnValue);
    }
    
}
