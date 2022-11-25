package br.com.order.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "tb_orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    @ManyToOne
    private Client client;

    private BigDecimal totalValue;


    @Enumerated(EnumType.STRING)
    private Status status = Status.PEDIDO_CRIADO;

    @ManyToMany
    private List<Item> items;

    private String cpf;


    public void calcTotalValue() {
        this.totalValue = BigDecimal.ZERO;
        this.items.stream().forEach(item -> this.totalValue
                = this.totalValue.add(item.getPrice().
                multiply(new BigDecimal(item.getQuantity()))));

    }

    }

