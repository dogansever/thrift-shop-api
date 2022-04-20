package com.sever.thriftshopapi.dtos;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
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
