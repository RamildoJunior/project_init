package br.com.rd.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.rd.order.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
