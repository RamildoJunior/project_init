package br.com.payments.service;

import br.com.payments.model.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.payments.repository.PaymentRepository;


import java.util.List;

@Service
public class PaymentServiceImp implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Payment> list() {
      return repository.findAll();
    }

    @Override
    public Payment findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public List<Payment> findByCpf(String cpf) { return repository.findByCpf(cpf);
    }


}
