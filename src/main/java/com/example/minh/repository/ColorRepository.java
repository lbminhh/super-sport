package com.example.minh.repository;

import com.example.minh.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    Optional<Color> findColorByColorName(String colorName);

    @Query(value = "select color_name " +
            "from web_clone.color c join web_clone.product_color pc on c.id = pc.color_id " +
            "where pc.product_id = :productID", nativeQuery = true)
    List<String> findColorByProductId(UUID productID);
}
