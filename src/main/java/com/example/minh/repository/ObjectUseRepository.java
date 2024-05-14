package com.example.minh.repository;

import com.example.minh.entity.Color;
import com.example.minh.entity.ObjectUse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ObjectUseRepository extends JpaRepository<ObjectUse, Long> {

    Optional<ObjectUse> findObjectUseByObjectUseName(String objectUseName);

    @Query(value = "select object_use_name " +
            "from web_clone.object_use ou join web_clone.object_use_product oup on ou.id = oup.object_use_id " +
            "where oup.product_id = :productID", nativeQuery = true)
    List<String> findObjectUseByProductId(UUID productID);

}
