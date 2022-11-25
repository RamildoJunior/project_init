package br.com.rd.payments.service;

import br.com.rd.payments.controller.assembler.PaymentAssembler;
import br.com.rd.payments.model.Payment;
import br.com.rd.payments.model.PaymentStatus;
import br.com.rd.payments.rabbitmq.PaymentCreatedEvent;
import br.com.rd.payments.repository.PaymentRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PaymentAssembler dtoAssembler;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public List<Payment> findByCpf(String cpf) {
        return paymentRepository.getByClientCpf(cpf);
    }

    @Override
    public void save(Payment payment) {

        if(payment.getTotalValue().compareTo(BigDecimal.valueOf(1000))>=0){
            payment.setPaymentStatus(PaymentStatus.NAO_AUTORIZADO);
        }else{
            payment.setPaymentStatus(PaymentStatus.CONFIRMADO);
        }
        String exchange = "order.payment";
        PaymentCreatedEvent event = dtoAssembler.entityToEvent(payment);
        rabbitTemplate.convertAndSend(exchange,"" , event);
        paymentRepository.save(payment);
    }

}
