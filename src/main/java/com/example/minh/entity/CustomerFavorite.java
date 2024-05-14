package com.example.minh.entity;

import com.example.minh.model.keys.CustomerFavoriteKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "customer_favorite")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerFavorite {

    @EmbeddedId
    CustomerFavoriteKey customerFavoriteKey;

    @ManyToOne
    @MapsId("productDetailID")
    @JoinColumn(name = "product_detail_id")
    ProductDetail productDetail;

    @ManyToOne
    @MapsId("customerID")
    @JoinColumn(name = "customer_id")
    Customer customer;
}
