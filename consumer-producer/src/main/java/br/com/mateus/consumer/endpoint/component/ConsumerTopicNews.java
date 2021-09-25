package br.com.mateus.consumer.endpoint.component;

import br.com.mateus.consumer.endpoint.domain.SystemMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerTopicNews {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerTopicNews.class);

    @JmsListener(destination = "topic-news", id = "nw1")
    public void receiveTopicNews(SystemMessage systemMessage){
        try{
            LOGGER.info("Topic News - Message Received: " + systemMessage);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
