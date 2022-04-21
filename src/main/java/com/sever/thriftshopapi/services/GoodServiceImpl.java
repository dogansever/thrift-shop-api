package com.sever.thriftshopapi.services;

import com.sever.thriftshopapi.daos.GoodRepository;
import com.sever.thriftshopapi.daos.entities.GoodEntity;
import com.sever.thriftshopapi.dtos.GoodDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoodServiceImpl implements GoodService {

    private final GoodRepository goodRepository;

    @Override
    public Long create(GoodDto dto) {
        GoodEntity goodEntity = new GoodEntity();
        goodEntity.setName(dto.getName());
        goodEntity.setDescription(dto.getDescription());
        goodRepository.save(goodEntity);
        return goodEntity.getId();
    }
}
