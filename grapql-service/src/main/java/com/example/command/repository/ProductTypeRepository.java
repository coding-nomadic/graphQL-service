package com.example.command.repository;

import com.example.command.entity.ProductType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

    /**
     *
     * @param name
     * @return
     */
    @Query(value = "select id from alarm.tbl_product_type where name = :name", nativeQuery = true)
    Optional<Integer> getIdByName(String name);
}
