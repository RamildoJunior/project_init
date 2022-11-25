package br.com.rd.order.rabbit;

import br.com.rd.order.model.PaymentStatus;
import lombok.Data;

@Data
public class PaymentCreatedEvent {

    private Long id;
    private PaymentStatus status;
}
