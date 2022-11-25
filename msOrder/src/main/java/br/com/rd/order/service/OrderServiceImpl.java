package br.com.rd.order.service;

import br.com.rd.order.model.PaymentStatus;
import br.com.rd.order.model.Status;
import br.com.rd.order.rabbit.PaymentCreatedEvent;
import br.com.rd.order.repository.ClientRepository;
import br.com.rd.order.repository.ItemRepository;
import br.com.rd.order.repository.OrderRepository;
import br.com.rd.order.model.Item;
import br.com.rd.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    public OrderServiceImpl() {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        clientRepository.save(order.getClient());
        order.getItems().stream().
                forEach(item -> itemRepository.save(item));
        for (Item item : order.getItems()) {
            itemRepository.save(item);
        }
        order.calcTotalValue();
        return orderRepository.save(order);
    }
    @Override
    public Order change(PaymentCreatedEvent event) {
        Order orderChange = orderRepository.findById(event.getId()).get();
        if(event.getStatus().equals(PaymentStatus.CONFIRMADO)){
            orderChange.setStatus(Status.CONFIRMADO);
        }else{
            orderChange.setStatus(Status.NÃO_AUTORIZADO);
        }
        return orderRepository.save(orderChange);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findByCpf(String cpf) {
        return orderRepository.findByClientCpf(cpf);
    }

    @Override
    public Order findByNumber(Long number) {
        return orderRepository.findByNumber(number).get();
    }



}
