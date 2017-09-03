package club.microservice.service.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/8/28.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
public class HelloController {

    private  static  final Logger log = LogManager.getLogger(HelloController.class);

//    private static final Logger
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        log.info("/hello host:{}，port:{},service_id: {}",serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getServiceId());


        return "第一个主页";
    }

}
