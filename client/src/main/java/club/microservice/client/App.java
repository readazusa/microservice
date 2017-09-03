package club.microservice.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 念梓  on 2017/8/29.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@SpringCloudApplication
@EnableZuulProxy
public class App {


    private static final Logger log = LogManager.getLogger(App.class);

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(args);
        application.run(App.class);
    }
}
