package br.com.mateus.consumer.endpoint.component;

import br.com.mateus.consumer.endpoint.domain.SystemMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerQueueFinance {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerQueueFinance.class);

    @JmsListener(destination = "q-finance")
    public void receiveQueue(SystemMessage systemMessage){
        try{
            LOGGER.info("Finance Queue - Message Received: " + systemMessage);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

}
