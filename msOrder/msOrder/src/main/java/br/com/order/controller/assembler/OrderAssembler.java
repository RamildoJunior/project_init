package br.com.order.controller.assembler;

import br.com.order.controller.dto.OrderDto;
import br.com.order.controller.form.OrderForm;
import br.com.order.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public Order aEntity(OrderForm orderForm){
        return modelMapper.map(orderForm, Order.class);
    }


    public OrderDto aDto(Order order){
        return modelMapper.map(order, OrderDto.class);
    }

    public List<OrderDto> aCollectionDto(List<Order> orderList) {
        return orderList.stream().map(order -> aDto(order))
                .collect(Collectors.toList());
    }
//    public OrderCreatedEvent entityToEvent(Order order) {
//        return modelMapper.map(order, OrderCreatedEvent.class);
//
//    }



}
