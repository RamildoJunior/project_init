package br.com.order.service;

import br.com.order.model.Order;
import br.com.order.repository.ItemRepository;
import br.com.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.order.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImp  implements  OrderService {

  @Autowired
   OrderRepository orderRepository;

  @Autowired
   ItemRepository itemRepository;

  @Autowired
   ClientRepository clientRepository;

  @Autowired
  public OrderServiceImp(){
    this.orderRepository = orderRepository;
  }

  @Override
  public Order create(Order order) {
    clientRepository.save(order.getClient());
    order.getItems().stream()
            .forEach(item -> itemRepository.save(item));
    order.calcTotalValue();
    return orderRepository.save(order);
  }

  @Override
  public Order findById(Long id) {
    return orderRepository.findById(id).orElseThrow(() -> new NoSuchElementException() );
  }

  @Override
  public List<Order> findByCpf(String cpf) {
    return orderRepository.findByCpf(cpf);
  }

  @Override
  public Order findByNumber(Long number) {
    return  orderRepository.findByNumber(number).get();
  }

}
