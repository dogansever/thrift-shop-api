package com.sever.thriftshopapi.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {
    private final String error;
}
