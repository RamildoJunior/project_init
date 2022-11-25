package br.com.order.controller.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import br.com.order.model.Client;
import br.com.order.model.Item;

import java.util.List;
@Data
@AllArgsConstructor
public class OrderForm {
    private Long number;
    private Client client;
    private List<Item> items;


}
