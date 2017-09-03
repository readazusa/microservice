package club.microservice.client.aspect;

import club.microservice.client.annotation.ApplicationLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by 念梓  on 2017/8/30.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
@Aspect
public class ApplicationLogAspect {

    private static final Logger log = LogManager.getLogger(ApplicationLogAspect.class);

    @Resource
    private HttpServletRequest request;

    /**
     * 任意返回值,club.microservice.client包下面的任何方法
     */
    @Pointcut("execution(* club.microservice.client..controller..*(..))")
    public void anyMethod() {
        System.out.println("执行切入: " + Thread.currentThread().getName());
    }

    @After("anyMethod()")
    public void after(JoinPoint pjp) {
        System.out.println("执行后续的方法");
        Object username = request.getSession().getAttribute("username");
        log.info("username: {}", username);
        Class targetClass = pjp.getTarget().getClass();
        String targetMethodName = pjp.getSignature().getName();
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (targetMethodName.equals(method.getName())) {
                execLog(method);
                break;
            }
        }
    }

//    @Around("anyMethod()")
//    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//        Object username = request.getSession().getAttribute("username");
//        log.info("username: {}", username);
//        Object object = pjp.proceed();//执行该方法
//        Class targetClass = pjp.getTarget().getClass();
//        String targetMethodName = pjp.getSignature().getName();
//        Method[] methods = targetClass.getMethods();
//        for (Method method : methods) {
//            if (targetMethodName.equals(method.getName())) {
//                execLog(method);
//                break;
//            }
//        }
//        return object;
//    }


    public void execLog(Method method) {

        Annotation[] annotations = method.getDeclaredAnnotations();
        String logMsg = null;
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(ApplicationLog.class)) {
                ApplicationLog applicationLog = (ApplicationLog) annotation;
                String msg = applicationLog.msg();
                break;
            }
        }
    }
}
