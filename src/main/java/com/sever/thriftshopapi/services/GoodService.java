package com.sever.thriftshopapi.services;

import com.sever.thriftshopapi.dtos.GoodDto;

import java.util.List;

public interface GoodService {
    Long create(GoodDto dto);

    List<GoodDto> getAll();
}
