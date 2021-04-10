package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all or our related advices for logging
	
	// let's start with an @Before advice
	
	//@Before("execution(public void addAccount())") // This is @Before Advice with Pointcut expression
	//@Before("execution(public void add*())") // wildcard methodName
	//@Before("execution(void add*())") // method type with return type void and methodName starting with add
	// @Before("execution(* add*())") // any return type with methodName starting with add
	//@Before("execution(* add*(com.luv2code.aopdemo.Account))") // specific param type with method starting with add
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") // specific param type and param wildcard(any number of parameters) with method starting with add
	//@Before("execution(* add*(..))") // pass any number of parameters of any type
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")	// match methods in a package of any type, name and any no.of parameters
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}

}
