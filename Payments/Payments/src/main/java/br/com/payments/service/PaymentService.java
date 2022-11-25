package br.com.payments.service;

import br.com.payments.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> list();

    Payment findById(Long id);

   List<Payment> findByCpf(String cpf);
}
