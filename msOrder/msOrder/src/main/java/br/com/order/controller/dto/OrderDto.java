package br.com.order.controller.dto;

import br.com.order.model.Client;
import br.com.order.model.Item;
import br.com.order.model.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Long number;
    private Client client;
    private BigDecimal totalValue;
    private Status status;
    private List<Item> items;
    private String cpf;

}