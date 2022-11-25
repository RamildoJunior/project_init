package br.com.order.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemDto {

    private Long id;
    private String nameItems;
    private BigDecimal price;
    private Integer quantity;
}
