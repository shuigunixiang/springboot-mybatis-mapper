package com.igancao.framework.aop;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ActionLogAdvice {

	// 副本
	ThreadLocal<String> current = new ThreadLocal<String>();
	private static final Logger logger = LoggerFactory
			.getLogger(ActionLogAdvice.class);

	@Around("execution(* com.igancao.web.*Controller.*(..))")
	public Object ActionTimeLog(ProceedingJoinPoint thisJoinPoint)
			throws Throwable {
		current.set(Thread.currentThread().getName() + " "
				+ getMethodName(thisJoinPoint));
		logger.info("【" + current.get() + "】开始执行...");
		long time = System.currentTimeMillis();
		Object result = thisJoinPoint.proceed();
		time = System.currentTimeMillis() - time;
		logger.info("【" + current.get() + "】执行耗时：" + time);
		return result;
	}

	@AfterThrowing(pointcut = "execution(* com.igancao.web.*Controller.*(..))", throwing = "ex")
	public void ActionExceptionLog(Throwable ex) {
		logger.error("【" + current.get() + "】执行异常："
				+ ExceptionUtils.getFullStackTrace(ex));
	}

	// 当前执行的方法
	private String getMethodName(ProceedingJoinPoint thisJoinPoint)
			throws NoSuchMethodException, SecurityException {
		return thisJoinPoint.getSignature().getDeclaringTypeName() + "."
				+ thisJoinPoint.getSignature().getName();

	}
}
