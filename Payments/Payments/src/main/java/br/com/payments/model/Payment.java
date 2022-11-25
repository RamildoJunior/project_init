package br.com.payments.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tb_payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal totalValue;

    @NotNull
    private String cpf;

    @NotNull
    private String number;

    @NotNull @Enumerated(EnumType.STRING)
    private Status status;


}
