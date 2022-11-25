package br.com.payments.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.payments.model.Status;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto {

    
    private Long id;
    private BigDecimal totalvalue;
    private String cpf;
    private String number;
    private Status status;

}
