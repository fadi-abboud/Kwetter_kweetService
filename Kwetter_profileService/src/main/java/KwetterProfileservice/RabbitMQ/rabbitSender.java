package KwetterProfileservice.RabbitMQ;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import KwetterProfileservice.profileModels.ModelsRabbit.ModelRabbitFollowerSubmit;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


public class rabbitSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;


    private ObjectMapper objectMapper = new ObjectMapper();

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(int user_id) throws JsonProcessingException {
        ModelRabbitFollowerSubmit submitModel = new ModelRabbitFollowerSubmit();
        submitModel.setUser_id(user_id);
        ConnectionFactory factory = new ConnectionFactory();
        RabbitTemplate rabbitTemplate = new RabbitTemplate(new CachingConnectionFactory(factory));
        rabbitTemplate.convertAndSend("notification", objectMapper.writeValueAsString(submitModel));
        System.out.println(" [x] Sent new follow message");
    }

}