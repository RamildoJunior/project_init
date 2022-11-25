package br.com.rd.order.controller;

import br.com.rd.order.controller.assembler.OrderAssembler;
import br.com.rd.order.model.Order;
import br.com.rd.order.controller.dto.OrderDTO;
import br.com.rd.order.rabbit.OrderCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.rd.order.controller.form.OrderForm;
import br.com.rd.order.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderAssembler assembler;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<OrderDTO> create (@RequestBody OrderForm orderForm){
        Order order = assembler.aEntity(orderForm);
        order = orderService.create(order);
        String exchange = "order.v1.order-created";
        OrderCreatedEvent event = assembler.entityEvent(order);
        rabbitTemplate.convertAndSend(exchange,"" , event);
        return ResponseEntity.status(HttpStatus.CREATED).body(assembler.aDto(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
        Optional<Order> order = Optional.ofNullable(orderService.findById(id));
        return ResponseEntity.ok(assembler.aDto(order.get()));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<OrderDTO>> findByCpf(@PathVariable String cpf){
        List<Order> orderList = orderService.findByCpf(cpf);
        return ResponseEntity.ok(assembler.aCollectionDto(orderList));

    }

    @GetMapping("/number/{number}")
    public ResponseEntity<OrderDTO> findByNumber(@PathVariable Long number){
        Optional<Order> order = Optional.ofNullable(orderService.findByNumber(number));
        return ResponseEntity.ok(assembler.aDto(order.get()));
    }
}
