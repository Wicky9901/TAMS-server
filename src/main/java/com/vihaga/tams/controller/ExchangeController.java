package com.vihaga.tams.controller;

import com.vihaga.tams.model.Exchange;
import com.vihaga.tams.repository.ExchangeRepository;
import com.vihaga.tams.service.impl.ExchangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tams/api")
public class ExchangeController {

    @Autowired
    private ExchangeServiceImpl ExchangeRepository;

    @Autowired
    private ExchangeRepository exchangeRepository;


    @PostMapping()
    public Exchange create(@RequestBody Exchange exchange) {
        return exchangeRepository.save(exchange);
    }

    @GetMapping()
    public List<Exchange> readAll() {
        return exchangeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Exchange> readById(@PathVariable Integer id) {
        return exchangeRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Exchange updateById(@PathVariable Integer id,@RequestBody Exchange exchange) {
        Optional<Exchange> optionalExchange = exchangeRepository.findById(id);
        if(optionalExchange.isPresent()){
            Exchange oldExchange =optionalExchange.get();

            //todo

            return exchangeRepository.save(oldExchange);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        exchangeRepository.deleteById(id);
    }


}
