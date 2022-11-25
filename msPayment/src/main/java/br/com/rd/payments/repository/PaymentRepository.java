package br.com.rd.payments.repository;

import br.com.rd.payments.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> getByClientCpf(String cpf);
}
