package com.example.minh.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerFavoriteKey implements Serializable {

    @Column(name = "customer_id")
    UUID customerID;

    @Column(name = "product_detail_id")
    UUID productDetailID;

}
