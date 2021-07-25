package com.backend.domain.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


/**
 * Handler aspect for @Tracked annotation
 *
 */
@Aspect
public class TrackedEndpointAspect {

    @Around("execution(* *(..)) && @annotation(com.backend.domain.aspect.Tracked)")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        pjp.proceed();
        afterAction(pjp.getArgs());
    }

    private void afterAction(Object[] args) {
        // post-processing actions...
    }
}
