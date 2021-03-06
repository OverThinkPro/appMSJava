package com.webleader.appms.annotation;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webleader.appms.bean.system.TBLog;
import com.webleader.appms.bean.system.User;
import com.webleader.appms.db.service.system.TBLogService;
/**
 * @className SystemLogAspect
 * @description 切点类
 * @author HaoShaSha
 * @date 2017年6月4日 下午9:21:33
 * @version 1.0.0
 */
@Component("systemLogAspect")

@Aspect
public class SystemLogAspect {
	
	public static User user;

	@Autowired
	private TBLogService logService;
	
	private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

	/** 
	 * @description Controller层切点
	 */
	@Pointcut("execution(* com.webleader.appms.controller..*.*(..)) &&"
			+ "@annotation(com.webleader.appms.annotation.SystemLogController)")
	//@Pointcut("execution(* com.webleader.appms.annotation.SystemLogController.*(..))")
	public void controllerAspect() {
		System.out.println("=========controllerAspecr===");
	}
   
	/** 
	 * @description 后置通知 用于拦截Controller层记录用户的操作
	 * @param joinPoint切点 
	 */

	@AfterReturning("controllerAspect()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("=====SysLogAspect后置通知开始=====");  
		try {
			//获取目标类名  
	        String targetName = joinPoint.getTarget().getClass().getName();  
	        //获取方法名  
	        String methodName = joinPoint.getSignature().getName();  
	        //获取相关参数  
	        Object[] arguments = joinPoint.getArgs();  
	        //生成类对象  
	        Class targetClass = Class.forName(targetName);  
	        //获取该类中的方法  
	        Method[] methods = targetClass.getMethods();  
	        
			String opType = "";
			String opContent = "";
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						opType = method.getAnnotation(SystemLogController.class).opType();
						opContent = method.getAnnotation(SystemLogController.class).opContent();
						break;
					}
				}
			}
			/* ==========数据库日志========= */
			TBLog log = new TBLog();
			Date now = new Date();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String datetime = dateFormat.format(now); 
			log.setLogId(UUID.randomUUID().toString());
			log.setOpType(opType);
			log.setOpContent(opContent);
			log.setOpDate(Timestamp.valueOf(datetime));
			log.setUserId(SystemLogAspect.user.getUserId());
			log.setUserName(SystemLogAspect.user.getUserName());
			System.out.println("------------------------------");
			System.out.println(log);
			logService.insert(log); 
			
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("异常信息:{}", e.getMessage());
		}
	}

}