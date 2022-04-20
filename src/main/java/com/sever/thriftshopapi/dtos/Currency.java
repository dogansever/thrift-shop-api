package com.sever.thriftshopapi.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Currency {

    @NotBlank
    String name;

    @NotBlank
    @Size(min = 3, max = 3)
    String shortName;
}
