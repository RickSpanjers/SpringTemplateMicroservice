package nl.hrmanagement.template.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Queue;
import javax.annotation.PostConstruct;

@Service
public class TaskSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @PostConstruct
    public void send() {
        try {
            for (int i = 0; i < 5; i++) {
                String message = "hello" + i;
                template.convertAndSend(queue.getName(), message);
                System.out.println(" [x] Sent '" + message + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}