package com.practica.edp.domain.coupon.infrastructure;

import com.practica.edp.domain.coupon.domain.AssignedCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignedCouponRepository extends JpaRepository<AssignedCoupon, Long> {
}
