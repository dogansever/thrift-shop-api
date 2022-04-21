package com.sever.thriftshopapi.services;

import com.sever.thriftshopapi.dtos.GoodDto;

public interface GoodService {
    Long create(GoodDto dto);
}
