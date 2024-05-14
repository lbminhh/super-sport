package com.example.minh.entity;

import com.example.minh.model.response.ProductResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FetchType;
import jakarta.persistence.FieldResult;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(name = "product_name")
    String productName;

    @Column(name = "status")
    Integer status;

    @Column(name = "description")
    String description;

    @Column(name = "time_create")
    @CreationTimestamp
    Timestamp timeCreate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_category_id")
    SubCategory subCategory;

    @ManyToMany
    @JoinTable(name = "object_use_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "object_use_id"))
    Set<ObjectUse> objectUses = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "product_color", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "color_id"))
    Set<Color> colors = new HashSet<>();

}
