package com.sever.thriftshopapi.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FailResponse {
    private final String message;
}
