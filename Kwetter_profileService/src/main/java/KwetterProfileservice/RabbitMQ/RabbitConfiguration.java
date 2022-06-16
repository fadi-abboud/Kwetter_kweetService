package KwetterProfileservice.RabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfiguration {
    @Bean
    public Queue hello() {
        return new Queue("notification", true, false, false);
    }

    @Bean
    public rabbitSender sender() {
        return new rabbitSender();
    }
}
