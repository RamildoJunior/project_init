package br.com.order.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class ClientDto {

    private Long id;
    private String nameClient;
    private String cpf;
}
