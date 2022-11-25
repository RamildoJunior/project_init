package br.com.rd.order.controller.dto;

import br.com.rd.order.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import br.com.rd.order.model.Client;
import br.com.rd.order.model.Item;
import br.com.rd.order.model.Status;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

        private Long id;
        private Long number;
        private Client client;
        private BigDecimal totalValue;
        private Status status;
        private List<Item> items;
}


