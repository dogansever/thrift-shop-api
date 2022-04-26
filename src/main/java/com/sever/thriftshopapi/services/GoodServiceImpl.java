package com.sever.thriftshopapi.services;

import com.sever.thriftshopapi.daos.GoodRepository;
import com.sever.thriftshopapi.daos.entities.GoodEntity;
import com.sever.thriftshopapi.dtos.GoodDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<GoodDto> getAll() {
        List<GoodEntity> goodEntityList = goodRepository.findAll();
        return goodEntityList.stream().map(e -> GoodDto.builder().name(e.getName()).description(e.getDescription()).build()).collect(Collectors.toList());
    }
}
