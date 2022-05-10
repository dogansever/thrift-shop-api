package com.sever.thriftshopapi.daos.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "GOODS")
@Data
public class GoodEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column
    private BigDecimal startingPriceAmount;

    @Column
    private String startingPriceCurrency;

    @Column
    private String startingPriceCurrencyShortName;
}
