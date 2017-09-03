package club.microservice.service;


import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by 念梓  on 2017/8/28.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class App {

    private static final Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
//        log.debug("开启了一个服务");
        List<String> list = Lists.newArrayList(args);
        list.add("122");

        args= list.toArray(new String[list.size()]);

//        SpringApplication springApplication = new SpringApplication(args);
//        springApplication.setDefaultProperties();
        SpringApplication.run(App.class,args);

    }

}
