package br.com.rd.payments.controller.form;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentForm {

    private BigDecimal totalValue;
    private String cpf;
}
