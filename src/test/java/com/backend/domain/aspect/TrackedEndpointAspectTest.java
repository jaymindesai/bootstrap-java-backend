package com.backend.domain.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.*;


@RunWith(JUnit4.class)
public class TrackedEndpointAspectTest {

    private TrackedEndpointAspect aspect;
    private final ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);

    @Before
    public void setUp() {
        aspect = new TrackedEndpointAspect();
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"mock-args"});
    }

    @Test
    public void should_execute_around_advice_correctly() throws Throwable {
        // when
        aspect.around(proceedingJoinPoint);

        // then
        verify(proceedingJoinPoint, times(1)).proceed(); // proceed() called only once
        verify(proceedingJoinPoint, never()).proceed(null); // proceed(Object[] args) called never
    }
}