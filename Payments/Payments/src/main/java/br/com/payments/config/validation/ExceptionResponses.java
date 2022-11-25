package br.com.payments.config.validation;

import lombok.Data;

import java.util.List;

@Data
public class ExceptionResponses {
    private int status_code;

    private List<String> messages;

    public ExceptionResponses(int status_code, List<String> messages) {

        this.status_code = status_code;
        this.messages = messages;
    }
}
