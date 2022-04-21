package com.sever.thriftshopapi.daos.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GOODS")
@Data
public class GoodEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
}
