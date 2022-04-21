package com.sever.thriftshopapi.daos;

import com.sever.thriftshopapi.daos.entities.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepository extends JpaRepository<GoodEntity, Long> {
}
