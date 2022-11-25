package br.com.rd.payments.rabbitmq;

import br.com.rd.payments.model.PaymentStatus;
import lombok.Data;

@Data
public class PaymentCreatedEvent {

    private Long id;
    private PaymentStatus status;
}
