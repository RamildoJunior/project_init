package br.com.rd.payments.controller;

import br.com.rd.payments.controller.assembler.PaymentAssembler;
import br.com.rd.payments.controller.dto.PaymentDTO;
import br.com.rd.payments.model.Payment;
import br.com.rd.payments.service.PaymentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;
    @Autowired
    PaymentAssembler assembler;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable Long id){
        Optional<Payment> order = Optional.ofNullable(paymentService.findById(id));
        return ResponseEntity.ok(assembler.toDto(order.get()));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<PaymentDTO>> findByCpf(@PathVariable String cpf){
        List<Payment> orderList = paymentService.findByCpf(cpf);
        return ResponseEntity.ok(assembler.toCollectionDto(orderList));

    }
}
