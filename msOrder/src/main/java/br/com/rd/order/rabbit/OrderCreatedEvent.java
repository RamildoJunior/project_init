package br.com.rd.order.rabbit;


import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderCreatedEvent {

    private Long id;
    private BigDecimal totalValue;
    private String clientCpf;
    private Long number;

}
