package club.microservice.client.controller;

import club.microservice.client.annotation.ApplicationLog;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/8/29.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
public class HelloClientController {

    private static  final Logger log = LogManager.getLogger(HelloClientController.class);

//    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpServletRequest request;

    @RequestMapping("hello")
    @ApplicationLog(msg = "第一个测试")
    public String hello(String name){

//        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =  restTemplate.getForEntity("http://one-service/index",String.class);
        log.info("getStatusCodeValue: {}",responseEntity.getStatusCodeValue());
        log.info("getBody: {}",responseEntity.getBody());

        return responseEntity.getBody();
    }

    @RequestMapping("session")
    public String setSession(){
        request.getSession().setAttribute("username","你好啊");
        return "success";
    }


    @RequestMapping("hystrix")
    @HystrixCommand(fallbackMethod = "fallBack")
    public String hystrix(){
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "熔断器";
    }

    public String fallBack(){
        return "熔断起作用";
    }

}
