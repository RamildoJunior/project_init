package br.com.rd.order.controller.form;

import br.com.rd.order.model.Client;
import br.com.rd.order.model.Item;
import br.com.rd.order.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderForm {
    
    private Long number;
    private Client client;
    private List<Item> items;


}
