package br.com.order.controller.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperrConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
