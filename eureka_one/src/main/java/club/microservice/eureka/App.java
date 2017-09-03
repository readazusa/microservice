package club.microservice.eureka;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by 念梓  on 2017/8/28.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@SpringBootApplication
@EnableEurekaServer
public class App {

    private static final Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        log.debug("开始");
        SpringApplication a = new SpringApplication(args);
        a.run(App.class);
//        new SpringApplicationBuilder(App.class).web(true).run(args);

    }
}
