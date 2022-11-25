package br.com.rd.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.rd.order.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
