package br.com.order.service;


import br.com.order.model.Order;


import java.util.List;

public interface OrderService {


    Order create(Order order);

    Order findById(Long id);

    List<Order> findByCpf(String cpf);

    Order findByNumber(Long number);


}
