package com.sever.thriftshopapi.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Price {

    @NotNull
    @Valid
    PriceAmount amount;

    @NotNull
    @Valid
    Currency currency;
}
