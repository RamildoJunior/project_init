package br.com.rd.payments.rabbitmq;

import br.com.rd.payments.controller.assembler.PaymentAssembler;
import br.com.rd.payments.service.PaymentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedListener {

    @Autowired
    PaymentService paymentService;
    @Autowired
    PaymentAssembler dtoAssembler;

    @RabbitListener(queues = "order.order-created.generate-payment")
    public void OrderCreated(OrderCreatedEvent event){
        paymentService.save(dtoAssembler.eventToEntity(event));

    }

}
