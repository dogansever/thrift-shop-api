package com.sever.thriftshopapi.dtos;

import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
public class GoodDto {

    private GoodId id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @Valid
    private Price startingPrice;
}
