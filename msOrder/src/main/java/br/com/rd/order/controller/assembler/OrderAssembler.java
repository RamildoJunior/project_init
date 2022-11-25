package br.com.rd.order.controller.assembler;


import br.com.rd.order.controller.form.OrderForm;
import br.com.rd.order.model.Order;
import br.com.rd.order.controller.dto.OrderDTO;
import br.com.rd.order.rabbit.OrderCreatedEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO aDto(Order order){
        return modelMapper.map(order, OrderDTO.class);
    }

    public List<OrderDTO> aCollectionDto(List<Order> orderList) {
        return orderList.stream().map(order -> aDto(order))
                .collect(Collectors.toList());
    }
    public OrderCreatedEvent entityEvent(Order order) {
        return modelMapper.map(order, OrderCreatedEvent.class);

    }

    public Order aEntity(OrderForm orderForm){
        return modelMapper.map(orderForm, Order.class);
    }
}
