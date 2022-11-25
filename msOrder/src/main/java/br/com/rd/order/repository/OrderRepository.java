package br.com.rd.order.repository;

import br.com.rd.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByClientCpf(String cpf);
    Optional<Order> findByNumber(Long number);
}
