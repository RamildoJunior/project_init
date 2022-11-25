package br.com.rd.payments.controller.dto;

import br.com.rd.payments.model.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class PaymentDTO {

    private Long id;
    private BigDecimal totalValue;
    private String clientCpf;
    private Long number;
    private PaymentStatus paymentStatus;
}
