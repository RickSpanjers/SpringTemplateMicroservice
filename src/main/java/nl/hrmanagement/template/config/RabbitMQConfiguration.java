package nl.hrmanagement.template.config;

import nl.hrmanagement.template.rabbitmq.TaskReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue hello() {
        return new Queue("attendance");
    }

    private static class ReceiverConfig {

        @Bean
        public TaskReceiver receiver() {
            return new TaskReceiver();
        }

    }

}
