package br.com.mateus.consumer.endpoint.domain;

import java.io.Serializable;

public class SystemMessage implements Serializable {

    private String source;
    private String message;

    public SystemMessage(String source, String message){
        this.source = source;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
                "Source: '" + source + '\'' +
                ", Message: '" + message + '\'' +
                '}';
    }
}
