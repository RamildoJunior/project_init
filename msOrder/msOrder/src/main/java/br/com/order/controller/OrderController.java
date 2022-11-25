package br.com.order.controller;

import br.com.order.controller.assembler.OrderAssembler;
import br.com.order.controller.dto.OrderDto;
import br.com.order.controller.form.OrderForm;
import br.com.order.model.Order;
import br.com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @Autowired
    OrderAssembler assembler;

    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderForm orderForm){
        Order order = assembler.aEntity(orderForm);
        order = service.create(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(assembler.aDto(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        Optional<Order> order = Optional.ofNullable(service.findById(id));
        return ResponseEntity.ok(assembler.aDto(order.get()));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<Order>> findByCpf(@PathVariable String cpf) {
        List<Order> order = service.findByCpf(cpf);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/number/{number}")
    public ResponseEntity<OrderDto> findByNumber(@PathVariable Long number) {
        Optional<Order> order = Optional.ofNullable(service.findByNumber(number));
        return ResponseEntity.ok(assembler.aDto(order.get()));
    }
}
