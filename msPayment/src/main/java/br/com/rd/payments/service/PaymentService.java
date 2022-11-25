package br.com.rd.payments.service;

import br.com.rd.payments.model.Payment;
import java.util.List;

public interface PaymentService {

    Payment findById(Long id);

    List<Payment> findByCpf(String cpf);

    void save(Payment payment);
}
