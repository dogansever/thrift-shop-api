package com.sever.thriftshopapi.controllers;

import com.sever.thriftshopapi.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/health")
    public HealthResponse getHeaders(@RequestHeader MultiValueMap<String, String> headers) {
        return HealthResponse.builder().headers(headers).build();
    }

    @GetMapping("/{id}")
    public GoodDto getById(@PathVariable("id") Long id) {
        return GoodDto.builder().
                id(new GoodId(id))
                .name("Shirt")
                .description("A red shirt with a bunny on front")
                .startingPrice(new Price(new PriceAmount(BigDecimal.valueOf(2.5d)), new Currency("Dollars", "USD"))).build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody @Validated GoodDto dto) {
        return 1l;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody @Validated GoodDto dto) {
        //todo check id exists
        //todo save
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        //todo check id exists
    }

}
