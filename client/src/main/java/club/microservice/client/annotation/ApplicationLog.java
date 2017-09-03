package club.microservice.client.annotation;

import java.lang.annotation.*;

/**
 * Created by 念梓  on 2017/8/30.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApplicationLog {
    String msg();



}
