package com.sever.thriftshopapi.services;

import com.sever.thriftshopapi.daos.GoodRepository;
import com.sever.thriftshopapi.daos.entities.GoodEntity;
import com.sever.thriftshopapi.dtos.Currency;
import com.sever.thriftshopapi.dtos.GoodDto;
import com.sever.thriftshopapi.dtos.Price;
import com.sever.thriftshopapi.dtos.PriceAmount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        goodEntity.setStartingPriceAmount(dto.getStartingPrice().getAmount().getValue());
        goodEntity.setStartingPriceCurrency(dto.getStartingPrice().getCurrency().getName());
        goodEntity.setStartingPriceCurrencyShortName(dto.getStartingPrice().getCurrency().getShortName());
        goodRepository.save(goodEntity);
        return goodEntity.getId();
    }

    @Override
    public List<GoodDto> getAll() {
        List<GoodEntity> goodEntityList = goodRepository.findAll();
        return goodEntityList.stream().map(this::toGoodDto).collect(Collectors.toList());
    }

    @Override
    public GoodDto getById(Long id) {
        Optional<GoodEntity> optionalGoodEntity = goodRepository.findById(id);
        GoodEntity e = optionalGoodEntity.orElse(new GoodEntity());
        return toGoodDto(e);
    }

    private GoodDto toGoodDto(GoodEntity e) {
        return GoodDto.builder()
                .name(e.getName())
                .description(e.getDescription())
                .startingPrice(new Price(new PriceAmount(e.getStartingPriceAmount()), new Currency(e.getStartingPriceCurrency(), e.getStartingPriceCurrencyShortName())))
                .build();
    }
}
