package com.practica.edp.domain.coupon.infrastructure;

import com.practica.edp.domain.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findBySerialNumber(UUID serialNumber);
}
