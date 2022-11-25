package br.com.rd.order.service;

import br.com.rd.order.model.Order;
import br.com.rd.order.rabbit.PaymentCreatedEvent;

import java.util.List;

public interface OrderService {

    Order create(Order order);
    Order findById(Long id);
    List<Order> findByCpf(String cpf);
    Order findByNumber(Long number);
    Order change(PaymentCreatedEvent event);

}


