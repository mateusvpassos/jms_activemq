package br.com.mateus.consumer.endpoint.component;

import br.com.mateus.consumer.endpoint.domain.SystemMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerTopicStore {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerTopicStore.class);

    @JmsListener(destination = "topic-store", id = "st1", subscription = "sub")
    public void receiveTopicStoreOne(SystemMessage systemMessage){
        try{
            LOGGER.info("Topic Store One - Message Received: " + systemMessage);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

}
