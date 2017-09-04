package club.microservice.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Created by 念梓  on 2017/9/4.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */

@SpringBootApplication
@EnableZipkinServer
public class App {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(args);
        application.run(App.class);
    }
}
