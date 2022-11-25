package br.com.payments.controller;

import br.com.payments.service.PaymentServiceImp;
import br.com.payments.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentServiceImp service;

    @GetMapping
    public List<Payment> list() { return service.list();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> finById(@PathVariable Long id) {
        Payment payments= service.findById(id);
        return ResponseEntity.ok(payments);
    }


    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<Payment>> findByCpf(@PathVariable String cpf) {
        List<Payment> payment = service.findByCpf(cpf);
        return ResponseEntity.ok(payment);
    }

}
