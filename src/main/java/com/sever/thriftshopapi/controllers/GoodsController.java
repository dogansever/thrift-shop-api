package com.sever.thriftshopapi.controllers;

import com.sever.thriftshopapi.dtos.GoodDto;
import com.sever.thriftshopapi.dtos.HealthResponse;
import com.sever.thriftshopapi.services.GoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {

    private final GoodService goodService;

    @GetMapping("/health")
    public HealthResponse getHeaders(@RequestHeader MultiValueMap<String, String> headers) {
        return HealthResponse.builder().headers(headers).build();
    }

    @GetMapping("")
    public List<GoodDto> getAll(@RequestHeader MultiValueMap<String, String> headers) {
        return goodService.getAll();
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    public GoodDto getById(@PathVariable("id") Long id) {
        return goodService.getById(id);
    }

    @GetMapping(value = "/{id}", produces = "application/api.v2+json")
    public GoodDto getByIdv2(@PathVariable("id") Long id) {
        return goodService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody @Validated GoodDto dto) {
        return goodService.create(dto);
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
