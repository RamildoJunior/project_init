package br.com.rd.payments.controller.assembler;

import br.com.rd.payments.controller.dto.PaymentDTO;
import br.com.rd.payments.controller.form.PaymentForm;
import br.com.rd.payments.model.Payment;
import br.com.rd.payments.rabbitmq.OrderCreatedEvent;
import br.com.rd.payments.rabbitmq.PaymentCreatedEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public PaymentDTO toDto(Payment payment){
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public List<PaymentDTO> toCollectionDto(List<Payment> orderList) {
        return orderList.stream().map(payment -> toDto(payment))
                .collect(Collectors.toList());
    }
    public Payment eventToEntity(OrderCreatedEvent event) {
        return modelMapper.map(event, Payment.class);
    }
    public PaymentCreatedEvent entityToEvent(Payment payment) {
        return modelMapper.map(payment, PaymentCreatedEvent.class);
    }

    public Payment aEntity(PaymentForm paymentForm){
        return modelMapper.map(paymentForm, Payment.class);
    }

}
