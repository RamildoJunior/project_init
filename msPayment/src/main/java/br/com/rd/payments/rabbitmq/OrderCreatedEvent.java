package br.com.rd.payments.rabbitmq;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderCreatedEvent {

    private Long id;
    private BigDecimal totalValue;
    private String clientCpf;
    private Long number;

}
