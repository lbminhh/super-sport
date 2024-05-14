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
public class CustomerEvaluateKey implements Serializable {

    @Column(name = "customerID")
    UUID customerID;

    @Column(name = "evaluteID")
    UUID evaluteID;

}
