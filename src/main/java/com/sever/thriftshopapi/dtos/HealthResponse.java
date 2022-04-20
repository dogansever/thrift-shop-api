package com.sever.thriftshopapi.dtos;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.MultiValueMap;

@Builder
@Getter
public class HealthResponse {
    private final MultiValueMap<String, String> headers;
}
