package com.example.minh.repository;

import com.example.minh.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, UUID> {
}
