package Kwetterkweetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:application_config.xml")
@SpringBootApplication
public class KweetserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KweetserviceApplication.class, args);
    }

}
