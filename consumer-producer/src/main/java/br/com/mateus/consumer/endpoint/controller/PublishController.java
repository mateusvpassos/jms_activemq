package br.com.mateus.consumer.endpoint.controller;

import br.com.mateus.consumer.endpoint.domain.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Topic;

@RestController
public class PublishController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/publishQueueFinance")
    public ResponseEntity<String> publishQueueMessage(@RequestBody SystemMessage systemMessage){
        try{
            Destination queue = jmsTemplate.getConnectionFactory().createConnection()
                    .createSession().createTopic("q-finance");
            jmsTemplate.convertAndSend(queue, systemMessage);

            return new ResponseEntity<>("Sent to Queue Finance", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/publishTopicStore")
    public ResponseEntity<String> publishTopicStore(@RequestBody SystemMessage systemMessage){
        try{
            Topic topic = jmsTemplate.getConnectionFactory().createConnection()
                    .createSession().createTopic("topic-store");
            jmsTemplate.convertAndSend(topic, systemMessage);

            return new ResponseEntity<>("Sent to Topic Store", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/publishTopicNews")
    public ResponseEntity<String> publishTopicNews(@RequestBody SystemMessage systemMessage){
        try{
            Topic topic = jmsTemplate.getConnectionFactory().createConnection()
                    .createSession().createTopic("topic-news");
            jmsTemplate.convertAndSend(topic, systemMessage);

            return new ResponseEntity<>("Sent to Topic News", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
