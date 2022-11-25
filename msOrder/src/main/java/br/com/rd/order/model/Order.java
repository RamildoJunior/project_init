package br.com.rd.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;
    @ManyToOne
    private Client client;
    private BigDecimal totalValue;
    @Enumerated(EnumType.STRING)
    private Status status = Status.CRIADO;
    @ManyToMany
    private List<Item> items;


    public void calcTotalValue() {
        this.totalValue = BigDecimal.ZERO;
        this.items.stream().forEach(item -> this.totalValue
                = this.totalValue.add(item.getPrice().
                multiply(new BigDecimal(item.getQuantity()))));
    }
}
