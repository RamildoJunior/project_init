package br.com.rd.order.rabbit;

import br.com.rd.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentCreatedListener {
    @Autowired
    OrderService orderService;

    @RabbitListener(queues = "order.payment-created.confirm-order")
    public void paymentCreated(PaymentCreatedEvent event) {
        orderService.change(event);

    }

}
